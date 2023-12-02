package fi.solita.aoc23

import fi.solita.aoc23.Util.{first, last, letterNumbersToInt}

object Day1 {
  def part1(input: List[String]): Int =
    input
      .map(line => line.filter(c => c.isDigit))
      .map(line => s"${line.first}${line.last}")
      .map(numberString => numberString.toInt)
      .sum

  def part2(input: List[String]): Int = {
    input
      .map(line => letterNumbersToInt(line))
      .map(line => s"${line.first}${line.last}")
      .map(numberString => numberString.toInt)
      .sum
  }
}
