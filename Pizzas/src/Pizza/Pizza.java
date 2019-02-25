package Pizza;

//Tha Kim
//Makes pizza class and objects

public class Pizza {

  //Variables
  private String pizzaSize; //Size of the pizza
  private int pizzaMeat; //Amount of Meat toppings
  private int pizzaVegatable; //Amount of vegatable toppings
  private int pizzaPrice;//price of the pizza

  // Pizza constructor
  public Pizza(String size, int meat, int vegatable){
      pizzaSize = size;
      pizzaMeat = meat;
      pizzaVegatable = vegatable;
  }

  public String getSize(){
      return pizzaSize;
  }

  public int getMeat(){
      return pizzaMeat;
  }

  public int getVegatable(){
      return pizzaVegatable;
  }

  public void setSize(String size){
      pizzaSize = size;
  }

  public void setMeat(int meat){
      pizzaMeat = meat;
  }

  public void setVegatable(int vegatable){
      pizzaVegatable = vegatable;
  }

  public int getCost(){
	  switch(getSize()) {
	   case "small" :
		  pizzaPrice = 8;
	      break; // optional
	   case "medium" :
		   pizzaPrice = 10;
	      break; // optional
	   default : // Optional
		   pizzaPrice = 12;
	}

       return pizzaPrice + (2 * (getMeat() + getVegatable()));
  }

  public String toString(){
	  return String.format("A %2s pizza with %2d topping of meat and %2d topping of veggie.\nThe total cost is %02d ", 
			  getSize(), getMeat(), getVegatable(), getCost());
  }
}
