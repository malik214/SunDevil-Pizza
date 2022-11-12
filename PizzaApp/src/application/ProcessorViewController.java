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
	
	@FXML private Text nameText;
	@FXML private Text emailText;
	@FXML private Text orderTimeText;
	@FXML private Text estPickupTimeText;
	
	@FXML private Text pizzaTypeText;
	@FXML private Text toppingsText;
	
	@FXML private Text totalCostText;
	@FXML private Text paymentMethodText;

	@FXML private ToggleGroup processOrderToggleGroup;
	
	
	//This method gets called in the previous scene to pass you the order object
	public void setOrder(Order order) {
		currOrder = order;
	}
	
	
	
	
	public void submit(ActionEvent event) throws IOException {
		RadioButton selectedToggle = (RadioButton)processOrderToggleGroup.getSelectedToggle();
		if (selectedToggle != null) {
			boolean isApproved = (selectedToggle.getText().contains("Approve"));
			if (isApproved) {
				System.out.println("Approved");
				// send to chef
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