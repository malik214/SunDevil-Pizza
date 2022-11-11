package application;

import java.util.HashSet;
import java.util.Set;

public class Pizza {
	private String pizzaType;
	private Set<String> toppings;
	private double price;

	Pizza() {
		this.toppings = new HashSet<String>();
		price = 12.99;
	}

	public String getPizzaType() {
		return this.pizzaType;
	}

	public void setPizzaType(String pizzaType) {
		this.pizzaType = pizzaType;
	}

	public Set<String> getToppings() {
		return this.toppings;
	}

	public void addTopping(String topping) {
		this.toppings.add(topping);
	}

	public void removeTopping(String topping) {
		this.toppings.remove(topping);
	}
	
	public void setPrice() {
		price += 1.99 * toppings.size();
	}
	
	public String getPrice() {
		
		return "$" + Double.toString(price);
	}

}

