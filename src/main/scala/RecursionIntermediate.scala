/**
  * Created by IGorbylov on 17.04.2017.
  */
trait RecursionIntermediate {

  // Write the Ackermann function
  def ackerman(mm: Int, nn: Int): Int = (mm, nn) match {
    case (m, n) if m == 0 => n + 1
    case (m, n) if m > 0 && n == 0 => ackerman(m - 1, 1)
    case (m, n) if m > 0 && n > 0 => ackerman(m - 1, ackerman(m, n - 1))
  }
  val (m, n) = (3, 10)
  println(s"Ackerman for ($m, $n) is ${ackerman(m, n)}")

  // Implement quicksort
  def quickSort(list: List[Int]): List[Int] = list match {
    case Nil => Nil
    case head :: tail =>
      val (less, greater) = tail.partition(_ < head)
      quickSort(less) ::: head :: quickSort(greater)
  }
  val quickList = List(8, 1, 15, 67, 22, -10)
  println(s"Quick sort from $quickList to ${quickSort(quickList)}")
}
