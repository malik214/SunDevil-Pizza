package application;

import java.time.LocalDate;
import java.time.LocalTime;

public class Order {
	private Pizza pizza;
	private Customer customer;
	private LocalDate date;
	private String time;
	private String status;

	public void setStatus(String status) {
		this.status = status;
	}

	public void setPizza(Pizza pizza) {
		this.pizza = pizza;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getStatus() {
		return status;
	}

	public LocalDate getDate() {
		return date;
	}

	public String getTime() {
		return time;
	}

	public Customer getCustomer() {
		return customer;
	}

	public Pizza getPizza() {
		return pizza;
	}

}
