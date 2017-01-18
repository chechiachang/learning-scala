object FileEater {
  def consume(file: String, width: Int): Unit ={

  }

  def consume(file: String, width: Int, line: String)={

  }
}

var increase = (x: Int) => x + 999
increase(10)

val numbers = List(1,2,3,4,5,6,7)
numbers.foreach(i => increase(i))

numbers.filter( _ > 2)

val f = (_:Int) + (_:Int)
f(1, 3)

numbers.foreach(println _)

val sum = (a: Int, b: Int, c: Int) => a + b + c
sum.apply(1,2,3)

def increasing(more: Int) = (x: Int) => x + more
val increase10 = increasing(10)
val increase1000 = increasing(100)

increase10.apply(1)
increase1000(1)

def echo(args: String*) =
for(arg <- args) println(arg)

echo("one", "two")

def approximate(guess: Double): Double =
  if(isGoodEnough(guess)) guess
  else approximate(improve(guess))

def isGoodEnough(x: Double) = true
def improve(x: Double) = x + 1

val arr = Array("one", "two", "three")

echo(arr: _*)

// -g:notailcalls

def bang(x: Int): Int =
  if (x == 0) throw new Exception("bang!")
  else bang(x -1)

bang(5)



