package Mon

import Mon.MenuData.menuItems

//CafeLogic class - a Single responsibility for all the operation I want to perform on MenuData
//Reusable if in further the cafe wants to expand its operations & manage diff menus or cafes

class CafeLogic {

  /** Function to ADD A NEW SPECIAL ITEM to list of menu items e.g add Luxury Hot Chocolate */
  def addSpecial(menuItem: MenuItem, menu: List[MenuItem]): List[MenuItem] = { //pass new menu item,
    (menu :+ menuItem) // (:+ append this list to the left) so menuItem to updatedMenu, returns a new list incl. original list plus new item
  }


  /** DEF function to REMOVE SPECIAL ITEM.
   * match names to lower case names
   * Helps the cafe remove something by name instead of having to type out all corresponding info
   * Wanted ti use filternot
   *I just want to call it by it's name eg Bagel to remove it so staff have to type all in
   * AS I have two bagels it removed the one on special not the normal one from the menu */
  def removeSpecial (name: String, menu: List[MenuItem]): List[MenuItem] = menu.filterNot(item => item.name.toLowerCase.contains(name.toLowerCase)&& item.isSpecial)
  //"item" is newly named menu item and it looks at each one in turn and makes it lower case, then sees if it is marked IsSpecial. filtering list to exclude specials


  /** DEF to STOCK COUNT.
   * If item is at stock count = 0 you cannot order it).Also when an item is bought it needs to reduce the stock by -1
   * I found .stock when researching which is a shorthand notation that refers to a property of an object inside a collection. */
  //Could use some and none match cases? OPTIONS here
  //Could add stock : Int = 10 to the case class (Menu.scala) and then use ite.copy stock -1 each time as case items

  //def totalStockCount: Int = {
  //menuItems.map(_.stock).sum //map over all my  (_.stock for each element in the collection) and add up

  //list is 10 of each, place an order -1  and retunr a list with an order
  //map
  //item => - 1

}


/** DEF to TAKE CUSTOMER ORDER, GIVE ITEMISED BILL with a TOTAL */
//def customerBill()



object CafeLogic extends App {

  val cafe = new CafeLogic //instance of a class - since it is a normal class we need "new" when instantiating an object. Don't need new for case class.
  val addSpecial = cafe.addSpecial(MenuData.bagel, MenuData.menuItems)  //added a bagel to addSpecial
  println(addSpecial)

  val removeSpecial = cafe.removeSpecial("bagel", addSpecial)
  println(removeSpecial)

}