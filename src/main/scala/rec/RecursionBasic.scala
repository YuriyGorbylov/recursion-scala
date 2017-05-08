//package rec
//
//import scala.annotation.tailrec
//
///**
//  * Created by IGorbylov on 17.04.2017.
//  */
//object RecursionBasic extends App {
//
//  // Write a recursive function that takes a list of integers and returns the sum of all integers.
//  def listSum(list: List[Int]): Int = {
//    @tailrec
//    def loop(list: List[Int], acc: Int): Int = list match {
//      case Nil => acc
//      case head :: tail => loop(tail, acc + head)
//    }
//    loop(list, 0)
//  }
//  val listSum = List(1, 3, 6, 8)
//  println(s"Sum of list $listSum is ${listSum(listSum)}")
//
//  // Write a recursive function max that takes a list of integers and returns the largest integer.
//  def listMax(list: List[Int]): Int = {
//    @tailrec
//    def loop(list: List[Int], max: Int): Int = list match {
//      case Nil => max
//      case head :: tail => loop(tail, max.max(head))
//    }
//    loop(list, Integer.MIN_category)
//  }
//  val listMax = List(1, 3, 10, 6, 8)
//  println(s"Max category of list $listMax is ${listMax(listMax)}")
//
//  // Write a recursive function that filters list of integers
//  def listFilter(list: List[Int], predicate: Int => Boolean): List[Int] = {
//    @tailrec
//    def loop(list: List[Int], predicate: Int => Boolean, filtered: List[Int]): List[Int] = list match {
//      case Nil => filtered
//      case head :: tail if predicate(head) => loop(tail, predicate, filtered :+ head)
//      case head :: tail if !predicate(head) => loop(tail, predicate, filtered)
//    }
//    loop(list, predicate, List())
//  }
//  val listFilter = List(1, 3, 6, 8, 11)
//  println(s"Filtered list $listFilter is ${listFilter(listFilter, _ % 2 == 0)}")
//
//  // Write a recursive function that returns the factorial of a number
//  def fact(n: Int): Int = {
//    @tailrec
//    def loop(n: Int, acc: Int): Int = n match {
//      case 0 => acc
//      case _ => loop(n - 1, n * acc)
//    }
//    loop(n, 1)
//  }
//  val fact = 5
//  println(s"Fact for $fact is ${fact(fact)}")
//
//  // Write a recursive function that calculates n-th factorial number
//  def fib(n: Int): Int = {
//    @tailrec
//    def loop(n: Int, current: Int, next: Int): Int = n match {
//      case 0 | 1 => current
//      case _ => loop(n - 1, next, current + next)
//    }
//    if (n <= 0) 0
//    else loop(n, 1 , 1)
//  }
//  val fib = 7
//  println(s"Fib for $fib is ${fib(fib)}")
//
//  // Write a recursive exponentiation function that raises a base by a power.
//  def power(n: Int, power: Int): Double = {
//    @tailrec
//    def loop(n: Int, power: Int, acc: Double): Double = power match {
//      case 0 => acc
//      case p if p > 0 => loop(n, power - 1, n * acc)
//      case p if p < 0 => loop(n, power + 1, (1 / n.toDouble) * acc)
//    }
//    loop(n, power, 1)
//  }
//  val num = 3
//  val power = -2
//  println(s"$num power $power is ${power(num, power)}")
//
//  // Write a recursive function to reverse a string
//  def reverseString(string: String): String = {
//    @tailrec
//    def loop(chars: List[Char], reversed: List[Char]): List[Char] = chars match {
//      case Nil => reversed
//      case head :: tail => loop(tail, head :: reversed)
//    }
//    loop(string.toCharArray.toList, List()) mkString
//  }
//  val reverse = "1234567"
//  println(s"Reversed '$reverse' is ${reverseString(reverse)}")
//
//  // Write a recursive function that checks if a string is a palindrome. Returns true or false.
//  def isPalindrome(string: String): Boolean = {
//    @tailrec
//    def loop(string: String, result: Boolean): Boolean = string match {
//      case s if s.length < 2 => result
//      case _ => loop(string.substring(1, string.length - 1), result && string.substring(0, 1) == string.substring(string.length - 1))
//    }
//    loop(string, true)
//  }
//  val palindrome = "aaabbcbbaaa"
//  println(s"'$palindrome' is palindrome ${isPalindrome(palindrome)}")
//
//  // Write a function that computes the Greatest Common Divisor of two numbers
//  def gcd(first: Int, second: Int): Int = {
//    def loop(first: Int, second: Int, gcd: Int): Int = gcd match {
//      case g if first % gcd == 0 && second % gcd == 0 => gcd
//      case _ => loop(first, second, gcd - 1)
//    }
//    loop(first, second, first.min(second))
//  }
//  val firstNum = 56
//  val secondNum = 48
//  println(s"GCD for $firstNum and $secondNum is ${gcd(firstNum, secondNum)}")
//}