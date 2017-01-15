object recfun {

  println("Pascal's Triangle")
  for (row <- 0 to 10) {
    for (col <- 0 to row)
      print(pascal(col, row) + " ")
    println()
  }

  def pascal(c: Int, r: Int): Int = {
    if (r < 2) 1
    else if (c == 0) 1
    else if (c == r) 1
    else pascal(c - 1, r - 1) + pascal(c, r -1)
  }

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

  //Count change
  def countChange(money: Int, coins: List[Int]): Int = {


    def degnerate(money: Int, coins: List[Int], count: Int): Int = {
      if (coins.isEmpty)
        count
      // use all coins in hand, stop and return current solutions count
      else if (money == 0)
        1
      // find way to pay, add 1 to solution count and try next coins
      else if (money - coins.head < 0)
        count + degnerate(money, coins.tail, 0)
      // coins.head will exceed money, use next coin instead
      else
        degnerate(money - coins.head, coins, 0) +
          degnerate(money, coins.tail, 0)
      // coins.head won't exceed, use head coin to pay
    }

    degnerate(money, coins, 0)
  }

  countChange(0, List(1, 2))
  countChange(4, List())
  countChange(4, List(1))
  countChange(4, List(1, 2))

  countChange(300, List(5, 10, 20, 50, 100, 200, 500)) // 1022
  countChange(301, List(5, 10, 20, 50, 100, 200, 500)) // 0
  countChange(300, List(500, 5, 50, 100, 20, 200, 10)) // 1022
}