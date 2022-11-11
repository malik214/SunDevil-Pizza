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

public class CustomerConfirmationController {
	@FXML
	private Text thankYouMessageText;
	@FXML
	private Text emailText;
//	@FXML
//	private Text orderStatusText;
//	@FXML
//	private Text estPickupTimeText;

	private Customer myCustomer;

	public void setCustomer(Customer customer) {
		myCustomer = customer;
	}

	public void setThankYouMessage() {
		thankYouMessageText.setText(myCustomer.getName() + ", thank you for your order with SunDevil Pizza!");
	}

	public void setEmailMessage() {
		emailText.setText(myCustomer.getAsuriteID() + "@asu.edu");
	}

	public void displayPickupTime() {

	}

}
