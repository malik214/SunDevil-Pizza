package application;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;


public class Pizza {
	
	private Set<String> toppings;
	private String crustType;
	
	Pizza(){
		toppings = new HashSet<>();
	}
	
	public void setToppings(String topping) {
		if (toppings.contains(topping)) {
			toppings.remove(topping);
		}
		
		else {
			toppings.add(topping);
		}
		
		
	}
	
	
	
	public void setCrust(String crustType) {
		this.crustType = crustType;
	}
	
	public String getToppings() {
	String result = "";
		Iterator<String> it = toppings.iterator();
	
	while (it.hasNext()) {
		result += String.format("%-15s %15s\n", it.next(),  "$1.99");
	}
	
	return result;
	
	
	}
	
	public String getCrust() {
		return crustType;
	}
}
