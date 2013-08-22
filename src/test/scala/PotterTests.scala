import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers

class PotterTests extends FunSuite with ShouldMatchers {

  def determinePrice(books:List[Int]):Double = {

    def setPrice(set:Set[Int]) =
      8 * set.size * (set.size match {
        case 5 => 0.75
        case 4 => 0.80
        case 3 => 0.90
        case 2 => 0.95
        case _ => 1.00
      })

    val set1 = books.toSet
    val set2 = (books diff set1.toList).toSet

    setPrice(set1) + setPrice(set2)
  }

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

  test("price of 4 unique books is 32 * 0.80") {
    determinePrice(List(1,2,3,4)) should be (32 * 0.80)
  }

  test("price of 5 unique books is 40 * 0.75") {
    determinePrice(List(1,2,3,4,5)) should be (40 * 0.75)
  }

  test("price of 2 unique books and 1 duplicate should be ") {
    determinePrice(List(1,1,2)) should be ((16 * 0.95) + 8)
  }

}
