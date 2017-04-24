import org.scalatest.{Matchers, WordSpecLike}

import scala.util.Random

/**
  * Created by IGorbylov on 17.04.2017.
  */
class RecursionBasicSpec extends RecursionBasic with WordSpecLike with Matchers {

  "RecursionBasic" should {

    val randomList = List.fill(10)(Random.nextInt(1000))
    val randomNum = Random.nextInt(10)
    println(randomList)
    println(randomNum)

    "Take a randomList of integers and returns the sum of all integers" in {
      val expected = randomList.sum
      val actual = listSum(randomList)
      actual shouldBe expected
    }

    "Take a randomList of integers and returns the largest integer" in {
      val expected = randomList.max
      val actual = listMax(randomList)
      actual shouldBe expected
    }

    "Filter randomList of integers" in {
      val predicate: Int => Boolean = num => num % 2 == 0
      val expected = randomList.filter(predicate)
      val actual = listFilter(randomList, predicate)
      actual shouldBe expected
    }


    "Return the factorial of a number" in {
      def factIter(n: Int) = {
        var (count, result) = (n, 1)
        while(count > 0) {
          result = result * count
          count = count - 1
        }
        result
      }
      val expected = factIter(randomNum)
      val actual = fact(randomNum)
      actual shouldBe expected
    }

    "Calculates n-th fibonacci number" in {
      def fib2(n: Int): Int = n match {
        case 0 | 1 => 1
        case _ => fib2(n - 1) + fib2(n - 2)
      }
      val expected = fib2(randomNum - 1)
      val actual = fib(randomNum)
      actual shouldBe expected
    }
  }

}
