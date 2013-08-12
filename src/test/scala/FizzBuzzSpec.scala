import org.scalatest._
import org.scalatest.matchers.ShouldMatchers

class FizzBuzzSpec extends FunSuite with ShouldMatchers {

  def fizzbuzz(n: Int):String = n.toString

  test("1 returns 1") {
    fizzbuzz(1) should be ("1")
  }

  test("2 returns 2") {
    fizzbuzz(2) should be ("2")
  }


}
