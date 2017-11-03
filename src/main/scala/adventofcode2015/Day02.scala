package adventofcode2015

import scala.io.Source

object Day02 {
  case class Present(l: Int, w: Int, h: Int)

  val presentDimensions = """(\d+)x(\d+)x(\d+)""".r

  val parsePresent: String => Option[Present] = _ match {
    case presentDimensions(l, w, h) => Some(Present(l.toInt, w.toInt, h.toInt))
    case _ => None
  }

  val wrapping: Present => Int = p => {
    val lw = p.l * p.w
    val wh = p.w * p.h
    val hl = p.h * p.l

    2 * lw + 2 * wh + 2 * hl + List(lw, wh, hl).min
  }

  val ribbon: Present => Int = p =>
    List(p.l, p.w, p.h)
      .sorted
      .init
      .map(_ * 2)
      .foldLeft(0)(_ + _) +
    (p.l * p.w * p.h)

  val parseAndCalculate: (Present => Int) => String => Int = f => input =>
    parsePresent(input) match {
      case Some(p: Present) => f(p)
      case _ => 0
    }

  val part1: String => Int = parseAndCalculate(wrapping)
  val part2: String => Int = parseAndCalculate(ribbon)

  val calculate: (String => Int) => List[String] => Int = f =>
    _.map(f).foldLeft(0)(_ + _)

  def main(args: Array[String]): Unit = {
    val file: String = getClass.getResource("").getPath + "day02.txt"
    val inputs: List[String] = Source.fromFile(file).getLines.toList
    println("Day 02 part 1: " + calculate(part1)(inputs))
    println("Day 02 part 2: " + calculate(part2)(inputs))
  }
}
