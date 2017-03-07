object week5 {
  val list = List()

  val list2 = List(1, 2, 3)

  list2.indexOf(3)
  list2.contains(2)
  list2.length
  list2.head
  list2.last

  def last[T](xs: List[T]): T = xs match {
    case List() => throw new Error()
    case List(x) => x
    case y :: ys => last(ys)
  }

  def concat[T](xs: List[T], ys: List[T]): List[T] = xs match {
    case List() => ys
    case z :: zs => z :: concat(zs, ys)
  }

  def reverse[T](xs: List[T]): List[T] = xs match {
    case List() => List()
    case y :: ys => reverse(ys) ++ List(y)
  }

  def removeAt[T](xs: List[T], n: Int): List[T] = xs match {
    case List() => throw new Error()
    case List(x) => List()
    case y :: ys => if (n == 0) ys else y :: removeAt(ys, n - 1)
  }
  (list2 take 1) ::: (list2 drop 2)


  def flatten(xs: List[Any]): List[Any] = xs match {
    case List() => List()
    case List(x) => List(x)
    case y :: ys => y match {
      case List() => flatten(ys)
      case List(y) => y :: flatten(ys)
    }
  }

//  flatten(List(List(1,1), 2, List(3, List(5, 8))))

  def mergeSort(xs: List[Int]): List[Int] = {
    val n = xs.length/2
    if(n == 0) xs
    else {
      def merge(xs: List[Int], ys: List[Int]): List[Int] = xs match {
        case Nil => ys
        case x :: xs1 => ys match {
          case Nil => xs
          case y :: ys1 =>
            if(x < y) x :: merge(xs1, ys)
            else y :: merge(xs, ys1)
        }
      }

      val (fst, snd) = xs splitAt n
      merge(mergeSort(fst), mergeSort(snd))
    }
  }

  val pair = ("", 42)

  def merge(xs: List[Int], ys: List[Int]): List[Int] =
    (xs, ys) match {
      case (Nil, ys) => ys
      case (xs, Nil) => xs
      case (x :: xs1, y :: ys1) =>
        if(x < y) x :: merge (xs1, ys)
        else y :: merge(xs, ys1)
    }

}
1/2