

class Rational(n: Int, d: Int){
  // precondition
  require(d != 0)
  override def toString = n + "/" + d

  private val g = gcd(n.abs, d.abs)
  private def gcd(a: Int, b: Int): Int =
    if(b == 0) a else gcd(b, a % b)
  def this(n: Int) = this(n, 1)

  def + (that: Rational): Rational =
    new Rational(n * that.d + that.n * d, d * that.d)

  def add(that: Rational): Rational =
    new Rational(n * that.d + that.n * d, d * that.d)

  def - (that: Rational): Rational =
    new Rational(n * that.d - that.n * d, d * that.d)

  def - (i: Int): Rational =
    new Rational(n - i * d, d)

  def * (that: Rational): Rational =
    new Rational(n * that.n, d * that.d)

  def / (that: Rational): Rational =
    new Rational(n * that.d, d * that.n)

  def / (i: Int): Rational =
    new Rational(n, d * i)

  def lessThan(that: Rational) =
    this.n * that.d < that.n * this.d

  def max(that: Rational) =
    if(this lessThan that) that else this
}

val oneHalf = new Rational(1, 2)
val twoThird = new Rational(2, 3)

oneHalf add twoThird = 7/6
oneHalf lessThan twoThird
oneHalf + twoThird

implicit def intToRational(x: Int) = new Rational(x)

(oneHalf / 7) + (1 - twoThird)