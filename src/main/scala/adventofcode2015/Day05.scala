package adventofcode2015

import scala.io.Source

object Day05 {

  val VOWELS: List[Char] = List('a', 'e', 'i', 'o', 'u')
  val DOUBLE_CHARS: List[String] = ('a' to 'z').toList.map(c => s"${c}${c}")
  val NOT_ALLOWED: List[String] = List("ab", "cd", "pq", "xy")

  val hasThreeVowels: String => Boolean =
    _.filter(VOWELS.contains).size >= 3

  val hasSubstringInList: List[String] => String => Boolean =
    l => s => l.exists(s.containsSlice(_))

  val hasDoubleChars: String => Boolean =
    hasSubstringInList(DOUBLE_CHARS)

  val hasNotAllowed: String => Boolean =
    hasSubstringInList(NOT_ALLOWED)

  val part1: String => Boolean =
    s => hasThreeVowels(s) && hasDoubleChars(s) && !hasNotAllowed(s)

  val hasDuplicateCharPairs: String => Boolean =
    s =>
      (0 to (s.length - 4))
        .map(i => s.slice(i + 2, s.length).containsSlice(s.slice(i, i + 2)))
        .exists(_ == true)

  val sameFirstAndLast: List[Char] => Boolean =
    l => l.head == l.last

  val hasThreeCharsWithSameFirstAndLast: String => Boolean =
    s => s.toList.sliding(3).filter(_.size == 3).exists(sameFirstAndLast)

  val part2: String => Boolean =
    s => ((hasDuplicateCharPairs(s) || hasDuplicateCharPairs(s.tail)) &&
          hasThreeCharsWithSameFirstAndLast(s))

  def main(args: Array[String]): Unit = {
    val file: String = getClass.getResource("").getPath + "day05.txt"
    val inputs: List[String] = Source.fromFile(file).getLines.toList
    println("Day 05 part 1: " + inputs.filter(part1).size)
    println("Day 05 part 2: " + inputs.filter(part2).size)
  }
}
