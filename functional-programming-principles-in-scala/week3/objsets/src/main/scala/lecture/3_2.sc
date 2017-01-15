
def error(msg: String) = throw new Error(msg)

val x = null
val y: String = x

//val z: Int = null


//Traits
//Trait has no parameter

trait Planar{
  def height: Int
  def width: Int
  def surface = height * width
}

class Square extends Shape with Planar with Movable{
  override def height: Int = ???

  override def width: Int = ???
}

trait Shape

trait Movable

/*
Scala.Any
AnyVal - AnyRef
Int...Unit - java object(classes), scala object, collections

? - scala.Null
scala.Nothing
 */

//Long to Int, not subclass
//Need reassign memory, and might loose value
//Nothing has no value

if(true) 1 else false
