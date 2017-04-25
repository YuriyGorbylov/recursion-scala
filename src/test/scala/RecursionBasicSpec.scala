import org.scalatest.{Matchers, WordSpecLike}

import scala.util.Random

/**
  * Created by IGorbylov on 17.04.2017.
  */
class RecursionBasicSpec extends RecursionBasic with WordSpecLike with Matchers {

  "RecursionBasic" should {

    val randomList = List.fill(10)(Random.nextInt(1000) + 1)
    val randomNum = Random.nextInt(10) + 1
    val randomString = Random.nextString(10)

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
      def testFact(n: Int) = {
        var (count, result) = (n, 1)
        while(count > 0) {
          result = result * count
          count = count - 1
        }
        result
      }
      val expected = testFact(randomNum)
      val actual = fact(randomNum)
      actual shouldBe expected
    }

    "Calculates n-th fibonacci number" in {
      def testFib(n: Int): Int = n match {
        case 0 | 1 => 1
        case _ => testFib(n - 1) + testFib(n - 2)
      }
      val expected = testFib(randomNum - 1)
      val actual = fib(randomNum)
      actual shouldBe expected
    }

    "Raise a number by a power" in {
      val randomPower = Random.nextInt(10)
      val expected = Math.pow(randomNum, randomPower)
      val actual = power(randomNum, randomPower)
      actual shouldBe expected
    }

    "Reverse a string" in {
      val expected = randomString.reverse
      val actual = reverseString(randomString)
      actual shouldBe expected
    }

    "Check if a string is a palindrome" in {
      val strings = List("aaabbcbbaaa", "aaabbaaa", "a", "ab", "", "aaba", "aba", "aa")
      def testIsPalindrome(string: String) = string.reverse == string
      val expected = strings.filter(testIsPalindrome)
      val actual = strings.filter(isPalindrome)
      actual.length shouldBe expected.length
    }

    "Computes the Greatest Common Divisor of two numbers" in {
      val randomNum2 = Random.nextInt(100) + 1
      def testGcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)
      val expected = testGcd(randomNum, randomNum2)
      val actual = gcd(randomNum, randomNum2)
      actual shouldBe expected
    }
  }

}
