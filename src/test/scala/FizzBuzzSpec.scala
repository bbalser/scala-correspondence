import org.scalatest._
import org.scalatest.matchers.ShouldMatchers

class FizzBuzzSpec extends FunSuite with ShouldMatchers {

  def fizzbuzz(n: Int):String = n match {
    case x if (x % 3 == 0) => "fizz"
    case 5 => "buzz"
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

}
