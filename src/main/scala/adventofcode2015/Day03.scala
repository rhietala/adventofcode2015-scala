package adventofcode2015

import scala.io.Source

object Day03 {
  case class Coordinates(x: Int, y: Int)
  case class Move(dx: Int, dy: Int)

  val ORIGO: Coordinates = Coordinates(0, 0)
  val EMPTY_COORDINATES: Set[Coordinates] = Set.empty

  val cToMove: Char => Move = _ match {
    case '^' => Move(1, 0)
    case '>' => Move(0, 1)
    case '<' => Move(0, -1)
    case 'v' => Move(-1, 0)
    case _ => Move(0, 0)
  }

  val sToMoves: String => List[Move] =
    _.toList.map(cToMove)

  val add: Coordinates => Move => Coordinates =
    c => m => Coordinates(c.x + m.dx, c.y + m.dy)

  val movesToCoordinates: Coordinates => List[Move] => List[Coordinates] =
    start => moves =>
      start :: moves.map { var cur = start; m => { cur = add(cur)(m); cur } }

  val uniqueCount: List[_] => Int = _.toSet.size

  val movesToHouseCount: List[Move] => Int = l =>
    uniqueCount(movesToCoordinates(ORIGO)(l))

  val part1: String => Int = s =>
    movesToHouseCount(sToMoves(s))

  val part2: String => Int = s => {
    val (santa, robo) =
      sToMoves(s)
        .zipWithIndex
        .partition { case (_, i) => i % 2 == 0 }

    List(santa, robo)
      .map(x => movesToCoordinates(Coordinates(0, 0))(x.map(_._1)).toSet)
      .foldLeft(EMPTY_COORDINATES)(_ ++ _)
      .size
   }

  def main(args: Array[String]): Unit = {
    val file: String = getClass.getResource("").getPath + "day03.txt"
    val input: String = Source.fromFile(file).getLines.mkString
    println("Day 03 part 1: " + part1(input))
    println("Day 03 part 2: " + part2(input))
  }
}
