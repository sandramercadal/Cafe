
import Mon.MenuItem

case class MenuItem(name: String, price: Double, category: String, isSpecial: Boolean, stock: Int)

val orderList: List[MenuItem] = List(
  MenuItem("Croissant", 2.50, "ColdFood", isSpecial = false, 10),
  MenuItem("Bagel", 2.00, "ColdFood", isSpecial = false, 10),
  MenuItem("Mocha", 3.50, "Drinks", isSpecial = false, 15),
  MenuItem("Espresso", 2.50, "Drinks", isSpecial = false, 25),
  MenuItem("Quiche", 5.50, "HotFood", isSpecial = false, 7),
  MenuItem("Luxury Mocha", 4.00, "Drinks", isSpecial = true, 10),
  MenuItem("Sangria", 4.50, "Drinks", isSpecial = true, 25),
)

//Class to process order
class OrderList(val menuList: List[MenuItem]) {

  def billWithServiceCharge(): Double = {
    val total = menuList.map(_.price).sum


    val optionalServiceCharge: Option[Double] =
//      if (menuList.exists(_.isSpecial)) Some(total * 0.25)
//      else if (menuList.exists(_.category == "HotFood")) Some(total * 0.20)
//      else if (menuList.exists(_.category == "ColdFood")) Some(total * 0.10)
//      else None
//
//    val serviceCharge = optionalServiceCharge.getOrElse(0.0)
//
//    total + serviceCharge
//  }
//
//
//  val myOrder = new OrderList(orderList)
//  val totalCost = myOrder.billWithServiceCharge()
//  println(f"Total bill with service charge: £${totalCost}%.2f")
//

}

//no service charge on NOne
//val optionalServ...using an Option to hold the service charge
//total + serviceCharge //get total bil with S.Charge
//Used of an option double and if condition using { } invalid syntax
//( method lower case)
