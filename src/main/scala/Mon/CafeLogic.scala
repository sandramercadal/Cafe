package Mon

//Update the name of my menu.scala to MenuItem.scala - ISSUES ASK APRIL

class CafeLogic {

  /** DEF function to ADD SPECIAL ITEM e.g Luxury Hot Chocolate */
  def addSpecial(menuItem: MenuItem, updatedMenu: List[MenuItem]): List[MenuItem] = { //passing in our menu item, where to put it?

   (updatedMenu :+ menuItem) //Like we did with cats and Birds in Kennel

  }
//println (addSpecial(MenuData.bagel, MenuData.menuItems))
  /**   Test a special to the list of all the other cafe Items   */
  //MenuData.addSpecial("Luxury Hot Chocolate", 4.25, "Beverages")
  //addSpecial("Luxury Chai Latte", 4.25, "Beverages")

  /** DEF function to REMOVE SPECIAL ITEM. I have to match the lower case names and make sure it is marked as special */
 // def removeSpecial(name: String): Unit = { //I  just want to call it by it's name to remove it so don't have to type all in
   // menuItems = menuItems.filter(menuItem => menuItem.name.toLowerCase || !menuItem.isSpecial) //Initially started with filterNot
  //}


//MenuData.removeSpecial("Luxury Hot Chocolate")


/** DEF to STOCK COUNT.
 * If item is at stock count = 0 you cannot order it).Also when an item is bought it needs to reduce the stock by -1
 * I found .stock when researching which is a shorthand notation that refers to a property of an object inside a collection. */
//Could use some and none match cases? OPTIONS here
//Could add stock : Int = 10 to the case class (Menu.scala) and then use ite.copy stock -1 each time as case items

//def totalStockCount: Int = {
  //menuItems.map(_.stock).sum //map over all my  (_.stock for each element in the collection) and add up
}





/** DEF to TAKE CUSTOMER ORDER, GIVE ITEMISED BILL with a TOTAL */
//def customerBill()

object CafeLogic extends App {


}