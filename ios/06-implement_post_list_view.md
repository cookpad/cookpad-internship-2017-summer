# 講義6 投稿一覧画面を実装する

この回では投稿一覧画面の実装を進めながら、Firebase Realtime Database の使い方を学びます。

## Realtime Database とは

Firebase Realtime Database はいわゆる NoSQL のデータベースであり、事前に定められたスキーマはなく JSON のような配列や辞書の構造をもったデータを記録するデータベースです。
アプリケーションとしてはこのデータベースのデータ構造の一部を監視することでその部分の更新をリアルタイムに取得でき、画面に反映させることができます。端末がオフラインであっても動作し、ネットワークに繋がった時点で差分をサーバに送信、場合によって競合が起きたとしてもそれを自動的に解決する仕組みがあります。複数の端末でデータを参照したり更新しても、SDKがそれらの変更を各端末へリアルタイムに反映してくれます。

[公式ドキュメント](https://firebase.google.com/docs/database/) をあわせて読むと理解が深まると思います。
API の使い方も公式に載っています。この資料だけでは足りない、他の機能も知りたいという人は公式ドキュメントを読みましょう。

## Cookpatodon プロジェクト

今日の講義ではあらかじめ準備している Cookpatodon プロジェクトへみなさんの実装するアプリから接続してもらいます。このプロジェクトでは前述した Realtime Database を利用しています。 各自で実装しているアプリからデータを読み書きすることで SNS サービスのような投稿されたメッセージがリアルタイムに画面に流れてくるアプリになるはずです。

今日の講義は iOS アプリ開発に焦点をあてているので、Firebase のサービスの設定に関する説明は省略します。興味があったり自分でこれを機会にFirebaseのサービスを利用してアプリを開発してみたいと思った人は公式ドキュメントや他の資料を参照して挑戦してみてください。

## Database に記録されているメッセージを取得する

Cookpatodon アプリのデータ構造は次のようになっています。 [Cookpatodon データ構造](./cookpatodon_app.md)

大きく `posts` と `users` というフィールドに分けられていて、`posts` の下に投稿データが追加されていきます。投稿一覧の画面では posts 以下の更新を監視すれば良さそうです。

PostListViewController を以下のように編集してください

```swift
import UIKit
import Firebase
import FirebaseDatabase

class PostListViewController: UITableViewController {
    let initialLoadPostsCount: UInt = 30

    var ref: DatabaseReference!
    var refHandle: DatabaseHandle!

    var posts: [Post] = []

    deinit {
        ref.child("posts").removeObserver(withHandle: refHandle)
    }

    override func viewDidLoad() {
        super.viewDidLoad()

        tableView.rowHeight = UITableViewAutomaticDimension
        tableView.estimatedRowHeight = PostCell.height

        setUpDatabase()
    }

    func setUpDatabase() {
        ref = Database.database().reference()

        refHandle = ref.child("posts").queryLimited(toLast: initialLoadPostsCount).observe(.childAdded, with: { [weak self] postSnapshot in
            guard let strongSelf = self else { return }

            guard let postSnapshotValue = postSnapshot.value as? [String: Any],
                let author = postSnapshotValue["author"] as? String,
                let authorName = postSnapshotValue["authorName"] as? String,
                let authorAvatar = postSnapshotValue["authorAvatar"] as? String,
                let body = postSnapshotValue["body"] as? String,
                let createDateTimeStamp = postSnapshotValue["createDate"] as? Double else {
                    fatalError("Unexpected snapshot")
            }

            let postID = postSnapshot.key
            let createDate = Date(timeIntervalSince1970: createDateTimeStamp / 1000)

            let post = Post(id: postID,
                            author: author,
                            authorName: authorName,
                            authorAvatar: authorAvatar,
                            body: body,
                            createDate: createDate)
            strongSelf.posts.insert(post, at: 0)
            strongSelf.tableView.insertRows(at: [IndexPath(row: 0, section: 0)], with: .automatic)
        })
    }

    // MARK: - Table view data source

    override func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return posts.count
    }

    override func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        guard let cell = tableView.dequeueReusableCell(withIdentifier: "PostCell", for: indexPath) as? PostCell else {
            fatalError("Invalid cell")
        }

        let post = posts[indexPath.row]
        cell.update(post: post)

        return cell
    }
}
```

大きく変わったところは、 `viewDidLoad()` から呼ばれる新しく追加した `setUpDatabase()` というメソッドです。
ここでは `ref` と `refHandle` というメンバ変数に値を代入しています。

DatabaseReference はその名の通りデータベースへの参照を、refHandle は監視のハンドルを表現するものです。
DatabaseReference を作成した後、そこから監視したいデータ構造のキー、今回で言えば `posts` を指定して変更を監視しています。
クエリによってデータベースから最初に取得する件数や抽出条件などを指定できます。詳しくは公式ドキュメントの説明にまかせます。

observe メソッドに指定している `.childAdded` はデータベースで起きたイベントのうちどういうイベントを監視するか指定するものです。`.childAdded` を指定しておくと、新しく子要素が追加されるたびに指定したブロックが実行されます。ここでは、新しくアイテムが追加されるたびにそのイベントのデータから Post 構造体を作成し、このViewControllerで管理しているリストに追加、テーブルビューにも新しい要素を追加(insertRows)ということを行っています。

deinit というメソッドはこの画面が破棄された時に呼ばれるメソッドです。
この画面が残っている限り常にRealtimeDatabaseの変更を監視していることになるので、この画面が必要なくなった時点で監視を解除するということを deinit メソッドで行っています。この解除を忘れてしまうと、監視がいつまでも残ってしまうことになります。

このように記述することで新しい投稿があるたびに画面のテーブルビューに要素を追加し、新しく投稿されたメッセージが画面にリアルタイムに更新されていくという動きを実装できました。