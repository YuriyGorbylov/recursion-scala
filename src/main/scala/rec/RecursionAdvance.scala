package rec

/**
  * Created by Iurii on 17-04-2017.
  */
object RecursionAdvance extends App {

  def permutations(s: String): Seq[String] = {
    def loop(string: String, n: Int): Seq[String] = n match {
      case 1 => string.map(_.toString)
      case _ =>
        for {
          ch <- string
          perm <- loop(string.replaceFirst(ch.toString, ""), n - 1)
        } yield ch + perm
    }
    loop(s, s.length) distinct
  }
  println(permutations("abc"))

  // tower of hanoi
  def hanoi(n: Int, from: String, via: String, to: String): List[(String, String)] = n match {
    case 1 => List((from, to))
    case _ =>
      hanoi(n - 1, from, to, via) ++ hanoi(1, from, via, to) ++ hanoi(n - 1, via, from, to)
  }
  println(hanoi(3, "A", "C", "B"))
}
