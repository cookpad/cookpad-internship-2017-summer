iOS アプリ開発入門

# 今日やること

簡単なアプリの実装を進めながら、iOSアプリ開発の基本を学ぶ。
Firebase というサービスを利用し、端末外のデータを取得して表示したりデータを保存・更新したりするアプリを実装できるようになる。

## 開発環境

- macOS Sierra 10.12.5
- iOS 10.3.2
- Xcode 8.3.3
- Swift 3.1

## 身に付けること

- iOS アプリ開発の基本
- iOS SDK の UIコンポーネントを使った画面の構築と画面間の遷移の実装

# 基礎知識

## iOS アプリとは

iOS が動く端末(iPhone、iPad など)で動作するアプリケーションのこと。

macOS 上で動作する Xcode というアプリケーションを使って Objective-C または Swift というプログラミング言語を用いて開発することができる。

## Swift とは

Apple が開発し 2014年に公開されたプログラミング言語である。 https://swift.org/

Swift が登場するまでは Objective-C, C, C++ などでアプリケーションが開発されていた。 今後はこの Swift を使って iOS アプリケーションを開発するのが主流となる。

- The Swift Programming Language - https://developer.apple.com/library/ios/documentation/Swift/Conceptual/Swift_Programming_Language/
- [ざっくり Swift 入門](./swift.md)

## Firebase とは

Google が提供しているモバイルアプリのための BaaS (Backend as a Service) である。
Firebase はモバイルアプリに必要な機能を実現する複数のサービスから成り立っている。ユーザ認証やデータベース、クラッシュレポート、ユーザイベント分析基盤など様々なものを自由に組み合わせてアプリに組み込むことができる。
講義では Realtime Database を利用してアプリのデータを保存する。

- Firebase - https://firebase.google.com/

# この講義で作成するアプリ

- [Cookpatodon](./cookpatodon_app.md)

# 講義の進め方

- アプリを完成させるまでの過程を複数のパートに分けています
- アプリ開発のやり方を説明しながら一緒に進める講義パートと自分のペースでアプリの機能追加を進める課題パートがあります
- 課題パートでは具体的な実装方法の説明をしないので、iOS SDKやライブラリのドキュメントを自分で読んで取り組んでください。どうしてもわからなければ講師やTAに質問すること。
- 各課題パートの項目では画面の実装例を出していますが、全くその通りに実装する必要はありません
- 課題をひと通り終えてしまった場合はアプリに必要だと思う機能を自分で考えて実装してみてください。機能や見た目、操作感など、こだわろうとするとたくさんやることを見つけられるはずです。

## 講義・実習過程

### iOSアプリ開発の基本編

- [講義1 プロジェクトの作成](./01-create_project.md)
- [講義2 Storyboard を用いた画面の設定](./02-storyboard_basics.md)
- [講義3 画面要素の配置](./03-set_up_tableviewcell.md)
- [講義4 TableView によるリストの表示](./04-show_list_with_tableview.md)

### Firebase Realtime Database を用いたデータ読み書きの基本編

- [講義5 Firebase SDK の導入](./05-introduce_firebase_sdk.md)
- [課題6 投稿一覧画面を実装する](./06-implement_post_list_view.md)
- [講義7 Storyboard を用いた画面遷移](./07-transition_screens.md)
- [課題1 メッセージ投稿画面を実装する](./08-implement_compose_view.md)
- [課題2 ユーザ情報登録画面を実装する](./09-implement_user_settings_view.md)

### 発展課題

- [発展課題1 自分のユーザ名を含む投稿に色を付ける](./10-advanced_colorize_mentioned_message.md)
- [発展課題2 文字数カウンタを実装する](./11-advanced_characters_counter.md)
- [発展課題3 共有したいURLを含めた投稿に対応する](./12-advanced_share_url.md)
