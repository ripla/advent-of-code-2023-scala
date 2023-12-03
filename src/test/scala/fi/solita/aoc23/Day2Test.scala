package fi.solita.aoc23

import fi.solita.aoc23.Day2.{part1, part2}
import fi.solita.aoc23.Util.readInput
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test


class Day2Test {
  @Test
  def day1Part1(): Unit = {
    val testInput = readInput("Day02_test")

    assertEquals(8, part1(testInput))

    val input = readInput("Day02")
    println(s"Part 1: ${part1(input)}")
  }

  @Test
  def day1Part2(): Unit = {
    val testInput = readInput("Day02_test")

    assertEquals(2286, part2(testInput))

    val input = readInput("Day02")
    println(s"Part 2: ${part2(input)}")
  }
}
