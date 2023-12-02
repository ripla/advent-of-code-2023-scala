package fi.solita.aoc23

import scala.io.Source

object Util {

  def readInput(name: String): List[String] = Source.fromResource(s"$name.txt").getLines().toList

  extension (s: String)
    def first: Char = s.head

  extension (s: String)
    def last: Char = s.reverse.head

  def letterNumbersToInt(input: String): String = {
    var inputList = input.toList
    var resultList = List[Option[String]]()
    val mappings = Map(
      "one" -> "1",
      "two" -> "2",
      "three" -> "3",
      "four" -> "4",
      "five" -> "5",
      "six" -> "6",
      "seven" -> "7",
      "eight" -> "8",
      "nine" -> "9")

    while (inputList.nonEmpty) {
      val mappedValue = if (inputList.head.isDigit)
        Some(inputList.head.toString)
      else
        mappings.collectFirst { case (k, v) if inputList.startsWith(k) => v }

      resultList = resultList :+ mappedValue
      inputList = inputList.tail
    }

    resultList.flatten.mkString
  }
}





//    input
//      .replaceAll("one", "1")
//      .replaceAll("two", "2")
//      .replaceAll("three", "3")
//      .replaceAll("four", "4")
//      .replaceAll("five", "5")
//      .replaceAll("six", "6")
//      .replaceAll("seven", "7")
//      .replaceAll("eight", "8")
//      .replaceAll("nine", "9")

