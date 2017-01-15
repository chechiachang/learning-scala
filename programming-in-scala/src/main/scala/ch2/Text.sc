def max(x: Int, y: Int): Int =
    if(x > y) x else y
max(3,5)

def greet() = println("hi")
greet()

def loop(x: Int) = {
  var i = 0
  while(i < x){
    println(i)
    i += 1
  }
}
loop(10)

def foreach(list: List[String]) = {
  for(s <- list){
    println(s)
  }
}
foreach(List("1", "2", "3"))

