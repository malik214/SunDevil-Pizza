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
	@FXML
	private Text orderStatusText;
	@FXML
	private Text pickupTimeText;

	private Order myOrder;

	public void setOrder(Order order) {
		myOrder = order;
	}

	public void setStatus() {
		orderStatusText.setText(myOrder.getStatus());
	}

	public void setThankYouMessage() {
		thankYouMessageText
				.setText(myOrder.getCustomer().getName() + ", thank you for your order with SunDevil Pizza!");
	}

	public void setEmailMessage() {
		emailText.setText(myOrder.getCustomer().getAsuriteID() + "@asu.edu");
	}

	public void displayPickupTime() {
		pickupTimeText.setText(myOrder.getDate().getMonthValue() + "/" + myOrder.getDate().getDayOfMonth() + "/"
				+ myOrder.getDate().getYear() + ", " + myOrder.getTime());
	}

	public void switchToProcessorView(ActionEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("ProcessorViewUI.fxml"));
		Parent root = loader.load();

		ProcessorViewController pvc = loader.getController();
		pvc.setOrder(myOrder);
		pvc.displayCustomerInfo();
		pvc.displayOrderTimeText();
		pvc.displayOrderPickupInfo();
		pvc.displayPizzaInfo();
		pvc.displayPaymentInfo();

		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

}
