package fi.solita.aoc23

import fi.solita.aoc23.Day1.{part1, part2}
import fi.solita.aoc23.Util.readInput
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test


class Day1Test {
  @Test
  def day1Part1(): Unit = {
    val testInput = readInput("Day01_Part01_test")

    assertEquals(142, part1(testInput))

    val input = readInput("Day01")
    println(s"Part 1: ${part1(input)}")
  }

  @Test
  def day1Part2(): Unit = {
    val testInput = readInput("Day01_Part02_test")

    assertEquals(281, part2(testInput))

    val input = readInput("Day01")
    println(s"Part 2: ${part2(input)}")
  }
}
