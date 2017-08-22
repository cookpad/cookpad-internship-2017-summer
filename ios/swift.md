# ざっくり Swift 入門

ここで説明する内容は Swift 3.1 のものである。
また Swift のすべての機能を説明するものではなく、講義において利用するSwiftの機能を簡単に説明するものである。
詳しくは公式ドキュメントを参照すること。
https://developer.apple.com/library/content/documentation/Swift/Conceptual/Swift_Programming_Language/

## 定数・変数

### 定数

let キーワードで定数を宣言できる。
定数なので値を変更しようとするとコンパイルエラーになる。

```swift
let number = 1
let text = "Hello World!"

print(number) // => "1"
```

### 変数

var キーワードで変数を宣言できる。

```swift
var apple = 100
var banana = 200
banana = 300

print(banana) // => "300"
```

## 型

変数には型があり、整数を表現する Int 型や文字列を表現する String 型など様々な型がある。
Swift では型推論できる場合は型を省略できる。

```swift
var mango: Int = 300

print(mango) // => "300"
```

### Array

Int 型の配列は [Int] と表現する
他のプログラミング言語と同じように`[]`のなかに要素を並べて初期化できる。

```swift
let numbers: [Int] = [1, 2, 3]
var products = ["apple", "banana", "mango"]

products[1] // => "banana

products.append("mushroom") // => ["apple", "banana", "mango", "mushroom"]
products.remove(at: 1) // => "banana"
products // => ["apple", "mango", "mushroom"]
```

### Dictionary

String 型の値を key に Int 型の値を value としてもつ辞書は [String: Int] と表現する。
[key1: value1, key2: value2, ...] というリテラルで初期化できる。

```swift
let prices = [
    "apple": 100,
    "banana": 200,
    "mango": 500,
]
prices["banana"] // => 200

var items: [String: Int] = [:]
items["sword"] = 1
items["torch"] = 3
items["herb"] = 10
```

### Optional

通常、様々な型の変数には nil を代入することができない。
それに対し nil を代入できる Optional 型が用意されている。
nil を代入できる Int 型として Int? 型がある（正確には Optional にラップされている Int 型 `Optional<Int>`）。
非Optional型である Int に nil を代入しようとするとエラーになる。

```swift
var source: Int
source = 100
source = nil // => nil cannot be assigned to type 'Int'

var destination: Int?
destination = 200
destination = nil // => nil
```

Optional だが nil が代入されてないものとして扱う Implicitly Unwrapped Optional 型もある。

```swift
var textLabel: UILabel!
textLabel.text = "Hello World!" // => fatal error: unexpectedly found nil while unwrapping an Optional value
```

このように記述するとコンパイルは通るが、実行時に `textLabel` が nil なのでランタイムエラーが発生する。ほとんどの場合 Implicitly Unwrapped Optional を使う必要はない。
むしろ上記の例のように安全でないコードが書けてしまうので避けるべきである。

## 制御構文

### if

```swift
if count < 10 {
    print("\(count)!")
}
```

Int には String を引数に持つ failable initializer がある。

```swift
init?(_ text: String, radix: Int = default)
```

Optional binding という機能があり、以下の例では数値に変換できた場合のみ actualNumber に値を束縛しブロックの処理を実行する。

```swift
var possibleNumber = "123"
if let actualNumber = Int(possibleNumber) {
    print("\'\(possibleNumber)\' has an integer value of \(actualNumber)")
} else {
    print("\'\(possibleNumber)\' could not be converted to an integer")
}
// => '123' has an integer value of 123
```

### for

数字の範囲を指定する Range が使える。0..<10 と 0...10 があり、前者は10を含まず後者は10を含む。

```swift
for i in 0..<10 {
    print(i) // 10 times. 0 1 2 3... 8, 9
}
```

Array, Dictionary の for-in

```swift
for product in products {
    print(product)
}

for (name, price) in prices {
    print("\(name) => \(price)")
}
```

## クラス・メソッドの定義

```swift
class Creature {
    let name: String

    init(name: String) {
        self.name = name
    }

    func attack() -> Int {
        return 10
    }
}

class FlyingCreature: Creature {
    func fly() {
        // ...
    }

    override func attack() -> Int {
        return 20;
    }
}
```

### インスタンスの作成

```swift
let elephant = Creature(name: "elephant")
```

## メソッド呼び出し

Creature 型のインスタンス creatureA があるとする。
Creature クラスに attack() -> Int というメソッドが定義されていた場合、以下のようにして呼び出すことができる。

```swift
creatureA.attack() // => 10 (Int)
```

次に、Creature? 型のインスタンス creatureB があるとする。
creatureB が nil でなければ attack() メソッドを呼ぶということを以下のように書ける(アンラップしてメソッドを呼ぶ)。
creatureB は Optional なのでこのように書かないとコンパイルエラーになる。

```swift
creatureB?.attack() // => 10 (Int?)
```

creatureB が nil でないと仮定して強制的にメソッドを呼び出すこともできる。

```swift
creatureB!.attack() // => 10 (Int)
```

この場合コンパイルは通るが、実行時に creatureB が nil だった時ランタイムエラーが発生する。

