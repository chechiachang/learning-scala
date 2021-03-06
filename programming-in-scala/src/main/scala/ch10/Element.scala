package ch10

/**
  * Created by David Chang on 2017/1/19.
  */
abstract class Element {
  def contents: Array[String]
  def height: Int = contents.length
  def width: Int = if (height == 0) 0 else contents(0).length
}
