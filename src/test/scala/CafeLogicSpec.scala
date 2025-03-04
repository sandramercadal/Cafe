import Mon.{CafeLogic, MenuData, MenuItem}
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class CafeLogicSpec extends AnyWordSpec with Matchers {

 val cafeLogic = new CafeLogic

  val HotChocolate = new MenuItem ("Hot Chocolate", 3.50, "Beverages", isSpecial = false, 15)
  val Donut = new MenuItem ("Donut", 2.50, "Bakery", isSpecial = false, 12)
  val Wrap = new MenuItem ("Wrap", 5.00, "Lunch", isSpecial = true, 12)

  val justDrinkOrder: List[MenuItem] = List (HotChocolate) //test

  "addSpecial" should {
    "test if a special item has been added to order" in {
      val addAWrap =  cafeLogic.addSpecial(Wrap, justDrinkOrder) //call it
     val expectedResult = List (HotChocolate, Wrap)
      addAWrap shouldBe expectedResult

    }


  }

}

/**
 * Add a new menu item to the list and Test for it
 * Test for all the items that are beverages
 * Get a recipt
 * edge cases - order an out of stock item
 */

