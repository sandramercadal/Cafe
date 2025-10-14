import Mon.MenuData.menuItems


val order: List [String] = List ("Salad", "Churros", "Salad")

order.flatMap { itemName => menuItems }
order.flatMap { itemName => menuItems.find(_.name.equalsIgnoreCase(itemName)) }
val ItemisedBill = order.flatMap { itemName => menuItems.find(_.name.equalsIgnoreCase(itemName)).map { item =>  s"${item.name}: £${item.price}"}}

val priceTotal = order.map { itemName => menuItems.find(_.name.equalsIgnoreCase(itemName)).map {item => item.price}.sum}

val totalCost = priceTotal.sum

// takes in customer order as a string and returns a tuple 1.List of ordered items 2. total cost of order
//Create itemised bill & flat map is called on the order list
//find searches through menuItems to check if any name matches itemName from the order and ignores rest
//if any match found, returns an option (map) to transform the found item to a string.
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

