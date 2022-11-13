package application;

import java.io.IOException;

import java.time.LocalTime;
import java.time.LocalDate;

import javafx.application.Application;
import javafx.application.Platform;
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
	
	//initialize ChefViewController
	public ChefViewController() {
		orderStatus = "READY to COOK";
	}
	
	//get order and set it
	public void setOrder(Order order) {
		myOrder = order;
	}
	
	//get name from order and set
	public void setNameText() {
		nameText.setText(myOrder.getCustomer().getName());
	}
	
	//get email from order and set
	public void setEmailText() {
		emailText.setText(myOrder.getCustomer().getAsuriteID() + "@asu.edu");
	}
	
	//find time of order and display
	public void displayOrderTimeText() {
		time = LocalTime.now();
		date = LocalDate.now();
		
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
	
		
		if(time.getMinute() < 10)
			minutes = "0" + String.valueOf(time.getMinute());
		else
			minutes = String.valueOf(time.getMinute());
			
		orderTimeText.setText(date.getMonthValue() + "/" + date.getDayOfMonth() + "/" + date.getYear() + ", " + String.valueOf(hour) + ":" + minutes + " " + suffix); //maybe add date
	}

	//get date and time of pickup time and display
	public void displayEstPickupTimeText() {
		estPickupTimeText.setText(myOrder.getDate().getMonthValue() + "/" + myOrder.getDate().getDayOfMonth() + "/"
				+ myOrder.getDate().getYear() + ", " + myOrder.getTime());
	}
	
	//get information of pizza from order and display
	public void displayPizzaInfo() {
		pizzaTypeText.setText(myOrder.getPizza().getPizzaType());
		toppingsText.setText(String.join(", ", myOrder.getPizza().getToppings()));		
	}
	
	//button updates order status
	public void submit(ActionEvent event) throws IOException {
		if (orderStatus.toUpperCase().contains("READY TO COOK")) {
			orderStatus = "COOKING";
			orderStatusText.setText(orderStatus);
			submitButton.setText("Order is Ready");
		}
		else if (orderStatus.toUpperCase().contains("COOKING")) {
			orderStatus = "READY";
			orderStatusText.setText(orderStatus);
			submitButton.setText("Exit");
		}
		else if (orderStatus.toUpperCase().contains("READY")) {
			Platform.exit(); //Exit application
		}
	}
}
