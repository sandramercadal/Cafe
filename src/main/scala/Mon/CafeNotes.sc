//Last weekend I created a case class of Toys so decided to start with a case class (See MenuItems.scala)
//This case class allows for immutable menu items.
//This case class allows for clean code in 1 line.
//This case class allows for useful built-in methods like .copy which I may need later on.
//This case class allows for Pattern Matching which again I may need later on.
//Fields are val by default so perfect for each menu item.
//This case class allows for comparisons and debugging.

/** Manage the menu
 * Q1 - See Menu.scala and MenuData.scala
 * case class MenuItem(name: String, category: String, price: Double, isSpecial: Boolean)
  *Store a list of menu items by name, price and category (use a boolean for isSpecial here??)
 * object MenuData {
 * val menuItems: List[MenuItem] = List (
 * MenuItem ("Croissant", 2.50, "Bakery", isSpecial = false) etc

 *Q2//This is like the kennel example where we added on cats and birds to the kennel :+
 //that I also did last weekend
 * Add Premium Specials - see CafeLogic
 *Remove Premium Specials - see CafeLogic

 *Q3
*Track inventory/Stock count of menu items
 *Cannot order something that is out of stock - need a counter to map to items in stock
*/

/** Take customer orders
 * Add up the total
 * Add an optional service charge
 * */


/** manage the Service Charge - TUES??
 * Do not apply it
 * Add 10% to cold food orders
 * Add 20% to hot food orders
 * Add 25% to premium special orders
 * Add extra service charge
 * Add service charge instead of what is the norm
 * */

