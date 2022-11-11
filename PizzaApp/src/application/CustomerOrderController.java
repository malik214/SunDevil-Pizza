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

public class CustomerOrderController {
	private Pizza myPizza = new Pizza();
	private String pickupDate;
	private String pickupTime;
	
	@FXML private ToggleGroup pizzaTypeToggleGroup;
	
	
	public void changePizzaType(ActionEvent event) throws IOException {
		String pizzaType = ((RadioButton)event.getSource()).getText();
		myPizza.setPizzaType(pizzaType);
		System.out.println(myPizza.getPizzaType());
	}
	
	public void changeToppings(ActionEvent event) throws IOException {
		CheckBox source = (CheckBox)event.getSource();
		String topping = source.getText();
		boolean isSelected = source.isSelected();
		if (isSelected) {
			myPizza.addTopping(topping);
		}
		else {
			myPizza.removeTopping(topping);
		}
		System.out.println(myPizza.getToppings());
	}
	
	public void setPickupDate(ActionEvent event) throws IOException {
		// Input needs verification
		pickupDate = ((DatePicker)event.getSource()).getValue().toString();
		System.out.println(pickupDate);
	}
	
	public void setPickupTime(KeyEvent event) throws IOException{
		pickupTime = ((TextField)event.getSource()).getText();
		System.out.println(pickupTime);
	}
	
	public void checkoutPizza(ActionEvent event) throws IOException {
		if (pizzaTypeToggleGroup.getSelectedToggle() != null) {
			System.out.println("Checkout");
			
			FXMLLoader loader = new FXMLLoader(getClass().getResource("CustomerPaymentUI.fxml"));
			Parent root = loader.load();
			
			CustomerPaymentController paymentController = loader.getController();
			paymentController.setPizza(myPizza);
			paymentController.displayPickupTime(pickupDate, pickupTime);
			
			Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
		}
		else {
			System.out.println("No pizza type selected");
		}
	}
	
}