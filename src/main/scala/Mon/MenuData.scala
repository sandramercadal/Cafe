package Mon

// My MenuData object contains a list of MenuItem instances as working with collections of case classes means I can filter, map and fold using standard collection methods.
//Enhances safety.
//Code is more maintainable as it's a cafe they may want to change their menu.
class MenuData (val menuItems: List[MenuItem]) //my class takes a parameter of menuItems which is a list of menuItem. If I need to create an instance of MenuData I need to provide a list of MenuItem objects


//Single instance of my class containing my static list of menuItems predefined with several items like Latte and Donut already
object MenuData {
  val menuItems: List[MenuItem] = List (
    MenuItem ("Croissant", 2.50, "ColdFood", isSpecial = false, 10),
    MenuItem ("bagel", 2.00, "ColdFood", isSpecial = false, 10),
    MenuItem ("Muffin", 2.50, "ColdFood", isSpecial = false, 15),
    MenuItem ("Donut", 2.50, "ColdFood", isSpecial = false, 12),
    MenuItem ("Sandwich", 5.50, "ColdFood", isSpecial = false, 10),
    MenuItem ("Wrap", 5.00, "ColdFood", isSpecial = false, 12),
    MenuItem ("Salad", 5.50, "ColdFood", isSpecial = false, 6),
    MenuItem ("Mocha", 3.50, "Drinks", isSpecial = false, 15),
    MenuItem ("Espresso", 2.50, "Drinks", isSpecial = false, 25),
    MenuItem ("latte", 3.50, "Drinks", isSpecial = false, 30),
    MenuItem ("Americano", 3.50, "Drinks", isSpecial = false, 30),
    MenuItem ("Hot Chocolate", 3.50, "Drinks", isSpecial = false, 15),
    MenuItem ("Quiche", 5.50, "HotFood", isSpecial = false, 7),
    MenuItem ("Hot Churros", 5.50, "HotFood", isSpecial = false, 0),
    MenuItem ("Chorizo Bap", 5.50, "Hot Food", isSpecial = false, 0),
  )

  //true values
  val bagel = MenuItem ("Bagel", 5.50, "Lunch", isSpecial = true, 7)
  val tea = MenuItem ("Tea", 2.50, "Beverages", isSpecial = true, 100)

}
