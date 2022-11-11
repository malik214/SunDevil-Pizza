package application;

import java.util.HashSet;
import java.util.Set;

public class Pizza {
	private String pizzaType;
	private Set<String> toppings;
	
	Pizza() {
		this.toppings = new HashSet<String>();
	}
	
	
	public String getPizzaType() { return this.pizzaType; }
	public void setPizzaType(String pizzaType) {
		this.pizzaType = pizzaType;
	}
	
	public Set<String> getToppings() { return this.toppings; }
	public void addTopping(String topping) {
		this.toppings.add(topping);
	}
	public void removeTopping(String topping) {
		this.toppings.remove(topping);
	}
	
	
}


//public class Pizza {
//	
//	private Set<String> toppings;
//	private String crustType;
//	
//	Pizza(){
//		toppings = new HashSet<>();
//	}
//	
//	public void setToppings(String topping) {
//		if (toppings.contains(topping)) {
//			toppings.remove(topping);
//		}
//		
//		else {
//			toppings.add(topping);
//		}
//		
//		
//	}
//	
//	
//	
//	public void setCrust(String crustType) {
//		this.crustType = crustType;
//	}
//	
//	public String getToppings() {
//	String result = "";
//		Iterator<String> it = toppings.iterator();
//	
//	while (it.hasNext()) {
//		result += String.format("%-15s %15s\n", it.next(),  "$1.99");
//	}
//	
//	return result;
//	
//	
//	}
//	
//	public String getCrust() {
//		return crustType;
//	}
//}
