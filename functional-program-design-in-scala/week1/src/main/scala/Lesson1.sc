case class Book(title: String, authors: List[String])

val books: List[Book] = List(
  Book(title = "1", authors = List("11", "111", "1111")),
  Book(title = "2", authors = List("22", "22222")),
  Book(title = "12", authors = List("11", "22"))
)

for(b <- books; a <- b.authors if a startsWith "1") yield b.title


for {
  b1 <- books
  b2 <- books
  if b1 != b2
  a1 <- b1.authors
  a2 <- b2.authors
  if a1 == a2
} yield a1

for {
  b1 <- books
  b2 <- books
  if b1.title < b2.title
  a1 <- b1.authors
  a2 <- b2.authors
  if a1 == a2
} yield a1

{ for {
    b1 <- books
    b2 <- books
    if b1.title < b2.title
    a1 <- b1.authors
    a2 <- b2.authors
    if a1 == a2
  } yield a1
}.distinct

def mapFun[T, U](xs: List[T], f: T => U): List[U] =
  for (x <- xs) yield f(x)

def flapMap[T, U](xs: List[T], f: T => Iterable[U]): List[U] =
  for (x <- xs; y <- f(x)) yield y

def filter[T](xs: List[T], p: T => Boolean): List[T] =
  for (x <- xs if p(x)) yield x

trait Generator[+T]{
  def generate: T
}

val integers = new Generator[Int] {
  val rand = new java.util.Random
  def generate = rand.nextInt()
}
integers.generate

val booleans = new Generator[Boolean]{
  def generate = integers.generate > 0
}
booleans.generate

val pairs = new Generator[(Int, Int)]{
  def generate = (integers.generate, integers.generate)
}
pairs.generate