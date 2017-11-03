package adventofcode2015

import org.scalatest._

class Day01Spec extends FreeSpec {
  "Part 1" - {
    "(()) = 0" in { assert(Day01.part1("(())") == 0) }
    "()() = 0" in { assert(Day01.part1("()()") == 0) }
    "((( = 3" in { assert(Day01.part1("(((") == 3) }
    "(()(()( = 3" in { assert(Day01.part1("(()(()(") == 3) }
    "))((((( = 3" in { assert(Day01.part1("))(((((") == 3) }
    "()) = -1" in { assert(Day01.part1("))(") == -1) }
    "))) = -3" in { assert(Day01.part1(")))") == -3) }
    ")())()) = -3" in { assert(Day01.part1(")())())") == -3) }
  }

  "Part 2" - {
    ") = 1" in { assert(Day01.part2(")") == 1) }
    "()()) = 5" in { assert(Day01.part2("()())") == 5) }
  }
}
