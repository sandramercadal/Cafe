import Mon.{CafeLogic, MenuData, MenuItem}
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

import scala.reflect.internal.Chars.isSpecial

class CafeLogicSpec extends AnyWordSpec with Matchers {

  val cafeLogic = new CafeLogic

  //Define menu items: Wrap🌯 & Luxury Hot choc☕️ are special items
  val Wrap = new MenuItem("Wrap", 5.00, "ColdFood", isSpecial = true, 12)
  val LuxuryHotChocolate = new MenuItem("Luxury Hot Chocolate", 4.75, "Drinks", isSpecial = true, 10)

  val Donut = new MenuItem("Donut", 2.50, "ColdFood", isSpecial = false, 12)
  val Coffee = new MenuItem("Coffee", 2.50, "Drinks", isSpecial = false, 30)
  val HotChocolate = new MenuItem("Hot Chocolate", 3.50, "Drinks", isSpecial = false, 15)
  val Mocha = new MenuItem("Mocha", 3.50, "Drinks", isSpecial = false, 15)
  val Salad = new MenuItem("Salad", 5.50, "ColdFood", isSpecial = false, 6)
  val HotChurros = new MenuItem("Hot Churros", 5.50, "HotFood", isSpecial = false, 0)

  //Represents initial orders
  val justDrinkOrder: List[MenuItem] = List(Coffee)

  val emptyOrder: List[MenuItem] = List()

  val order: List[String] = List("Salad", "Hot Churros", "Salad") //Order with 3 string items for Bill testing incl. 2 Salads

  val fullOrder: List[MenuItem] = List(Wrap, LuxuryHotChocolate, Donut, Coffee) //specials & non-special mixed order


  //Test Case 1- can a special item (Wrap) be added to justDrinkOrder
  "addSpecial" should {
    "test if a special item has been added to order" in {
      val addAWrap = cafeLogic.addSpecial(Wrap, justDrinkOrder) //call it
      val expectedResult = List(Coffee, Wrap)
      addAWrap shouldBe expectedResult
    }
  }

  //Test case 2- Can a non-special item (donut) be added to justDrinkOrder
  "addNonSpecial" should {
    "test if a non special item has been added to the order" in {
      val addADonut = cafeLogic.addSpecial(Donut, justDrinkOrder) //call it
      val expectedResult = List(Coffee, Donut)
      addADonut shouldBe expectedResult
    }
  }

  //Test Case 3- Can multiple specials be added to justDrinkOrder
  "addMultipleSpecials" should {
    "test if more than one special item has been added to the order" in {
      val addWrap = cafeLogic.addSpecial(Wrap, justDrinkOrder) //call it
      val expectedResult = List(Coffee, Wrap)
      addWrap shouldBe expectedResult
    }
    "test if another special item has been added to the order" in {
      val addLuxuryHotChocolate = cafeLogic.addSpecial(LuxuryHotChocolate, justDrinkOrder) //call it
      val expectedResult = List(Coffee, LuxuryHotChocolate)
      addLuxuryHotChocolate shouldBe expectedResult
    }
  }

  //Test Case 4- Can multiple non-specials be added to JustDrinkOrder
  "addMultipleNonSpecials" should {

    "test if more than one non-special item (Donut) has been added to the order" in {
      val addADonut = cafeLogic.addSpecial(Donut, justDrinkOrder) //call it
      val expectedResult = List(Coffee, Donut)
      addADonut shouldBe expectedResult
    }
    "test if more than one non-special item in addition (Mocha) has been added to the order" in {
      val addMocha = cafeLogic.addSpecial(Mocha, justDrinkOrder) //call it
      val expectedResult = List(Coffee, Mocha)
      addMocha shouldBe expectedResult
    }
  }

  //Test Case 5- Add a special to an empty order list
  "addSpecialToEmptyOrder" should {
    "test if a special can be added to an empty order" in {
      val emptyOrder: List[MenuItem] = List()
      val addAWrap = cafeLogic.addSpecial(Wrap, emptyOrder)
      val expectedResult = List(Wrap)
      addAWrap shouldBe expectedResult
    }
  }

  //Test Case 6- Add a non-special to an empty order list
  "addNonSpecialToEmptyOrder" should {
    "test if a non-special can be added to an empty order" in {
      val emptyOrder: List[MenuItem] = List()
      val addACoffee = cafeLogic.addSpecial(Coffee, emptyOrder)
      val expectedResult = List(Coffee)
      addACoffee shouldBe expectedResult
    }
  }

  //Test Case 7- Test adding more than one non-special item as customer may want 2 donuts etc
  "addAnotherNonSpecial" should {
    "test if more than 1 of the same item can be added to order as customer may want more than 1" in {
      val addADonut = cafeLogic.addSpecial(Donut, justDrinkOrder) //call it
      val addAnotherDonut = cafeLogic.addSpecial(Donut, addADonut) //call it
      val expectedResult = List(Coffee, Donut, Donut)
      addAnotherDonut shouldBe expectedResult
    }
  }

  //Test Case 8- Test adding more than one special item as customer may want 2 wraps
  "addAnotherSpecial" should {
    "test if more than 1 of the same special item can be added to order as customer may want more than 1" in {
      val addAWrap = cafeLogic.addSpecial(Wrap, justDrinkOrder) //call it
      val addAnotherWrap = cafeLogic.addSpecial(Wrap, addAWrap) //call it
      val expectedResult = List(Coffee, Wrap, Wrap)
      addAnotherWrap shouldBe expectedResult
    }
  }

  //Test Case 9- Test to remove one special item
  "removeSpecial" should {
    "test if a special item can be removed from the order" in {
      val updatedOrder = cafeLogic.removeSpecial("Wrap", fullOrder)
      val expectedResult = List(LuxuryHotChocolate, Donut, Coffee)
      updatedOrder shouldBe expectedResult

    }
  }

  /** Stock* */
  //Test Case 1- Test that STOCK can decrease when non-special item is bought by customer
  "customerOrderFromMenu" should {
    "test if the stock decreases when an item is ordered" in {
      val initialOrder = List(MenuItem("Salad", 5.50, "ColdFood", isSpecial = false, stock = 6))
      val updatedOrder = cafeLogic.customerOrderFromMenu("Salad", initialOrder)
      val expectedResult = List(MenuItem("Salad", 5.50, "ColdFood", isSpecial = false, stock = 5)) //Now 5 not 6
      updatedOrder shouldBe expectedResult
    }
  }
  /** Further tests for stock can be:
   * A test that should pass if it does not decrease stock if item is out of stock
   * A test for stock should not change if it is not ordered
   */

  /** B I L L **
   Gives a memory location not 16.50**/
    "getBill" should {
      "provide correct itemised bill for correct order" in {
        val letsOrder = List("Salad", "Hot Churros", "Salad")
        val bill = cafeLogic.GetCustomerBill(order)
        val expectedItemisedBill = List("Salad: £5.50", "Hot churros: £5.50", "Salad: £5.50")
        val expectedTotalBill = 16.50
        bill shouldBe expectedTotalBill
      }
    }

  /** Further tests for Bill can be:
   * 1.
   * 2.
   */


  /** S E R V I C E  C H A R G E **
   * 1: Total with just drinks
   * 2. Total with cold food and drinks (10%)
   * 3. Total with hot food and drinks (20%)
   * 4. Total of special food and drinks (25%)
   * 5. Total with custom service charge
   */



}



