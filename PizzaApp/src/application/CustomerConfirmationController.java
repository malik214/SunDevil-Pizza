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
	@FXML private Text thankYouMessageText;
	@FXML private Text emailText;
	@FXML private Text orderStatusText;
	@FXML private Text estPickupTimeText;
}
