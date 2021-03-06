package com.gorbylov

import scala.annotation.tailrec

trait RecursionBasic {

  // 1. Write a recursive function that takes a list of integers and returns the sum of all integers.
  def listSum(list: List[Int]): Int = {
    @tailrec
    def loop(list: List[Int], acc: Int): Int = list match {
      case Nil => acc
      case head :: tail => loop(tail, acc + head)
    }
    loop(list, 0)
  }

  // 2. Write a recursive function max that takes a list of integers and returns the largest integer.
  def listMax(list: List[Int]): Int = {
    @tailrec
    def loop(list: List[Int], max: Int): Int = list match {
      case Nil => max
      case head :: tail => loop(tail, max.max(head))
    }
    loop(list, Integer.MIN_VALUE)
  }

  // 3. Write a recursive function that filters list of integers
  def listFilter(list: List[Int], predicate: Int => Boolean): List[Int] = {
    @tailrec
    def loop(list: List[Int], predicate: Int => Boolean, filtered: List[Int]): List[Int] = list match {
      case Nil => filtered
      case head :: tail if predicate(head) => loop(tail, predicate, filtered :+ head)
      case head :: tail if !predicate(head) => loop(tail, predicate, filtered)
    }
    loop(list, predicate, List())
  }

  // 4. Write a recursive function that returns the factorial of a number
  def fact(n: Int): Int = {
    @tailrec
    def loop(n: Int, acc: Int): Int = n match {
      case 0 => acc
      case _ => loop(n - 1, n * acc)
    }
    loop(n, 1)
  }
  val fact = 5

  // 5. Write a recursive function that calculates n-th fibonacci number
  def fib(n: Int): Int = {
    @tailrec
    def loop(n: Int, current: Int, next: Int): Int = n match {
      case 0 | 1 => current
      case _ => loop(n - 1, next, current + next)
    }
    if (n <= 0) 0
    else loop(n, 1 , 1)
  }

  // 6. Write a recursive exponentiation function that raises a number by a power.
  def power(n: Int, power: Int): Double = {
    @tailrec
    def loop(n: Int, power: Int, acc: Double): Double = power match {
      case 0 => acc
      case p if p > 0 => loop(n, power - 1, n * acc)
      case p if p < 0 => loop(n, power + 1, (1 / n.toDouble) * acc)
    }
    loop(n, power, 1)
  }

  // 7. Write a recursive function to reverse a string
  def reverseString(string: String): String = {
    @tailrec
    def loop(chars: List[Char], reversed: List[Char]): List[Char] = chars match {
      case Nil => reversed
      case head :: tail => loop(tail, head :: reversed)
    }
    loop(string.toCharArray.toList, List()) mkString
  }

  // 8. Write a recursive function that checks if a string is a palindrome. Returns true or false.
  def isPalindrome(string: String): Boolean = {
    @tailrec
    def loop(string: String, result: Boolean): Boolean = string match {
      case s if s.length < 2 => result
      case _ => loop(string.substring(1, string.length - 1), result && string.substring(0, 1) == string.substring(string.length - 1))
    }
    loop(string, true)
  }

  // 9. Write a function that computes the Greatest Common Divisor of two numbers
  def gcd(a: Int, b: Int): Int = {
    @tailrec
    def loop(a: Int, b: Int, gcd: Int): Int = gcd match {
      case 0 | 1 => 1
      case g if a % g == 0 && b % g == 0 => g
      case g => loop(a, b, g - 1)
    }
    loop(a, b, a.min(b))
  }
}
