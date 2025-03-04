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

  def customerOrder(itemName: String): Unit = {
    val updatedStock = menuItems.map { item =>
      if (item.name.equalsIgnoreCase(itemName) && item.stock > 0) {
        item.copy(stock = item.stock - 1)

      } else {
        item
      }
    }



    //Could use some and none match cases? OPTIONS here
    //Could add stock : Int = 10 to the case class (Menu.scala) and then use ite.copy stock -1 each time as case items

    //def totalStockCount: Int = {
    //menuItems.map(_.stock).sum //map over all my  (_.stock for each element in the collection) and add up

    //list is 10 of each, place an order -1  and retunr a list with an order
    //map
    //item => - 1

    /** DEF to TAKE CUSTOMER ORDER, GIVE ITEMISED BILL with a TOTAL */
    //def customerBill()


  }


  object CafeLogic extends App {

    val cafe = new CafeLogic //instance of a class - since it is a normal class we need "new" when instantiating an object. Don't need new for case class.
    val addSpecial = cafe.addSpecial(MenuData.bagel, MenuData.menuItems) //added a bagel to addSpecial
    println(addSpecial)

    val removeSpecial = cafe.removeSpecial("bagel", addSpecial)
    println(removeSpecial)


  }