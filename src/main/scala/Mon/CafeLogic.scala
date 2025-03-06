package Mon

import Mon.MenuData.menuItems

//CafeLogic class - a Single responsibility for all the operation I want to perform on MenuData
//Reusable if in further the cafe wants to expand its operations & manage diff menus or cafes

class CafeLogic {

  /** Function to ADD A SPECIAL ITEM to menu e.g Luxury Hot Chocolate */
  def addSpecial(menuItem: MenuItem, menu: List[MenuItem]): List[MenuItem] = { //pass new menu item,
    (menu :+ menuItem) // (:+ append this list to the left) so menuItem to updatedMenu, returns a new list incl. original list plus new item
  }

  /** DEF function to REMOVE SPECIAL ITEM.
   * Made the method as generic as possible
   * match names to lower case names for all edge cases
   * Helps the cafe remove something by just entering the name if item instead of having to type out all corresponding info
   * Wanted to use filternot
   * As I have two bagels in my menu it removed the one on special not the normal one from the menu - WIN
   * method coded in 1 line */

  def removeSpecial(name: String, menu: List[MenuItem]): List[MenuItem] = menu.filterNot(item => item.name.toLowerCase.contains(name.toLowerCase) && item.isSpecial)
  //"item" is newly named menu for menu item for simplicity, look at each menu item in turn, check the name matches and if marked IsSpecial remove.
  // SUMMARY: Filtering list to exclude specials


  /** DEF to STOCK COUNT.
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
    updatedStock //Important to return at end!
  }



  //Could use some and none match cases?
  // OPTIONS here

  /** DEF to TAKE CUSTOMER ORDER, GIVE ITEMISED BILL with a TOTAL
   * Needs to accept the list of menu items and the customer order
   * Look at each menu in the item
   * Use of flat map to flatten any none result in final list*/

  class Bill (itemisedBill: List [String], total : Double)

  def GetCustomerBill(order: List[String]): Bill =  {

    val itemisedBill = order.flatMap { itemName =>
      menuItems.find(_.name.equalsIgnoreCase(itemName)).map { item =>
        s"${item.name}: £${item.price}"
      }
    }
    val priceTotal = order.map { itemName => menuItems.find(_.name.equalsIgnoreCase(itemName)).map {item => item.price}.sum}

    val totalCost = priceTotal.sum
    new Bill (itemisedBill, totalCost)
  }

}

object CafeLogic extends App {

  //ADD A SPECIAL (Def addSpecial)
  val cafe = new CafeLogic //instance of a class - Don't need 'new' for case class.
  val addSpecial = cafe.addSpecial(MenuData.bagel, MenuData.menuItems) //added a bagel to addSpecial
  println(addSpecial)

  //REMOVE A SPECIAL (def removeSpecial)
  val removeSpecial = cafe.removeSpecial("bagel", addSpecial)
  println(removeSpecial)

  // Stock check def customerOrderFromMenu
  //Check if things are in stock, if they are, MenuItem objects (Churros and Croissant). One is in stock only.
  val menu = List(MenuItem("Croissant", 2.50, "Bakery", isSpecial = false, 10), MenuItem("Churros", 5.50, "Lunch", isSpecial = false, 0))
  val updatedMenu = cafe.customerOrderFromMenu("Croissant", menu) //call customerOrderFromMenu. Want to order 1 croissant from "menu" list I created
println(menu)

}