object session {

  def sum(f: Int => Int): (Int, Int) => Int = {
    def sumF(a: Int, b: Int): Int =
      if(a > b) 0
      else  f(a) + sumF(a + 1, b)
    sumF
  }

  def sumCude = sum(x => x * x * x)
  sumCude(1, 10)

  // law:
  // sum(cude)(1, 10) = (sum(cube))(1, 10)

  // So:
  def sum2(f: Int => Int): (Int, Int) => Int = {
    def sumF(a: Int, b: Int): Int =
      if(a > b) 0 else f(a) + sum(f)(a + 1, b)
    sumF
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
    def loop(a: Int, acc: Int): Int = {
      if (a > b) acc
      else loop(a + 1, acc + f(a))
    }
    loop(a, 0)
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

}