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
		toppings.add(topping);
	}
	
	public void removeToppings(String topping) {
		toppings.remove(topping);
	}
	
	public void setCrust(String crustType) {
		this.crustType = crustType;
	}
	
	public String getToppings() {
	String result = "";
		Iterator<String> it = toppings.iterator();
	
	while (it.hasNext()) {
		result += it.next() + "\n";
	}
	
	return result;
	
	
	}
	
	public String getCrust() {
		return crustType;
	}
}
