import java.util

abstract class Element {
  def contents: Array[String]
  def height: Int = contents.length
  def width: Int = if (height == 0) 0 else contents(0).length
}

class ArrayElement(conts: Array[String]) extends Element{
  def contents: Array[String] = conts
}

var ae = new ArrayElement(Array("1", "2"))
val e: Element = new ArrayElement(Array("hello"))

class ArrayElement2(
  val contents: Array[String]
) extends Element

class Cat {
  val dangerous = "minor"
}
class Tiger(d: String, age: Int) extends Cat {
  override val dangerous: String = d
  private var ages = age
}

class LineElement(s: String) extends ArrayElement(Array(s)){
  override def width = s.length
  override def height = 1
}

class UniformElement (
                     ch: Char,
                     override val width: Int,
                     override val height: Int
                     )extends Element {
  private val line = ch.toString * width
  override def contents: Array[String] = Array.make(height, line)
}


