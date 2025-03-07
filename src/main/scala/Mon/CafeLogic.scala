package Mon

import Mon.MenuData.menuItems

import java.security.Provider.Service

//CafeLogic class - a Single responsibility for all the operation I want to perform on MenuData
//Reusable if in further the cafe wants to expand its operations & manage diff menus or cafes

class CafeLogic {

  /** A D D  S P E C I A L to menu** e.g Luxury Hot Choc ☕️ */
  def addSpecial(menuItem: MenuItem, menu: List[MenuItem]): List[MenuItem] = { //pass new menu item,
    (menu :+ menuItem) // (:+ append this list to the left) so menuItem to updatedMenu, returns a new list incl. original list plus new item
  }

  /** R E M O V E  S P E C I A L **.
   * Made the method as generic as possible
   * match names to lower case names for all edge cases
   * Helps the cafe remove something by just entering the name if item instead of having to type out all corresponding info
   * Wanted to use filternot
   * As I have two bagels in my menu it removed the one on special not the normal one from the menu - WIN
   * method coded in 1 line */

  def removeSpecial(name: String, menu: List[MenuItem]): List[MenuItem] = menu.filterNot(item => item.name.toLowerCase.contains(name.toLowerCase) && item.isSpecial)
  //"item" is newly named menu for menu item for simplicity, look at each menu item in turn, check the name matches and if marked IsSpecial remove.
  // SUMMARY: Filtering list to exclude specials
//exact match, use .equalsIgnoreCase(name) to filer Mocha from Luxury Mocha

  /** S T O C K  C O U N T **
   * If item is at stock count = 0 you cannot order it. When an item is bought, reduce the stock by -1
   * I found .stock a shorthand notation that refers to a property of an object inside a collection.
   * Wanted to use .copy here */

  def customerOrderFromMenu(itemName: String, menuItems: List[MenuItem]): List[MenuItem] = { //take in itemMName and a list of MenuItem objects
    val updatedStock = menuItems.map { item => //map through each item in menuItems list
      if (item.name.equalsIgnoreCase(itemName) && item.stock > 0) { //for each item, checks item name & stock is greater than zero. If both true reduce stock by creating a copy and updates stock
        item.copy(stock = item.stock - 1)
      } else {
        item
      }
    }
    updatedStock //Return at end!
  }


  /** B I L L ** TAKE CUSTOMER ORDER, GIVE ITEMISED BILL with a TOTAL
   * Needs to accept the list of menu items and the customer order
   * Look at each menu in the item
   * Use of flat map to flatten any none result in final list */

  class Bill(itemisedBill: List[String], total: Double) //class represents a bill that contain 2 params: Itemised bill and total (Double)

  def GetCustomerBill(order: List[String]): Bill = { //

    val itemisedBill = order.flatMap { itemName => //use flatmap to flatten
      menuItems.find(_.name.equalsIgnoreCase(itemName)).map { item => //search for a matching item in MenuItems & do a case-insensitive match
        s"${item.name}: £${item.price}"
      }
    }
    val priceTotal = order.map { itemName => menuItems.find(_.name.equalsIgnoreCase(itemName)).map { item => item.price }.sum }
    val totalCost = priceTotal.sum
    new Bill(itemisedBill, totalCost)
  }

  /** S E R V I C E  C H A R G E **
   * Ability to custom additional service charge or instead? */

  //  class Order(val menuList: List[MenuItem]) {
  //    def getBillWithServiceCharge (): Double = {
  //      val total = menuList.map(_.price).sum
  //      val serviceCharge = if (menuItems.exists(_.isSpecial)) {
  //        total * 0.25
  //      } else if (menuItems.exists(_.category == "HotFood")) {
  //        total * 0.20
  //      } else if (menuItems.exists(_.category == "ColdFood")) {
  //        total * 0.10
  //      } else{
  //        0.0
  //    }
  //      total + serviceCharge
  //  }

  class OrderList(val menuList: List[MenuItem]) {

    def billWithServiceCharge(): Double = {
      val total = menuList.map(_.price).sum


      val optionalServiceCharge: Option[Double] =
        if (menuList.exists(_.isSpecial)) Some(total * 0.25)
        else if (menuList.exists(_.category == "HotFood")) Some(total * 0.20)
        else if (menuList.exists(_.category == "ColdFood")) Some(total * 0.10)
        else None

      val serviceCharge = optionalServiceCharge.getOrElse(0.0)

      total + serviceCharge
    }


    object CafeLogic extends App {

      //ADD A SPECIAL (def addSpecial)
      val cafe = new CafeLogic //instance of a class - Don't need 'new' for case class.
      val addSpecial = cafe.addSpecial(MenuData.bagel, MenuData.menuItems) //added a bagel to addSpecial
      println(addSpecial)

      //REMOVE A SPECIAL (def removeSpecial)

      val removeSpecial = cafe.removeSpecial("bagel", menu)
      println(removeSpecial)

      // STOCK CHECK (def customerOrderFromMenu)
      //With Churros and Croissant only Croissant is in stock.
      val menu = List(MenuItem("Croissant", 2.50, "ColdFood", isSpecial = false, 10), MenuItem("Hot Churros", 5.50, "HotFood", isSpecial = false, 0))
      val updatedMenu = cafe.customerOrderFromMenu("Croissant", menu) //call customerOrderFromMenu. Want to order 1 croissant from "menu" list I created
      println(menu)

      //BILL (


    }
  }
}