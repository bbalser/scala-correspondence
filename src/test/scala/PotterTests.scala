import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers

class PotterTests extends FunSuite with ShouldMatchers {

  def determinePrice(books:List[Int]):Double = 8 * books.size

  test("price of 1 book is 8") {
    determinePrice(List(1)) should be (8)
  }

  test("price of 2 of the same book is 16") {
    determinePrice(List(1,1)) should be (16)
  }

}
