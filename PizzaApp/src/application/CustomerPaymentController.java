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
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Text;

public class CustomerPaymentController {
	@FXML private Text pizzaTypeText;
	@FXML private Text toppingsText;
	
	@FXML private TextField nameTextField;
	@FXML private TextField asuriteIdTextField;
	@FXML private TextField passwordTextField;
	
	@FXML private Text estPickupTimeText;
	@FXML private Text totalCostText;
	
	private Pizza myPizza;
	private Customer myCustomer;
	
	@FXML
	public void initialize() {
		myCustomer = new Customer();
	}
	
	public void setPizza(Pizza pizza) {
		myPizza = pizza;
		this.displayPizza();
	}
	
	private void displayPizza() {
		pizzaTypeText.setText(myPizza.getPizzaType());
		toppingsText.setText(String.join(", ", myPizza.getToppings()));
		
		
		myPizza.setPrice();
		totalCostText.setText(myPizza.getPrice());
	}
	
	
	public void displayPickupTime(String pickupDate, String pickupTime) {
		estPickupTimeText.setText(pickupDate + " @ " + pickupTime);
	}
	
	
	public void setCustomerName(KeyEvent event) throws IOException{
		myCustomer.setName(((TextField)event.getSource()).getText());
		System.out.println(myCustomer.getName());
	}
	
	public void setCustomerASUID(KeyEvent event) throws IOException{
		myCustomer.setAsuriteID(((TextField)event.getSource()).getText());
		System.out.println(myCustomer.getAsuriteID());
	}
	
	public void setCustomerPassword(KeyEvent event)throws IOException{
		myCustomer.setPassword(((TextField)event.getSource()).getText());
		System.out.println(myCustomer.getPassword());
	}
	
	public void placeOrder(ActionEvent event) throws IOException {
		if (nameTextField.getText().length() > 0 && asuriteIdTextField.getText().length() > 0 && passwordTextField.getText().length() > 0) {
			System.out.println("Place order");
			
			FXMLLoader loader = new FXMLLoader(getClass().getResource("CustomerConfirmationUI.fxml"));
			Parent root = loader.load();
			
			CustomerConfirmationController confirmationController = loader.getController();
			confirmationController.setCustomer(myCustomer);
			confirmationController.setThankYouMessage();
			confirmationController.setEmailMessage();
			
			Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
		}
		else {
			System.out.println("Missing name, username, or password!");
		}
	}
}