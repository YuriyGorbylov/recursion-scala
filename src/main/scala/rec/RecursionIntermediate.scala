package rec

import java.io.File

import scala.annotation.tailrec

/**
  * Created by Iurii on 17-04-2017.
  */
object RecursionIntermediate extends App {

  // Implement quicksort
  def quickSort(list: List[Int]): List[Int] = list match {
    case Nil => Nil
    case head :: tail =>
      val (less, greater) = tail.partition(_ < head)
      quickSort(less) ::: head :: quickSort(greater)
  }
  val quickList = List(8, 1, 15, 67, 22, -10)
  println(s"Quick sort from $quickList to ${quickSort(quickList)}")

  // Write a function that finds the index of a value in a sorted list
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
  val bVector = Vector(1, 2, 3, 10, 23, 55, 61)
  val value = 55
  println(s"Index for value $value in $bVector is ${bSearch(bVector, value)}")

  // Write the Ackermann function
  def ackerman(mm: Int, nn: Int): Int = (mm, nn) match {
    case (m, n) if m == 0 => n + 1
    case (m, n) if m > 0 && n == 0 => ackerman(m - 1, 1)
    case (m, n) if m > 0 && n > 0 => ackerman(m - 1, ackerman(m, n - 1))
  }
  val (m, n) = (3, 10)
  println(s"Ackerman for ($m, $n) is ${ackerman(m, n)}")

  // Write a function which searches all files of a provided path
  def searchFile(root: File, key: String): Array[File] = {
    val (files, dirs) = root.listFiles().partition(_.isFile)
    files.filter(_.getName.startsWith(key)) ++ dirs.flatMap(searchFile(_, key))
  }

  def coinChange(money: Int, coins: List[Int]): Int = (money, coins) match {
    case (m, _) if m == 0 => 1
    case (m, c) if m < 0 || c.isEmpty => 0
    case (m, c) => coinChange(money - c.head, c) + coinChange(money, c.tail)
  }
  println(coinChange(5, List(1, 2, 3)))


  def pascalTriangle(column: Int, row: Int): Int = (column, row) match {
    case (c, r) if c == 0 || c == r => 1
    case (c, r) => pascalTriangle(column - 1, row - 1) + pascalTriangle(column, row - 1)
  }
  println(pascalTriangle(2, 3))

  def parantlessBalance(string: String): Boolean = {
    def loop(chars: List[Char], count: Int): Boolean = count match {
      case c if c < 0 => false
      case _ => chars match {
        case Nil => count == 0
        case head :: tail if head == '(' => loop(tail, count + 1)
        case head :: tail if head == ')' => loop(tail, count - 1)
        case head :: tail => loop(tail, count)
      }
    }
    loop(string.toList, 0)
  }
  println(parantlessBalance("a(())b"))

  println("abc".permutations.mkString(", "))
}
