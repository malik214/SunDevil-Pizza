package application;

import java.io.IOException;

import java.time.LocalTime;
import java.time.LocalDate;

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
	
	private LocalTime time;
	private LocalDate date;
	
	private String orderStatus;
	private Order myOrder;
	
	public ChefViewController() {
		// maybe have an orderStatus enum?
		// potentially pass orderStatus as an argument too
		orderStatus = "READY to COOK";
	}
	
	public void setOrder(Order order) {
		myOrder = order;
	}
	
	public void setNameText() {
		nameText.setText(myOrder.getCustomer().getName());
	}
	
	public void setEmailText() {
		emailText.setText(myOrder.getCustomer().getAsuriteID() + "@asu.edu");
	}
	
	public void displayOrderTimeText() {
		time = LocalTime.now();
		date = LocalDate.now();
		String month = "";
		String day;
		String minutes;
		
		String suffix = "AM";
		int hour = time.getHour();
		
		if (hour > 12) {
			hour -=12;
			suffix = "PM";
		}
		
		if (hour == 12) {
			suffix = "PM";
		}
	
		switch (date.getMonthValue()) {
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
		day = String.valueOf(date.getDayOfMonth());
		
		if(time.getMinute() < 10)
			minutes = "0" + String.valueOf(time.getMinute());
		else
			minutes = String.valueOf(time.getMinute());
			
		orderTimeText.setText(month + " " + day + ", " + String.valueOf(hour) + ":" + minutes + " " + suffix); //maybe add date
	}
	
	public void displayEstPickupTimeText() {
		estPickupTimeText.setText(myOrder.getDate().getMonthValue() + "/" + myOrder.getDate().getDayOfMonth() + "/"
				+ myOrder.getDate().getYear() + ", " + myOrder.getTime());
	}
	
	public void displayPizzaInfo() {
		pizzaTypeText.setText(myOrder.getPizza().getPizzaType());
		toppingsText.setText(String.join(", ", myOrder.getPizza().getToppings()));		
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
