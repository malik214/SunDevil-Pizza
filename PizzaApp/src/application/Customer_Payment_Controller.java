package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class Customer_Payment_Controller {
	private Stage stage;
	private Scene scene;
	private Parent root;

	@FXML
	Label labelText;

	

	public void switchToConfirmation(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("Customer_Confirm.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

	public void switchToOrder(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("Customer_Order.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();

	}

	public void displayPizza(Pizza pizza) {

		labelText.setText(String.format("%-15s %15s", pizza.getCrust(), "$12.99\n") + pizza.getToppings());

	}

	public void displayDate() {
		
	}

}
