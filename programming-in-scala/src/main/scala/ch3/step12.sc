import scala.io.Source

def readLineFromSource(path: String): Unit = {
  for(line <- Source.fromFile(path).getLines())
    println(line.length + " |" + line)
}

var lines = Source.fromFile("path").getLines().toList
var longestLine = lines.reduceLeft(
  (a, b) => if (a.length > b.length) a else b
)
