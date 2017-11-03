package adventofcode2015

import org.scalatest._

class Day02Spec extends FreeSpec {
  "Part 1" - {
    "2x3x4 = 58" in { assert(Day02.part1("2x3x4") == 58) }
    "1x1x10 = 43" in { assert(Day02.part1("1x1x10") == 43) }
  }

  "Part 2" - {
    "2x3x4 = 34" in { assert(Day02.part2("2x3x4") == 34) }
    "1x1x10 = 14" in { assert(Day02.part2("1x1x10") == 14) }
  }
}
