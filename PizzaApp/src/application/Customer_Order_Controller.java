package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.stage.Stage;

public class Customer_Order_Controller {
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	 Pizza myPizza = new Pizza();
	 
	 @FXML
	 CheckBox topping;

	public void switchToPayment(ActionEvent event) throws IOException {
		
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Customer_Payment.fxml"));
		root = loader.load();
		
		Customer_Payment_Controller paymentController = loader.getController();
		
		paymentController.displayPizza(myPizza);
		
		
		root = FXMLLoader.load(getClass().getResource("Customer_Payment.fxml"));
		
		
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void setStuffedCrust(ActionEvent event) throws IOException{
		myPizza.setCrust("");
		myPizza.setCrust("Stuffed Crust");
	}
	
	public void setCrispyCrust(ActionEvent event) throws IOException{
		myPizza.setCrust("");
		myPizza.setCrust("Thin N' Crispy");
	}
	
	public void setPanCrust(ActionEvent event) throws IOException{
		myPizza.setCrust("");
		myPizza.setCrust("Pan Pizza");
	}
	
	public void addTopping(ActionEvent event) throws IOException{
		myPizza.setToppings(topping.getText());
	}
	


}
