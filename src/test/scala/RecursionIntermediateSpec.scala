import org.scalatest.{Matchers, WordSpecLike}

import scala.util.Random

/**
  * Created by IGorbylov on 17.04.2017.
  */
class RecursionIntermediateSpec extends RecursionIntermediate with WordSpecLike with Matchers {

  "RecursionIntermediate" should {

    val randomList = List.fill(10)(Random.nextInt(1000))

    "Compute Ackerman function" in {
      ackerman(3, 10) shouldBe 8189
    }

    "Find the index of a value in a sorted list" in {
      val sortedVector = randomList.sorted.toVector
      val value = randomList(Random.nextInt(randomList.length - 1))
      val expected = sortedVector.indexOf(value)
      val actual = bSearch(sortedVector, value)
      actual.getOrElse(-1) shouldBe expected
    }

    "Do quick sort" in {
      val expected = randomList.sorted
      val actual = quickSort(randomList)
      actual shouldBe expected
    }

    "Verifies the balancing of parentheses in a string" in {
      val strings = List("()()()", "", "(", ")", "(()", ")(")
      val expected = strings.filter(string =>
        string.foldLeft(0) {
          case (acc, _) if acc < 0 => -1
          case (acc, ch) if ch == '(' => acc + 1
          case (acc, ch) if ch == ')' => acc - 1
        } == 0
      )
      val actual = strings.filter(parantless)
      actual.length shouldBe expected.length
    }

    "Computes the elements of Pascal’s triangle" in {
      triangle(2, 4) shouldBe 6
      triangle(0, 0) shouldBe 1
      triangle(2, 2) shouldBe 1
    }

    "Find the highest sum of non-consecutive numbers" in {
      val (firstList, secondList) = randomList.zipWithIndex
        .partition{case (el, idx) => idx % 2 == 0}
      val expected = firstList.map{case (el, idx) => el}.sum max secondList.map{case (el, idx) => el}.sum
      val actual = arrayMaxSum(randomList)
      actual shouldBe expected
    }

    "Find a pair in the array that would add up to the given sum" in {
      val randomNum = Random.nextInt(150)
      val expected = randomList
        .sliding(2)
        .find(list => list.sum == randomNum)
        .map{case List(a,b) => (a,b)}
      val actual = twoSum(randomList, randomNum)
      actual shouldBe expected
    }

    "Find the longest increasing sub-sequence" in {
      val list = List(1, 10, 12, 8, 5)
      val expected = List(1, 10, 12)
      val actual = longestIncreasing(list)
      actual shouldBe expected
    }
  }
}
