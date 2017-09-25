package com.gorbylov

import scala.annotation.tailrec

trait RecursionIntermediate {

  // 1. Write the Ackermann function
  def ackermanFunc(mm: Int, nn: Int): Int = (mm, nn) match {
    case (m, n) if m == 0 => n + 1
    case (m, n) if m > 0 && n == 0 => ackermanFunc(m - 1, 1)
    case (m, n) if m > 0 && n > 0 => ackermanFunc(m - 1, ackermanFunc(m, n - 1))
  }
  val (m, n) = (3, 10)

  // 2. Write a function that finds the index of a value in a sorted list
  def bSearch(vector: Vector[Int], value: Int): Option[Int] = {
    @tailrec
    def loop(vector: Vector[Int], value: Int, low: Int, high: Int): Option[Int] = (low, high) match {
      case (l, h) if l > h => None
      case (l, h) =>
        val index = l + (h - l) / 2
        vector(index) match {
          case mid if mid == value => Some(index)
          case mid if mid > value => loop(vector, value, low, index - 1)
          case mid if mid <= value => loop(vector, value, index + 1, high)
        }
    }
    loop(vector, value, 0, vector.length - 1)
  }

  // 3. Implement quick sort
  def quickSort(list: List[Int]): List[Int] = list match {
    case Nil => Nil
    case head :: tail =>
      val (less, greater) = tail.partition(_ < head)
      quickSort(less) ::: head :: quickSort(greater)
  }
  val quickList = List(8, 1, 15, 67, 22, -10)

  // 4. Write a recursive function which verifies the balancing of parentheses in a string
  def parenthesesBalance(str: String): Boolean = {
    @tailrec
    def loop(chars: List[Char], count: Int): Boolean = {
      if (count < 0) {
        false
      } else chars match {
        case Nil => count == 0
        case head :: tail if head == '(' => loop(tail, count + 1)
        case head :: tail if head == ')' => loop(tail, count - 1)
        case _ :: tail => loop(tail, count)
      }
    }
    loop(str.toList, 0)
  }

  // 5. Write a function that computes the elements of Pascal’s triangle by means of a recursive process.
  def pascalTriangle(colomn: Int, row: Int): Int = (colomn, row) match {
    case (0, _) => 1
    case (c, r) if c == r => 1
    case (c, r) => pascalTriangle(c, r - 1) + pascalTriangle(c - 1, r - 1)
  }

  // 6. Find the highest sum of non-consecutive numbers
  def arrayMaxSum(array: List[Int]): Int = {
    @tailrec
    def loop(array: List[Int], first: Int, second: Int): Int = array match {
      case Nil => first max second
      case head :: tail => loop(tail, head + second, first)
    }
    loop(array, 0, 0)
  }

  // 7. Find a pair in the array that would add up to the given sum
  def twoSum(array: List[Int], sum: Int): Option[(Int, Int)] = {
    @tailrec
    def loop(arrayInner: List[Int]): Option[(Int, Int)] = arrayInner match {
      case Nil => None
      case head :: _ if arrayInner.contains(sum - head) => Some(head, sum - head)
      case _ :: tail => loop(tail)
    }
    loop(array)
  }

  // 8. Find the longest increasing sub-sequence
  def longestIncreasing(array: List[Int]): List[Int] = {
    @tailrec
    def loop(array: List[Int], current: List[Int], longest: List[Int]): List[Int] = array match {
      case Nil => longest
      case head :: tail =>
        val newCurrent = if (current.isEmpty || head - current.head > 0) head :: current else head :: Nil
        val newLongest = if (newCurrent.size > longest.size) newCurrent else longest
        loop(tail, newCurrent, newLongest)
    }
    loop(array, List(), List()) reverse
  }

  // 9. Generate all permutations of a given string
  def permutations(s: String): Seq[String] = {
    def loop(string: String, n: Int): Seq[String] = n match {
      case 1 => string.map(_.toString)
      case _ =>
        for {
          ch <- string
          perm <- loop(string.replaceFirst(ch.toString, ""), n - 1)
        } yield ch + perm
    }
    loop(s, s.length)
  }
}
