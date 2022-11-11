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

public class ChefViewController {
	@FXML private Text nameText;
	@FXML private Text emailText;
	@FXML private Text orderTimeText;
	@FXML private Text estPickupTimeText;
	
	@FXML private Text pizzaTypeText;
	@FXML private Text toppingsText;
	
	@FXML private Text orderStatusText;
	@FXML private Button submitButton;
	
	private String orderStatus;
	
	public ChefViewController() {
		// maybe have an orderStatus enum?
		// potentially pass orderStatus as an argument too
		orderStatus = "READY to COOK";
	}
	
	public void submit(ActionEvent event) throws IOException {
		if (orderStatus.toUpperCase().contains("READY TO COOK")) {
			orderStatus = "COOKING";
			orderStatusText.setText(orderStatus);
			submitButton.setText("Order is Ready");
		}
		else if (orderStatus.toUpperCase().contains("COOKING")) {
			orderStatus = "READY";
			orderStatusText.setText(orderStatus);
			// switch screens? close screen?
		}
	}
}