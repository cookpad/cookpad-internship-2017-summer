# 発展的課題への挑戦

この中から好きな課題を選んで解いてよい。<br>
その他にも notebook の末尾の課題や、自分で考えた課題に取り組んでもよい。

## 決定木の理解 or 実装
Random Forest も Gradient Boosting Decision Tree も弱学習器は決定木であり、決定木を理解することは最近の機械学習の手法を理解する際にも重要である。
決定木を理論的に理解する、もしくは CART などをターゲットにして実装をする。

## back propagation の実装
Neural Netrowks の学習の基本である back propagation を自分で実装してみる。 <br>
Ref: ex.) https://github.com/mattm/simple-neural-network

## 自動微分に関して述べる
Deep Learning の学習は back propagation によりなされる場合が多いが、数値計算的にはこれは自動微分（の特に reverse mode）が重要な役割を果たしている。
この自動微分とは何かを述べる。<br>
Ref: https://arxiv.org/abs/1502.05767

## 活性化関数の実装
ReLU の派生系が数多く提案されている。そのうちのいくつかは既に実装されているが、まだ実装されてないものがあったり、もっと良いものがあるかもしれない。<br>
Ref: https://github.com/fchollet/keras/blob/21cf50734a6996da7023dc500bdcc8ac7d74ef48/keras/activations.py <br>
Ref: https://arxiv.org/abs/1708.01666 (比較的新しい活性化関数)

## 様々な Deep Learning ライブラリを試して比較する
tensorflow: https://github.com/tensorflow/tensorflow <br>
chainer: https://github.com/chainer/chainer <br>
caffe: https://github.com/BVLC/caffe <br>
torch: https://github.com/torch/torch7 <br>
theano: https://github.com/Theano/Theano <br>
CNTK: https://github.com/Microsoft/CNTK <br>

## 最近の形態素解析やトークナイザーを試す
実習では MeCab を使ったが、他にも様々なライブラリが存在する。
他のライブラリを使ってそれらの特徴を比べてみる。 <br>
https://github.com/ku-nlp/jumanpp <br>
https://github.com/google/sentencepiece <br>

## 最先端の物体認識モデルを試す
YOLO9000: https://pjreddie.com/darknet/yolo/ <br>
paper: https://arxiv.org/abs/1612.08242

## 簡単なウェブアプリケーションを作る
学習したモデルなどを利用した簡単なウェブアプリケーションを作ってみる。<br>
Ref: http://flask.pocoo.org/ など

## クックパッドで使っているデータ取得用ツールである akagi に貢献する
https://github.com/ayemos/akagi

## Keras や Tensorflow の実装を調べてみる
例えば Keras の Sequential クラスの実装がどうなっているかなど、自分が気になった部分の実装を調べてまとめてみる。

## 機械学習を用いたサービスを試し、どんなモデルを使っているかを考えてみる
ブラウザ上で試せるサービスが数多く存在し、それらはすぐに試してみることができる。
例えば http://make.girls.moe/#/ や http://richzhang.github.io/colorization/ など。
このようなサービスを使ってみて、内部でどのようなモデルが使われているかを調べてまとめてみる。

## クラウドサービスを展開する企業の ML API を使って比べる
GCP, Amazon ML, Azure ML などを使ってみてそれらの違いを調べてみる。
例えば画像認識の API を使ってそれぞれの精度を検証してみるなど。

## 食に関するオープンソースのデータセットを調べる
Ref: http://dl.acm.org/citation.cfm?id=3080686

## Kaggle を除いてみてコンペやデータセットの情報を収集する
Competitions: https://www.kaggle.com/competitions <br>
Datasets: https://www.kaggle.com/datasets <br>

## Deep Learning の汎化性能に関して考察する
パラメタ数がデータ数よりも多いようなモデルの汎化性能は最先端の研究の一つとなっている。<br>
Ref: https://arxiv.org/abs/1611.03530 <br>
Ref: https://speakerdeck.com/diracdiego/some-understanding-of-generalization-in-deep-learing <br>

## 最近読んで面白かった論文を紹介する
201708時点での直近の大きい学会だと、CVPR とか ICML とか KDD <br>
Ref: http://openaccess.thecvf.com/CVPR2017.py <br>
Ref: https://2017.icml.cc/Conferences/2017/Schedule?type=Poster <br>
Ref: http://www.kdd.org/kdd2017/accepted-papers <br>

## Deep Learning と物理学の関係を考察する
https://arxiv.org/abs/1608.08225 (Ref: https://speakerdeck.com/diracdiego/20170405-mlkitchen2) <br>
https://arxiv.org/abs/1704.01552 <br>
https://arxiv.org/find/grp_physics/1/OR+ti:+AND+deep+learning+abs:+AND+deep+learning/0/1/0/all/0/1 <br>

## 講義や実習の改善点をまとめる
「◯◯◯という理由で□□□の部分の内容（もしくは説明）が不適切なので、△△△にした方が良い」のように講義に対するフィードバックを述べる。
