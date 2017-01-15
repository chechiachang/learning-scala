object lecture2_2 {

  def sum(f: Int => Int): (Int, Int) => Int = {
    sumF
    def sumF(a: Int, b: Int): Int =
      if(a > b) 0
      else  f(a) + sumF(a + 1, b)
  }

  def sumCube = sum(x => x * x * x)
  sumCube(1, 10)

  // law:
  // sum(cude)(1, 10) = (sum(cube))(1, 10)

  // So:
  def sum2(f: Int => Int): (Int, Int) => Int = {
    sumF
    def sumF(a: Int, b: Int): Int =
      if(a > b) 0 else f(a) + sum(f)(a + 1, b)
  }

  /* law:
  def f(arg1)(arg2)...(argn) = E
  ->
  f(arg1)(arg2)...(argn-1) = {def g(argn) = E;g}
  ->
  f(arg1)(args)...(argn-1) = (argn => E)
  ->
  def f = (arg1 => (arg2 => ... (argn => E)...))
  ->  currying
  */

  // Write a tail-recursive version of sum
  def sum(f: Int => Int, a: Int, b: Int): Int = {
    loop(a, 0)
    def loop(a: Int, acc: Int): Int = {
      if (a > b) acc
      else loop(a + 1, acc + f(a))
    }
  }

  def add(a: Int): Int = a
  sum(add, 3, 5) == 3 + 4 + 5

  //currying product function
  def product(f: Int => Int)(a: Int, b: Int): Int = {
      if(a > b) 1
      else f(a) * product(f)(a + 1, b)
  }
  product(x => x * x)(3, 4)

  //factorial
  def factorial(n: Int) = product(x => x)(1, n)
  factorial(5)

  //general combine function
  //Mine, which is incorrect
  def combine(f: Int => Int, bind: (Int, Int) => Int)(a: Int, b: Int): Int = {
    combineF(a, b)
    def combineF(a: Int, b: Int): Int = {
      if(a > b) 1
      else bind(f(a), combineF(a + 1, b))
    }
  }
  //Lecture
  def mapReduce(f: Int => Int, combine: (Int, Int) => Int, zero: Int)(a: Int, b: Int): Int = {
    if(a > b) zero
    else combine(f(a), mapReduce(f, combine, zero)(a + 1, b))
  }
}