# 発展課題5 特定のユーザーの投稿一覧を表示する

- Post一覧でユーザーのアイコンをタップしたときに、そのユーザーの今までの投稿一覧を表示する画面を作って、遷移するようにしてください
- FirebaseDatabase力が問われる少し難しい課題かもしれません


## ヒント

- Activityを起動するときの `Intent` には、データを渡すことが出来ます
  - `Intent` にユーザーIDを渡すことで、画面側で表示すべきユーザーを特定する必要があるでしょう
- 「あるユーザーIDの投稿一覧」をどう取得するか、を考える必要があります
  - たとえば、すべての投稿を取得して、その配列をフィルタリングするのも1つの手だと思います
  - FirebaseDatabase力が高ければもっとスマートな方法も思いつくかもしれませんね
