package application;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;

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
	@FXML
	private Text pizzaTypeText;
	@FXML
	private Text toppingsText;

	@FXML
	private TextField nameTextField;
	@FXML
	private TextField asuriteIdTextField;
	@FXML
	private TextField passwordTextField;

	@FXML
	private Text estPickupTimeText;
	@FXML
	private Text totalCostText;

	private Pizza myPizza;
	private Customer myCustomer;
	private Order myOrder;

	@FXML
	public void initialize() {
		myCustomer = new Customer();
		myOrder = new Order();
	}

	public void setPizza(Pizza pizza) {
		myPizza = pizza;
		myOrder.setPizza(myPizza);
		this.displayPizza();
	}

	private void displayPizza() {
		pizzaTypeText.setText(myPizza.getPizzaType());
		toppingsText.setText(String.join(", ", myPizza.getToppings()));

		myPizza.setPrice();
		totalCostText.setText(myPizza.getPrice());
	}

	public void displayPickupTime(LocalDate pickupDate, String pickupTime) {
		String month = "";
		String day;
		LocalDate today = LocalDate.now();
		LocalTime currTime = LocalTime.now();

		if (pickupTime.charAt(0) == ('A')) {
			int hour = currTime.getHour();
			String suffix = "AM";

			if (hour > 12) {
				hour -= 12;
				suffix = "PM";
			}

			String pickupHour = String.valueOf(hour);
			String pickupMin = String.valueOf(currTime.plusMinutes(20).getMinute());
			

			pickupTime = (pickupHour + ":" + pickupMin + " " + suffix);
		}

		switch (pickupDate.getMonthValue()) {
		case 1:
			month = "Jan";
			break;

		case 2:
			month = "Feb";
			break;

		case 3:
			month = "Mar";
			break;

		case 4:
			month = "Apr";
			break;

		case 5:
			month = "May.";
			break;

		case 6:
			month = "June";
			break;

		case 7:
			month = "July";
			break;

		case 8:
			month = "Aug";
			break;

		case 9:
			month = "Sept";
			break;

		case 10:
			month = "Oct";
			break;

		case 11:
			month = "Nov";
			break;

		case 12:
			month = "Dec";
			break;
		}

		day = String.valueOf(pickupDate.getDayOfMonth());

		myOrder.setDate(pickupDate);
		myOrder.setTime(pickupTime);

		if (today.isEqual(pickupDate)) {
			estPickupTimeText.setText("Today, " + pickupTime);
		}

		else {
			estPickupTimeText.setText(month + " " + day + ", " + pickupTime);

		}
	}

	public void setCustomerName(KeyEvent event) throws IOException {
		myCustomer.setName(((TextField) event.getSource()).getText());
		System.out.println(myCustomer.getName());
	}

	public void setCustomerASUID(KeyEvent event) throws IOException {
		myCustomer.setAsuriteID(((TextField) event.getSource()).getText());
		System.out.println(myCustomer.getAsuriteID());
	}

	public void setCustomerPassword(KeyEvent event) throws IOException {
		myCustomer.setPassword(((TextField) event.getSource()).getText());
		System.out.println(myCustomer.getPassword());
	}

	public void placeOrder(ActionEvent event) throws IOException {
		if (nameTextField.getText().length() > 0 && asuriteIdTextField.getText().length() > 0
				&& passwordTextField.getText().length() > 0) {
			System.out.println("Place order");

			FXMLLoader loader = new FXMLLoader(getClass().getResource("CustomerConfirmationUI.fxml"));
			Parent root = loader.load();

			myOrder.setCustomer(myCustomer);
			myOrder.setStatus("Order Received");
			CustomerConfirmationController confirmationController = loader.getController();
			confirmationController.setOrder(myOrder);
			confirmationController.setThankYouMessage();
			confirmationController.setEmailMessage();
			confirmationController.displayPickupTime();
			confirmationController.setStatus();

			Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
		} else {
			System.out.println("Missing name, username, or password!");
		}
	}
}