package com.gorbylov

trait RecursionAdvance {

  // 1. Solve Tower of Hanoi problem
  def hanoi(n: Int, from: String, via: String, to: String): List[(String, String)] = n match {
    case 1 => List((from, to))
    case _ =>
      hanoi(n - 1, from, to, via) ++ hanoi(1, from, via, to) ++ hanoi(n - 1, via, from, to)
  }

  // 2. Counting Change
  def countChange(money: Int, coins: List[Int]): Int = {
    money match {
      case 0  => 1
      case x if x < 0 => 0
      case x if x >= 1 && coins.isEmpty => 0
      case _ => countChange(money, coins.tail) + countChange(money - coins.head, coins)
    }
  }

}
