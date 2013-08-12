import org.scalatest._
import org.scalatest.matchers.ShouldMatchers

class FizzBuzzSpec extends FunSuite with ShouldMatchers {

  def fizzbuzz(n: Int):String = "1"

  test("1 returns 1") {
    fizzbuzz(1) should be ("1")
  }



}
