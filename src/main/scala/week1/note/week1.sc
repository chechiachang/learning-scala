object session{
  1+2

  //
  // Call by Value and Call by name

  def test(x: Int, y:Int): Int =
    x * x

  test(7, 8)
  test(3+4, 2*4)
  test(7, 2*4)
  test(3+4, 8)

  //Newton's method to find square root

  def sqrt(n: Double): Double = {
    def findSqurt(guess: Double): Double =
      if(isGoodEnough(guess)) guess
      else findSqurt(improve(guess))

    def isGoodEnough(guess: Double): Boolean = {
      def abs(x: Double): Double =
        if(x > 0) x else -x

      abs(guess * guess - n) < 0.001 * n
    }

    def improve(guess: Double): Double =
      (guess + n / guess) / 2

    findSqurt(1)
  }

  sqrt(2) * sqrt(2)
  sqrt(0.001) * sqrt(0.001)
  sqrt(1.0e-20) * sqrt(1.0e-20)
  sqrt(1.0e20) * sqrt(1.0e20)
  sqrt(1.0e50) * sqrt(1.0e50)

  //tail factorial

  def factorial(n: Int): Int ={
    def fac(acc: Int, n:Int): Int =
      if(n == 0) acc else fac(acc * n, n - 1)
    fac(1, n)
  }
  factorial(3)
  factorial(4)
  factorial(5)
}