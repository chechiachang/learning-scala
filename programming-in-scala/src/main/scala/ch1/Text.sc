import java.math.BigInteger

//#1.1
var capital = Map("US" -> "Washington", "France" -> "Paris")
capital += ("Japan" -> "Tokyo")
println(capital("France"))

/*
Maps are not language syntax, but extendable libraries
 */

def factorial(x: BigInt): BigInt =
  if(x == 0) 1 else x * factorial(x - 1)

factorial(5)
factorial(30)

/*
Use java class
 */

def factorial2(x :BigInteger): BigInteger =
  if(x == BigInteger.ZERO) BigInteger.ONE
  else x.multiply(factorial2(x.subtract(BigInteger.ONE)))

/*
Actor-based concurrent programming
Actor
concurrent abstraction

actor {
  var sum = 0
  loop {
    receive {
      case Data(bytes)       => sum += hash(bytes)
      case GetSum(requester) => requester ! sum
    }
  }
}

#1.2 Scalable

object-oriented
functional
 */

