package adventofcode2015

import scala.io.Source

object Day01 {
  def parseChar(c: Char): Int =
    c match {
      case '(' => 1
      case ')' => -1
      case _ => 0
    }

  def part1(input: String): Int =
    input
      .toList
      .map(parseChar)
      .foldLeft(0)(_ + _)

  def part2(input: String): Int =
    input
      .toList
      .map(parseChar)
      .map { var f = 0; m => { f += m; f } }
      .zipWithIndex
      .find { case (f, index) => f < 0 }
      .getOrElse((0, -1))
      ._2 + 1

  def main(args: Array[String]): Unit = {
    val file: String = getClass.getResource("").getPath + "day01.txt"
    val input: String = Source.fromFile(file).getLines.mkString
    println("Day 01 part 1: " + part1(input))
    println("Day 01 part 2: " + part2(input))
  }
}
