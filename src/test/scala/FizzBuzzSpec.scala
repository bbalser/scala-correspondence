import org.scalatest._
import org.scalatest.matchers.ShouldMatchers

class FizzBuzzSpec extends FunSuite with ShouldMatchers {

  object Fizz {
    def unapply(n: Int): Boolean = n % 3 == 0
  }

  object Buzz {
    def unapply(n: Int): Boolean = n % 5 == 0
  }

  object FizzBuzz {
    def unapply(n: Int): Boolean = (n,n) match {
      case (Fizz(), Buzz()) => true
      case _ => false
    }
  }

  def fizzbuzz(n: Int):String = n match {
    case FizzBuzz() =>"fizzbuzz"
    case Fizz() => "fizz"
    case Buzz() => "buzz"
    case x => x.toString
  }

  test("1 returns 1") {
    fizzbuzz(1) should be ("1")
  }

  test("2 returns 2") {
    fizzbuzz(2) should be ("2")
  }

  test("3 returns fizz") {
    fizzbuzz(3) should be ("fizz")
  }

  test("5 returns buzz") {
    fizzbuzz(5) should be ("buzz")
  }

  test("6 returns fizz") {
    fizzbuzz(6) should be ("fizz")
  }

  test("10 returns buzz") {
    fizzbuzz(10) should be ("buzz")
  }

  test("15 returns fizzbuzz") {
    fizzbuzz(15) should be ("fizzbuzz")
  }

  test("30 returns fizzbuzz") {
    fizzbuzz(30) should be ("fizzbuzz")
  }

}
