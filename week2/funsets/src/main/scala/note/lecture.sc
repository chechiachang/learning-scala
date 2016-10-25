object session {

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

  def mapReduce(f: Int => Int, combine: (Int, Int) => Int, zero: Int): Int =
}