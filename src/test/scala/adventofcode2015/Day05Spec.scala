package adventofcode2015

import org.scalatest._

class Day05Spec extends FreeSpec {
  "Part 1" - {
    "ugknbfddgicrmopn = true" in { assert(Day05.part1("ugknbfddgicrmopn") == true) }
    "aaa = true" in { assert(Day05.part1("aaa") == true) }
    "jchzalrnumimnmhp = false" in { assert(Day05.part1("jchzalrnumimnmhp") == false) }
    "haegwjzuvuyypxyu = false" in { assert(Day05.part1("haegwjzuvuyypxyu") == false) }
    "dvszwmarrgswjxmb = false" in { assert(Day05.part1("dvszwmarrgswjxmb") == false) }
  }

  "Part 2" - {
    "qjhvhtzxzqqjkmpb = true" in { assert(Day05.part2("qjhvhtzxzqqjkmpb") == true) }
    "xxyxx = true" in { assert(Day05.part2("xxyxx") == true) }
    "uurcxstgmygtbstg = false" in { assert(Day05.part2("uurcxstgmygtbstg") == false) }
    "ieodomkazucvgmuy = false" in { assert(Day05.part2("ieodomkazucvgmuy") == false) }
  }
}
