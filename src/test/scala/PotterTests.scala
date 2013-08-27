import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers

class PotterTests extends FunSuite with ShouldMatchers {

  val BASE_BOOK_PRICE = 8
  type Order = List[Set[Int]]
  
  val SET_PRICE = Array(
    0,
    BASE_BOOK_PRICE * 1 * 1.00,
    BASE_BOOK_PRICE * 2 * 0.95,
    BASE_BOOK_PRICE * 3 * 0.90,
    BASE_BOOK_PRICE * 4 * 0.80,
    BASE_BOOK_PRICE * 5 * 0.75
  )

  def determinePrice(books: List[Int]):Double = {

    def processBooks(books: List[Int], order: Order): Order = {
      if (books.isEmpty) {
        order
      } else if (order.isEmpty) {
        processBooks(books.tail, order :+ Set(books.head))
      } else {

        val possibleOrders = createAllPossibleOrders(order, books.head)
        val bestOrder = possibleOrders.view.map(x => (x,priceOfOrder(x)) ).minBy(_._2)._1
        processBooks(books.tail, bestOrder)
      }
    }

    priceOfOrder(processBooks(books, Nil))
  }

  def createAllPossibleOrders(order: Order, book: Int) = order.view.zipWithIndex.map{ case (set, index) =>
    if (!set.contains(book)) {
      order.patch(index, List(set + book), 1)
    } else {
      order :+ Set(book)
    }
  }

  def priceOfOrder(order: Order): Double = order.map(x => SET_PRICE(x.size)).sum


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

  test("price of 2 unique books and 2 duplicates should be ") {
    determinePrice(List(1,1,1,2)) should be ((16 * 0.95) + 8 + 8)
  }

  test("price of 2 unique sets of 2 should be") {
    determinePrice(List(1,2,1,2)) should be ((16 * 0.95) + (16 * 0.95))
  }

  test("the gotcha") {
    determinePrice(List(1,1,2,2,3,3,4,5)) should be (51.20)
  }

}
