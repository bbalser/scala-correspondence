import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers

class PotterTests extends FunSuite with ShouldMatchers {

  test("price of 1 book is 8") {
    determinePrice(List(1)) should be (8)
  }

}
