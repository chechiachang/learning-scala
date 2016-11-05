/*
immutable linked list
Nil: the empty list
Cons: a cell containing an element and the remainder of the list
*/

List(1, 2, 3)
//-0 - 0 - 0 - Nil
// |   |   |
// 1   2   3

List(List(true, false) , 3)

trait IntList{

}
class IntCons(val head: Int, val tail: IntList) extends IntList{

}
class IntNil extends IntList{

}

trait List[T]{
  def isEmpty: Boolean
  def head: T
  def tail: List[T]
}

class Cons[T](val head: T, val tail: List[T]) extends List[T]{
  def isEmpty: Boolean = false

}

class Nil[T] extends List[T]{
  def isEmpty: Boolean = true

  //Nothing is subtype of anyother type
  def head: Nothing = throw new NoSuchElementException("Nil.head")

  def tail: Nothing = throw new NoSuchElementException("Nil.tail")
}

def singleton[T](elem: T) = new Cons[T](elem, new Nil[T])
singleton[Int](1)
// - 1 - Nil
singleton(true)


//Type Erasure: types are removed before evaluation


//Polymorphism

//subtypeing: ex subclasses passed to a base class

//generics: object created by Type parameter

def nth[T](x: Int, list: scala.List[T]): T  = {
  if(x >= list.length) throw new IndexOutOfBoundsException("")
  else list(x)
}

def nth[T](x: Int, list: List[T]): T = {
  if(list.isEmpty) throw new IndexOutOfBoundsException
  else if(x == 0) list.head
  else nth(x - 1, list.tail)
}

val list = new Cons(1, new Cons(2, new Cons(3, new Nil)))
nth(2, list)
//nth(-1, list)
nth(3, list)

