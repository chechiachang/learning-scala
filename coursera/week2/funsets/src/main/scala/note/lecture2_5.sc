//Data
var x = new Rational(1, 2)
var y = new Rational(2, 3)
x.add(y)

def addRational(r : Rational, s: Rational): Rational = {
  new Rational(
    r.numerator * s.denominator + s.numerator * r.denominator,
    r.denominator * s.denominator
  )
}

def makeString(r: Rational) =
  r.numerator + "/" + r.denominator

makeString(addRational(new Rational(1,2), new Rational(2,3)))
new Rational(1,2).add(new Rational(2,3)).toString()


class Rational(x: Int, y: Int) {
  require(y != 0, "denominator must be nonzero")

  def this(x: Int) = this(x, 1)

  private def gcd(a: Int, b: Int): Int = if(b == 0) a else gcd(b, a % b)
  private val g = gcd(x, y)
  def numerator = x / g
  def denominator = y / g

  //method
  def add(that: Rational) =
  new Rational(
    numerator * that.denominator + denominator * that.numerator,
    denominator * that.denominator
  )

  def neg = new Rational(-numerator, denominator)

  def sub(that: Rational) = add(that.neg)

  override def toString() = numerator + "/" + denominator

  def less(that: Rational) = numerator * that.denominator < that.numerator * denominator

  def max(that: Rational) = if(this.less(that))that else this
}
// special
// *.%
// +-
// :
// =!
// <>
// ^
// |


((a + b) ^? (c ?^ d)) less ((a ==> b) | c)