package adventofcode2015

import scala.io.Source
import java.security.MessageDigest

object Day04 {

  val md5: String => String =
    s => MessageDigest.getInstance("MD5").digest(s.getBytes).map("%02X" format _).mkString

  val firstMD5StartingWith: String => String => Int =
    starting => s => Range(0, Int.MaxValue)
      .find(i => md5(s + i).startsWith(starting))
      .getOrElse(-1)

  val part1: String => Int =
    firstMD5StartingWith("00000")

  val part2: String => Int =
    firstMD5StartingWith("000000")

  def main(args: Array[String]): Unit = {
    val file: String = getClass.getResource("").getPath + "day04.txt"
    val input: String = Source.fromFile(file).getLines.mkString
    println("Day 04 part 1: " + part1(input))
    println("Day 04 part 2: " + part2(input))
  }
}
