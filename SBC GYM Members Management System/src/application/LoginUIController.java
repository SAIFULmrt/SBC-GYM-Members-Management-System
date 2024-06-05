package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;

public class LoginUIController {
  @FXML
  private TextField usernameTextField;
  @FXML
  private TextField passwordTextField;
  @FXML
  private Button loginButton;
  @FXML
  private Button backButton;
  @FXML
  private Label errorLabel;

  @FXML
  public void handleLoginButtonClick(ActionEvent event) throws IOException {
    String username = this.usernameTextField.getText();
    String password = this.passwordTextField.getText();

    if (username.equals("admin") && password.equals("admin")) {
      FXMLLoader loader = new FXMLLoader(getClass().getResource("DatabaseView.fxml"));
      Pane root = loader.load();
      Scene databaseView = new Scene(root);
      Stage currentStage = (Stage) this.loginButton.getScene().getWindow();
      currentStage.setScene(databaseView);
      currentStage.setTitle("SBC GYM Members Management System | Members List Window");
      currentStage.show();
    } else {
      this.errorLabel.setText("Wrong Username or Password. Please try again.");
    }
  }

  public void handleBackButtonClick(ActionEvent event) throws IOException {
    FXMLLoader loader = new FXMLLoader(getClass().getResource("ChooseLoginMethod.fxml"));
    Pane root = loader.load();
    Scene baseWindowView = new Scene(root);
    Stage currentStage = (Stage) this.backButton.getScene().getWindow();
    currentStage.setScene(baseWindowView);
    currentStage.setTitle("SBC GYM Members Management System | Home Window");
    currentStage.show();
  }
}
