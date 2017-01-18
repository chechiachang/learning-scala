val numbers = List(1,2,3,4,5,6,7)

def matching(matcher: Int => Boolean) =
  for(n <- numbers; if matcher(n)) yield n

def largerThan5 = matching(_ > 5)
def even = matching( _ % 2 == 0)


def containsNeg(nums: List[Int]) = nums.exists(_ < 0)

def oldSum(x: Int, y: Int) = x + y
oldSum(1, 2)

def curriedSum(x: Int)(y: Int) = x + y
curriedSum(1)(2)

def first(x: Int) = (y: Int) => x + y
first(1)(2)
val second = first(1)
second(1)


val onePlus = curriedSum(1)_
onePlus(2)
val twoPlus = curriedSum(2)_
twoPlus(4)

def twice(op: Double => Double, x: Double) = op(op(x))
twice(_ + 1, 2)

def strOperator(x: String, op: String => Unit) = op(x)

strOperator("123", println)
strOperator("123", print)


def assert(predicate: () => Boolean) = if(true && predicate()) print("true")
assert(() => false)

def assertByName(predicate: => Boolean) = if(true && predicate) print("true")
