object session{
  1+2

  def sqrt(x: Double)= {

    def abs(x: Double) = if (x < 0) -x else x

    def sqrIter(guess: Double): Double = {
      if (isGoodEnough(guess)) guess
      else sqrIter(improve(guess))
    }


    def isGoodEnough(guess: Double) =
      abs(guess * guess - x) < 0.001 * x

    def improve(guess: Double) =
      (guess + x / guess) / 2

    sqrIter(1)
  }

  sqrt(2)
  sqrt(9)
  sqrt(0.00345)
  sqrt(1e-20) * sqrt(1e-20)

  sqrt(1e20) * sqrt(1e20)

  sqrt(1e50) * sqrt(1e50)

  def factorial(n: Int) : Int = {
    def newFac(total: Int, n: Int): Int=
      if(n == 0) total else newFac(total * n, n - 1)
    newFac(1, n)
  }

  factorial(3)
  factorial(5)
}


