package application;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javafx.scene.control.*;
import javafx.scene.text.Text;

public class ProcessorViewController {
	private Order currOrder;
	private Customer currCustomer;
	private Pizza currPizza;
	
	@FXML private Text nameText;
	@FXML private Text emailText;
	@FXML private Text orderTimeText;
	@FXML private Text estPickupTimeText;
	
	@FXML private Text pizzaTypeText;
	@FXML private Text toppingsText;
	
	@FXML private Text totalCostText;
	@FXML private Text paymentMethodText;

	@FXML private ToggleGroup processOrderToggleGroup;
	private LocalTime time;
	private LocalDate date;
	
	
	//This method gets called in the previous scene to pass you the order object
	public void setOrder(Order order) {
		currOrder = order;
		currCustomer = order.getCustomer();
		currPizza = order.getPizza();
	}
	
	public void displayCustomerInfo() throws IOException {
		nameText.setText(currCustomer.getName());
		emailText.setText(currCustomer.getAsuriteID() + "@asu.edu");
	}
	
	public void displayOrderTimeText() {
		time = LocalTime.now();
		date = LocalDate.now();
		
		String minutes;
		
		String suffix = "AM";
		int hour = time.getHour();
		
		if (hour > 12) {
			hour -=12;
			suffix = "PM";
		}
		
		if (hour == 12) {
			suffix = "PM";
		}
	
		
		if(time.getMinute() < 10)
			minutes = "0" + String.valueOf(time.getMinute());
		else
			minutes = String.valueOf(time.getMinute());
			
		orderTimeText.setText(date.getMonthValue() + "/" + date.getDayOfMonth() + "/" + date.getYear() + ", " + String.valueOf(hour) + ":" + minutes + " " + suffix); //maybe add date
	}

	public void displayOrderPickupInfo() {
		estPickupTimeText.setText(currOrder.getDate().getMonthValue() + "/" + currOrder.getDate().getDayOfMonth() + "/"
				+ currOrder.getDate().getYear() + ", " + currOrder.getTime());
	}
	
	public void displayPizzaInfo() {
		pizzaTypeText.setText(currPizza.getPizzaType());
		toppingsText.setText(String.join(", ", currPizza.getToppings()));
	}
	
	public void displayPaymentInfo() {
		totalCostText.setText(currPizza.getPrice());
		paymentMethodText.setText(currCustomer.getAsuriteID());
	}
	
	public void submit(ActionEvent event) throws IOException {
		RadioButton selectedToggle = (RadioButton)processOrderToggleGroup.getSelectedToggle();
		if (selectedToggle != null) {
			boolean isApproved = (selectedToggle.getText().contains("Approve"));
			if (isApproved) {
				System.out.println("Approved");
				// send to chef
				currOrder.setStatus("READY to COOK");
			}
			else {
				System.out.println("Denied");
			}
			FXMLLoader loader = new FXMLLoader(getClass().getResource("ChefViewUI.fxml"));
			Parent root = loader.load();

			ChefViewController chef = loader.getController();
			chef.setOrder(currOrder);
			chef.setNameText();
			chef.setEmailText();
			chef.displayOrderTimeText();
			chef.displayEstPickupTimeText();
			chef.displayPizzaInfo();
			
			Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
		}
		else {
			System.out.println("Nothing selected");
		}
	}
	
	
}