for(i <- 1 to 4){
  print(i + " ")
}

for(i <- 1 to 10 if i % 2 == 0)
  print(i + " ")

for(
  i <- 1 to 10;
  j <- 1 to 10
)print( i + "" + j + " ")

def strs = for(
  i <- 1 to 10;
  j <- 1 to 10
) yield i + "" +j

print(strs)

var thirty = 30

30 match {
  case 10 => println(10)
  case 20 => println(20)
  case 30 => println(30)
}