package ch10

/**
  * Created by David Chang on 2017/1/19.
  */
class UniformElement (
  ch: Char,
  override val width: Int,
  override val height: Int
                     ) extends Element {
  private val line = ch.toString * width

  override def contents = Array.make(height, line)
}

