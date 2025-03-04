import Mon.{CafeLogic, MenuData, MenuItem}
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class CafeLogicSpec extends AnyWordSpec with Matchers {

  val cafeLogic = new CafeLogic

  //Define 3 menu items, Wrap and Luxury Hot choc are special items
  val HotChocolate = new MenuItem("Hot Chocolate", 3.50, "Beverages", isSpecial = false, 15)
  val LuxuryHotChocolate = new MenuItem("Luxury Hot Chocolate", 4.75, "Beverages", isSpecial = true, 10)
  val Donut = new MenuItem("Donut", 2.50, "Bakery", isSpecial = false, 12)
  val Coffee = new MenuItem("Coffee", 2.50, "Beverages", isSpecial = false, 30)
  val Wrap = new MenuItem("Wrap", 5.00, "Lunch", isSpecial = true, 12)


  //MY TESTS
  val justDrinkOrder: List[MenuItem] = List(HotChocolate) //Represents initial order

  //Test Case 1- can a special item (Wrap) be added to justDrinkOrder
  "addSpecial" should {
    "test if a special item has been added to order" in {
      val addAWrap = cafeLogic.addSpecial(Wrap, justDrinkOrder) //call it
      val expectedResult = List(HotChocolate, Wrap)
      addAWrap shouldBe expectedResult
    }
  }

  //Test case 2- Can a non-special item (donut) be added to justDrinkOrder
  "addNonSpecial" should {
    "test if a non special item has been added to the order" in {
      val addADonut = cafeLogic.addSpecial(Donut, justDrinkOrder) //call it
      val expectedResult = List(HotChocolate, Donut)
      addADonut shouldBe expectedResult
    }
  }

  //Test Case 3- Can multiple specials be added to justDrinkOrder
  "addMultipleSpecials" should {
    "test if more than one special item has been added to the order" in {
      val addWrap = cafeLogic.addSpecial(Wrap, justDrinkOrder) //call it
      val addLuxuryHotChoc = cafeLogic.addSpecial(LuxuryHotChocolate, justDrinkOrder) //call it
      val expectedResult = List(Wrap, LuxuryHotChocolate, HotChocolate)
    }
  }

  //Test Case 4- Can multiple non-specials be added to JustDrinkOrder
  "addMultipleNonSpecials" should {
    "test if more than one non-special item has been added to the order" in {
      val addADonut = cafeLogic.addSpecial(Donut, justDrinkOrder) //call it
      val addCoffee = cafeLogic.addSpecial(Coffee, justDrinkOrder) //call it
      val expectedResult = List(Coffee, Donut, HotChocolate)
    }
  }

//Test Case 5- Add a special to an empty order list
  "addSpecialToEmptyOrder" should {
    "test if a special can be added to an empty order" in {
      val emptyOrder: List[MenuItem] = List () //
      val addAWrap = cafeLogic.addSpecial(Wrap, emptyOrder)
      val expectedResult = List(Wrap)
    }
  }

//Test Case 6- Add a non-special to an empty order list
  "addNonSpecialToEmptyOrder" should {
    "test if a non-special can be added to an empty order" in {
      val emptyOrder: List[MenuItem] = List () //
      val addAWrap = cafeLogic.addSpecial(Coffee, emptyOrder)
      val expectedResult = List(Coffee)
    }
  }

//Test Case 7- Add an invalid menu item


//Test Case 8- Test if adding something in an order already works as customer may want 2 Lattes



}

/**
 * Add a new menu item to the list and Test for it
 * Test for all the items that are beverages
 * Get a recipts
 * edge cases - order an out of stock item
 */

