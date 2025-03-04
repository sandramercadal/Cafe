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

  //Represents initial order
  val justDrinkOrder: List[MenuItem] = List(HotChocolate)

  //MY TESTS
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
      val emptyOrder: List[MenuItem] = List ()
      val addAWrap = cafeLogic.addSpecial(Wrap, emptyOrder)
      val expectedResult = List(Wrap)
    }
  }

//Test Case 6- Add a non-special to an empty order list
  "addNonSpecialToEmptyOrder" should {
    "test if a non-special can be added to an empty order" in {
      val emptyOrder: List[MenuItem] = List ()
      val addAWrap = cafeLogic.addSpecial(Coffee, emptyOrder)
      val expectedResult = List(Coffee)
    }
  }

//Test Case 7- Test adding more than one non-special item as customer may want 2 donuts etc
  "addAnotherNonSpecial" should {
    "test if the non-special same item can be added to order as customer may want more than 1" in {
      val addADonut = cafeLogic.addSpecial(Donut, justDrinkOrder) //call it
      val addAnotherDonut = cafeLogic.addSpecial(Donut, addADonut) //call it
      val expectedResult = List(Donut, Donut, HotChocolate)
    }
  }

  //Test Case 8- Test adding more than one special item as customer may want 2 wraps
    "addAnotherSpecial" should {
    "test if the special same item can be added to order as customer may want more than 1" in {
      val addAWrap = cafeLogic.addSpecial(Wrap, justDrinkOrder) //call it
      val addAnotherWrap = cafeLogic.addSpecial(Wrap, addAWrap) //call it
      val expectedResult = List(Wrap, Wrap, HotChocolate)
    }
  }

  //Test Case 9- Add an invalid menu item. HOW TO DO THIS??




// Test case 10 - edge cases - order an out of stock item




}


