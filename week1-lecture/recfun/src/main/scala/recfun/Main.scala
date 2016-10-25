package recfun

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
   * Exercise 1
   */
    def pascal(c: Int, r: Int): Int = {
      if (r < 2) 1
      else if (c == 0) 1
      else pascal(c - 1, r - 1) + pascal(c, r -1)
    }

  
  /**
   * Exercise 2
   */
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
  
  /**
   * Exercise 3
   */
    def countChange(money: Int, coins: List[Int]): Int = {
      if(coins.isEmpty) 1
      else if()

    }
  }
