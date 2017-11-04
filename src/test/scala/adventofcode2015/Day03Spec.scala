package adventofcode2015

import org.scalatest._

class Day03Spec extends FreeSpec {
  "Part 1" - {
    "> = 2" in { assert(Day03.part1(">") == 2) }
    "^>v< = 4" in { assert(Day03.part1("^>v<") == 4) }
    "^v^v^v^v^v = 2" in { assert(Day03.part1("^v^v^v^v^v") == 2) }
  }

  "Part 2" - {
    "^v = 2" in { assert(Day03.part2("^v") == 3) }
    "^>v< = 4" in { assert(Day03.part2("^>v<") == 3) }
    "^v^v^v^v^v = 2" in { assert(Day03.part2("^v^v^v^v^v") == 11) }
  }
}
