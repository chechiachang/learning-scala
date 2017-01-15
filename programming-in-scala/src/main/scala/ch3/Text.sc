val big = new java.math.BigInteger("12345")

val greetings = new Array[String](3)

// #No traditional operator
for(i <- 0 to 2)
  println(greetings(i))

for(i <- 0.to(2))
  println(greetings(i))

for(i <- 0.to(2))
  println(greetings.apply(i))

1 + 2
(1).+(2)

greetings(0) = "hello"
greetings.update(0, "hello")

val numNames = Array("zero", "one", "two")
val numNames2 = Array.apply("zero", "one", "two")

// #List

val oneTwo = List(1, 2)
val threeFour = List(3) :: List(4)
val threeFour2 = 3 :: List(4)
val oneFour = oneTwo ::: threeFour

/*
oneTwo, threeFour is immutable
oneFour is a new List

:: is a method of its right operand
method name ends in a colon,
  the method is invoked on the right operand
*/

val oneTwoThree = 1 :: 2 :: 3 :: Nil
val oneTwoThree2 = 1 :: (2 :: (3 :: Nil))

// Empty list
List()
Nil
// count by lamda
oneTwoThree.count(int => int.equals(2))
// drop first 2 elements
val oneThree = oneTwoThree.drop(2)
// all elements
val allOne: Boolean = oneTwoThree.forall(int => int.equals(1))
// for each
oneTwoThree.foreach(s => println(s))
oneTwoThree.foreach(println)
// head
oneTwoThree.head
// last
oneTwoThree.last
//tail
val twoThree = oneTwoThree.tail
// isEmpty
oneTwoThree.isEmpty
// map
val twoThreeFour = oneTwoThree.map(int => int + 1)
// mkString
oneTwoThree.mkString(",")
// remove
//val twoThree = oneTwoThree.remove(int => int.equals(1))
// reverse
val FourThreeTwo = oneTwoThree.reverse

/*
#tuples
 */

val pair = (1, "one")
pair._1
pair._2

val tuple6 = ("1", 13.5, "13.5", List(), List(1, 3, 0.5))

/*
#Set and Map

List is immutable
Array is mutable
Set & Map has both immutable and mutable implements
 */

var jetSet = Set("a", "b")
jetSet += "c"
// immutable implementation will generate a new mutable Set

var treasureMap = Map[Int, String]()
treasureMap += (1 -> "Island")
treasureMap += (2 -> "Sand")
treasureMap += (3 -> "Well")

// # be functional

def printArgs(args: Array[String]): Unit = {
  for(arg <- args) println(arg)
  args.foreach(println)
}

def formatArgs(args: Array[String]) = args.mkString("\n")

/*
Prefer vals, immutable objects, methods without side effects
 */
