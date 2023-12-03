package fi.solita.aoc23

object Day2 {
  case class Game(
                   id: Int,
                   cubeSets: List[CubeSet]
                 ) {
    def maxRed: Int = cubeSets.map(_.red).max

    def maxBlue: Int = cubeSets.map(_.blue).max

    def maxGreen: Int = cubeSets.map(_.green).max

    def minimalCubeSet: CubeSet = CubeSet(red = maxRed, blue = maxBlue, green = maxGreen)
  }

  case class CubeSet(
                      blue: Int = 0,
                      red: Int = 0,
                      green: Int = 0
                    ) {
    def satisfies(constraint: CubeSet): Boolean = constraint.red >= red && constraint.blue >= blue && constraint.green >= green

    def power: Int = blue * red * green
  }

  def toGame(inputLine: String): Game = {
    val cubeSets = inputLine
      .dropWhile(char => ':' == char)
      .split(';')
      .map(toCubeSet)
      .toList

    val id = """Game (?<id>\d{1,3})""".r.findFirstMatchIn(inputLine).get.group("id").toInt

    Game(id, cubeSets)
  }

  def toCubeSet(setInput: String): CubeSet = {
    """(?<count>\d{1,2}) (?<type>red|blue|green)""".r.findAllMatchIn(setInput)
      .foldLeft(CubeSet()) { (set, setMatch) =>
        setMatch.group("type") match {
          case "red" => set.copy(red = setMatch.group("count").toInt)
          case "blue" => set.copy(blue = setMatch.group("count").toInt)
          case "green" => set.copy(green = setMatch.group("count").toInt)
        }
      }
  }

  def part1(input: List[String]): Int = {
    val constraint = CubeSet(red = 12, green = 13, blue = 14)

    input
      .map(toGame)
      .filter(game => game.cubeSets.forall(cubeSet => cubeSet.satisfies(constraint)))
      .map(_.id)
      .sum
  }

  def part2(input: List[String]): Int =
    input
      .map(toGame)
      .map(_.minimalCubeSet)
      .map(_.power)
      .sum

}
