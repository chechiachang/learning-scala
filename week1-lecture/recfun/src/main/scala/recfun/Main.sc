object recfun {
  def balance(chars: List[Char]): Boolean = {

    def pairOpen(count: Int, chars: List[Char]): Boolean = {

      if (chars.isEmpty)
        if (count == 0) true else false
      else if (count < 0) false
      else if (chars.head == '(') pairOpen(count + 1, chars.tail)
      else if (chars.head == ')') pairOpen(count - 1, chars.tail)
      else pairOpen(count, chars.tail)
    }

    pairOpen(0, chars)
  }


  balance("(if (zero? x) max (/ 1 x))".toList)

  balance("I told him (that it's not (yet) done).\n(But he wasn't listening)".toList)

  !balance(":-)".toList)

  !balance("())(".toList)
}