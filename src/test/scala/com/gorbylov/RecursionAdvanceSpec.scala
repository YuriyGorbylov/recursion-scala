package com.gorbylov

import org.scalatest.{Matchers, WordSpecLike}

class RecursionAdvanceSpec extends RecursionAdvance with WordSpecLike with Matchers {

  "RecursionAdvance" should {

   "Solve Tower of Hanoi problem" in {
     val actual = hanoi(3, "A", "C", "B")
     val expected = List(("A", "B"), ("A", "C"), ("B", "C"), ("A", "B"), ("C", "A"), ("C", "B"), ("A", "B"))
     actual shouldBe expected
   }

    "Counting Change" in {
      countChange(4, List()) shouldBe 0
      countChange(4, List(1,2)) shouldBe 3
      countChange(300, List(5, 10, 20, 50, 100, 200, 500)) shouldBe 1022
      countChange(301, List(5, 10, 20, 50, 100, 200, 500)) shouldBe 0
    }
  }

}
