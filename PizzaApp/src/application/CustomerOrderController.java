package application;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

public class CustomerOrderController {
	ObservableList<String> timeSelect = FXCollections.observableArrayList("ASAP (20 minutes)");

	private Pizza myPizza = new Pizza();
	private LocalDate pickupDate;
	private String pickupTime;
	private LocalDate today;
	private LocalTime time;

	@FXML
	ChoiceBox times;

	@FXML
	private ToggleGroup pizzaTypeToggleGroup;

	@FXML
	public void initialize() {
		today = LocalDate.now();
		time = LocalTime.now();

		for (int i = 1; i+time.getHour() <= 20; i++) {
			String suffix = "AM";
			int hour = time.getHour() + 1;
			
			if (hour > 12) {
				hour-=12;
				suffix = "PM";
			}
			
			
			
			timeSelect.add(String.valueOf((time.getHour() + i) - 12) + ":00 " + suffix);
			timeSelect.add(String.valueOf((time.getHour() + i) - 12) + ":30 " + suffix);
		}

		times.setItems(timeSelect);
		
		

	}

	public void changePizzaType(ActionEvent event) throws IOException {
		String pizzaType = ((RadioButton) event.getSource()).getText();
		myPizza.setPizzaType(pizzaType);
		System.out.println(myPizza.getPizzaType());
	}

	public void changeToppings(ActionEvent event) throws IOException {
		CheckBox source = (CheckBox) event.getSource();
		String topping = source.getText();
		boolean isSelected = source.isSelected();
		if (isSelected) {
			myPizza.addTopping(topping);
		} else {
			myPizza.removeTopping(topping);
		}
		System.out.println(myPizza.getToppings());
	}

	public void setPickupDate(ActionEvent event) throws IOException {
		// Input needs verification

		pickupDate = ((DatePicker) event.getSource()).getValue();
		System.out.println(pickupDate.getMonthValue() + " " + pickupDate.getDayOfMonth());

	}

	public void setPickupTime() throws IOException {
		
		pickupTime = (String) times.getValue();
		

	}

	public void checkoutPizza(ActionEvent event) throws IOException {

		if (pizzaTypeToggleGroup.getSelectedToggle() != null
				&& (pickupDate.isAfter(today) || pickupDate.isEqual(today))) {
			System.out.println("Checkout");

			FXMLLoader loader = new FXMLLoader(getClass().getResource("CustomerPaymentUI.fxml"));
			Parent root = loader.load();

			CustomerPaymentController paymentController = loader.getController();
			setPickupTime();
			paymentController.setPizza(myPizza);
			paymentController.displayPickupTime(pickupDate, pickupTime);

			Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
		} else {
			System.out.println("No pizza type selected");
		}
	}

}