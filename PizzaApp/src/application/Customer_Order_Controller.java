package application;

import java.io.IOException;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.RadioButton;
import javafx.stage.Stage;

public class Customer_Order_Controller {
	private Stage stage;
	private Scene scene;
	private Parent root;

	Pizza myPizza = new Pizza();
	
	
	
	
	
	
	@FXML					 // I can use this so set a component upon the page loading
	public void initialize() {
		
	}
	
	public void switchToPayment(ActionEvent event) throws IOException {

		FXMLLoader loader = new FXMLLoader(getClass().getResource("Customer_Payment.fxml"));
		root = loader.load();

		Customer_Payment_Controller paymentController = loader.getController();

		paymentController.displayPizza(myPizza);

		//root = FXMLLoader.load(getClass().getResource("Customer_Payment.fxml"));

		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void changeToppings(ActionEvent event) throws IOException {
        CheckBox source = (CheckBox)event.getSource();
        myPizza.setToppings(source.getText());
	}

	public void setCrust(ActionEvent event) throws IOException{
		RadioButton source = (RadioButton)event.getSource();
		myPizza.setCrust("");
		myPizza.setCrust(source.getText());
	}
	

	

}
