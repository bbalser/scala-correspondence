import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers

class PotterTests extends FunSuite with ShouldMatchers {

  def determinePrice(books:List[Int]):Double = 8 * books.size * (if (books.toSet.size == 2) 0.95 else if (books.toSet.size == 3) 0.90 else 1.00)

  test("price of 1 book is 8") {
    determinePrice(List(1)) should be (8)
  }

  test("price of 2 of the same book is 16") {
    determinePrice(List(1,1)) should be (16)
  }

  test("price of 2 unique books is 16 * 0.95") {
    determinePrice(List(1,2)) should be (16*0.95)
  }

  test("price of 3 unique books is 24 * 0.90") {
    determinePrice(List(1,2,3)) should be (24 * 0.90)
  }

}
