package adventofcode2015

import scala.io.Source

object Day02 {
  case class Present(l: Int, w: Int, h: Int)
  val presentDimensions = """(\d+)x(\d+)x(\d+)""".r

  def parsePresent(input: String): Option[Present] =
    input match {
      case presentDimensions(l, w, h) => Some(Present(l.toInt, w.toInt, h.toInt))
      case _ => None
    }

  def wrapping(p: Present): Int = {
    val lw = p.l * p.w
    val wh = p.w * p.h
    val hl = p.h * p.l

    2 * lw + 2 * wh + 2 * hl + List(lw, wh, hl).min
  }

  def ribbon(p: Present): Int = {
    List(p.l, p.w, p.h)
      .sorted
      .init
      .map(_ * 2)
      .foldLeft(0)(_ + _) +
    (p.l * p.w * p.h)
  }

  def parseAndCalculate(f: Present => Int)(input: String): Int =
    parsePresent(input) match {
      case Some(p: Present) => f(p)
      case _ => 0
    }

  def part1(input: String): Int =
    parseAndCalculate(wrapping)(input)

  def part2(input: String): Int =
    parseAndCalculate(ribbon)(input)

  def calculate(f: String => Int)(inputs: List[String]): Int =
    inputs
      .map(f)
      .foldLeft(0)(_ + _)

  def main(args: Array[String]): Unit = {
    val file: String = getClass.getResource("").getPath + "day02.txt"
    val inputs: List[String] = Source.fromFile(file).getLines.toList
    println("Day 02 part 1: " + calculate(part1)(inputs))
    println("Day 02 part 2: " + calculate(part2)(inputs))
  }
}
