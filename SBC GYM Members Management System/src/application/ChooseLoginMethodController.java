package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import java.io.File;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class ChooseLoginMethodController {
  @FXML
  private ImageView logoImageView;
  @FXML
  private Button databaseViewButton;
  @FXML
  private Button enrollMembersInfoButton;

  @FXML
  public void handleDatabaseViewButtonClick(ActionEvent event) throws IOException {

    FXMLLoader loader = new FXMLLoader(getClass().getResource("LoginUI.fxml"));
    Pane root = loader.load();
    Scene loginScene = new Scene(root);
    Stage currentStage = (Stage) this.databaseViewButton.getScene().getWindow();
    currentStage.setScene(loginScene);
    currentStage.setTitle("SBC GYM Members Management System | Admin Login Window ");
    currentStage.show();

  }

  @FXML
  public void handleEnrollMembersInfoButtonClick(ActionEvent event) throws IOException {
    FXMLLoader loader = new FXMLLoader(getClass().getResource("EnrollMembersInfo.fxml"));
    Pane root = loader.load();

    Scene enrollMembersInfoWindowScene = new Scene(root);
    Stage currentStage = (Stage) this.enrollMembersInfoButton.getScene().getWindow();
    currentStage.setScene(enrollMembersInfoWindowScene);
    currentStage.setTitle("SBC GYM Members Management System | Enroll Members Info Window ");
    currentStage.show();

  }

  public void initialize() {
    File file = new File(
        "C:/Users/SAIFULmrt/eclipse-workspace/SBC GYM Members Management System/src/images/SBC_Logo.jpg");
    Image image = new Image(file.toURI().toString());

    logoImageView.setImage(image);
  }
}