`?` を常に使ったほうが良いように思えるが、`?` を使った場合は、式の評価結果が Optional になるという点が `!` と違う。
上記の例で言えば attack() メソッドの返り値が Optional でなかったとしても `?` の場合は Optional にラップされ、`!` の場合は非 Optional のままとなる。

```swift
let creatureA = Creature(name: "A")
let creatureB: Creature? = Creature(name: "B")

let case1 = creatureA.attack()
let case2 = creatureB?.attack()
let case3 = creatureB!.attack()

type(of: case1) // => Int.Type
type(of: case2) // => Optional<Int>.Type
type(of: case3) // => Int.Type
```

一番安全な方法は前述した Optional binding を利用して Optional のメソッドを直接呼ばないことである。

```swift
if let creature = creatureB {
    creature.attack() // => 10 (Int)
}
```

## 構造体

構造体(struct) は複数の値をまとめてひとつの型として扱えるようにするものである。
クラスと同じようにメンバを持ったりメソッドを定義することもできる。
クラスと違って構造体は値として扱われるので、メンバ変数の値が変われば基本的に別の値（構造体）となる。

クラスと違い、各メンバを引数に取るコンストラクタの定義は省略できる。

```swift
struct Item {
    var name: String
    var price: Int
    
    func salePrice() -> Int {
        return price * 0.8
    }
}

let item = Item(name: "Apple", price: 198)
```

## Enumeration

Enumeration は同じグループに属する値を列挙し、新しい型として扱えるようにする機能である。
例えば方角を表す `CompassPoint` は以下のようにして定義することができる。

```swift
enum CompassPoint {
    case north
    case south
    case east
    case west
}
```

定義した値は以下のようにして使用できる。

```swift
var direction = CompassPoint.north
```

変数や引数として使う際に型が推論できる状況では、型を省略し`.`始まりの値を指定することができる。

```swift
direction = .south
```

Swift の Enumeration では列挙する値に関連する値を含ませることもできる。

```swift
enum Barcode {
    case upc(Int, Int, Int, Int)
    case qrCode(String)
}

var productBarcode = Barcode.upc(8, 85909, 51226, 3)
productBarcode = .qrCode("ABCDEFGHIJKLMNOP")
```

このようにして定義した値は `switch` 式で展開することができる。

```swift
switch productBarcode {
case let .upc(numberSystem, manufacturer, product, check):
    print("UPC-A: \(numberSystem), \(manufacturer), \(product), \(check).")
case let .qrCode(productCode):
    print("QR code: \(productCode).")
}

// Prints "QR code: ABCDEFGHIJKLMNOP."
```

## Extension

Extension は既存のクラス、構造体、列挙型、プロトコルに対してメソッドや Computed Property を追加する機能である。
以下の例では Double 型に km, m プロパティを追加する。

```swift
extension Double {
    var km: Double { return self * 1_000.0 }
    var m: Double { return self }
}

let aMarathon = 42.km + 195.m
print("A marathon is \(aMarathon) meters long")

// Prints "A marathon is 42195.0 meters long"
```

## Protocol

Protocol はクラスや構造体、列挙型へ指定したプロパティやメソッドを持つことを規定するものである。
以下のように protocol を定義し、`SomeStructure` と `SomeClass` はこのように記述することで `SomeProtocol` に適合すると宣言した状態になる。`SomeProtocol` に定義されたプロパティやメソッドの実装がない場合コンパイルエラーとなる。

```swift
protocol SomeProtocol {
    // protocol definition
}

struct SomeStructure: SomeProtocol {
    // structure definition
}

class SomeClass: SuperClass, SomeProtocol {
    // class definition
}
```

以下のようにして、プロパティやメソッドの要求を定義する。プロパティは読み書き可能かどうかを指定できる。

```swift
protocol SomeProtocol {
    var mustBeSettable: Int { get set }
    var doesNotNeedToBeSettable: Int { get }
}

protocol RandomNumberGenerator {
    func random() -> Double
}
```

Protocol には Extension を使うことでメソッドや computed propety のデフォルト実装を足すことができる。
以下の例は次の動作を定義する。

- `TextRepresentable` プロトコルは `textualDescription` という文字列を返すプロパティ（読み取り専用）を持つ
- `PrettyTextRepresentable` プロトコルは `TextRepresentable` プロトコルを継承する
- `PrettyTextRepresentable` プロトコルは `prettyTextualDescription` という文字列を返すプロパティ（読み取り専用）を持つ
- `PrettyTextRepresentable` プロトコルは `prettyTextualDescription` のデフォルト実装を持つ。これは継承元の `textualDescription` を参照する。

```swift
protocol TextRepresentable {
    var textualDescription: String { get }
}

protocol PrettyTextRepresentable: TextRepresentable {
    var prettyTextualDescription: String { get }
}

extension PrettyTextRepresentable {
    var prettyTextualDescription: String {
        return textualDescription
    }
}
```

`PrettyTextRepresentable` プロトコルに適合するクラスなどは追加の実装なしに `prettyTextualDescription` プロパティを利用できる。
このクラスへ `textualDescription` プロパティより読みやすい文字列表現を用意したい場合は `prettyTextualDescription` プロパティを実装すればよい。
