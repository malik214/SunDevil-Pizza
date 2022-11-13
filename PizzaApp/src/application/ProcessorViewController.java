package application;

import java.io.IOException;

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
	// @FXML private Text orderTimeText;
	@FXML private Text estPickupTimeText;
	
	@FXML private Text pizzaTypeText;
	@FXML private Text toppingsText;
	
	@FXML private Text totalCostText;
	@FXML private Text paymentMethodText;

	@FXML private ToggleGroup processOrderToggleGroup;
	
	
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
		}
		else {
			System.out.println("Nothing selected");
		}
	}
	
	
}