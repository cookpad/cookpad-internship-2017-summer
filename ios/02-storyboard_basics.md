# 講義2 Storyboard を用いた画面の設定

最初の画面として **投稿一覧画面** を実装します。

iOS アプリの画面はいろいろな方法で実装することができますが、今回は以下の方針で実装します。

- 要素のレイアウトは Storyboard 上で行い、 AutoLayout を使う
- UITableView を使う
- UITableViewCell を継承したカスタムセルのクラスを作る

まず、投稿一覧画面の ViewController クラスの作成と Storyboard への関連付けを行います。
その後、投稿一覧画面の各要素を配置します。

## 画面例

![](./images/20170801071054_img20170801-24-a8djqh.png)

## 画面の処理を記述する ViewController クラスを作る

プロジェクトに `PostListViewController` クラスのファイルを追加します。
ViewController グループを右クリックし、 `New File...` を選択してファイルを追加します。

![](./images/20170801071152_img20170801-22-7k5uee.png)

テンプレートは Cocoa Touch Class を選択してください。

以下の情報を入力してファイルを作成します。

- Class: PostListViewController
- Subclass of: UITableViewController
- Language: Swift

![](./images/20170801071210_img20170801-18-1m529tb.png)

## TabBarController に新しい画面を追加する

`Main.Storyboard` ファイルを編集しておすすめ商品一覧画面の設定を行います。
`Main.Storyboard` の初期状態は以下のようになっています。

![](./images/20170801071231_img20170801-13-1rxrrjt.png)

`FirstView` と `SecondView` を消して新しく `TableViewController` を追加します。
プロジェクトに元から存在する *FirstViewController.swift* 、 *SecondViewController.swift* のファイルも削除してしまいましょう。

右ペインのリストから `Table View Controller` を選択して真ん中の領域にドラッグアンドドロップします。

![](./images/20170801071249_img20170801-15-1lupsty.png)

次に、左にある Tab Bar Controller を Ctrl を押しながらクリックし、青い線を右の TableViewController に伸ばして離すと、画像の様なメニューが表示されるので `view controllers` を選択します。

![](./images/20170801071305_img20170801-18-12tjzfk.png)

うまくいくと以下の画像のように線で結ばれます。この操作を行うことで一つだけのタブを持ち TableViewController を表示するように設定することができました。

![](./images/20170801071321_img20170801-15-1nxy4ha.png)

## TableViewController に PostListViewController クラスをひも付ける

追加した TableViewController を選択し、先ほどファイルを追加した PostListViewController クラスとひも付けます。
画面を選択後右ペインの項目を切り替えて、 Custom Class の項目を `PostListViewController` にします。

![](./images/20170801071337_img20170801-15-adt6ur.png)

また、設定した TableViewController を選択した状態で `Editor > Embed In > Navigation Controller` を選択すると選択した ViewController を NavigationController の中に入れることができます。

![](./images/20170801071351_img20170801-21-1p904th.png)

ナビゲーションバーのタイトルも設定します。
ダブルクリックするとタイトルを入力できるので、ここでは "Posts" としておきましょう。

![](./images/20170801071411_img20170801-13-elx4yt.png)

ここまで設定すると、以下の画像のようになります。

![](./images/20170801071434_img20170801-13-1olg0hg.png)

ここまで設定できたら、ビルドしてアプリケーションを実行します。
空っぽの投稿一覧画面ができました。

![](./images/20170801071452_img20170801-13-10yjoc8.png)