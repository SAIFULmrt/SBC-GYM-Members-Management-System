package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import java.io.IOException;
import java.time.LocalDate;
import dataclass.Member;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class DatabaseDetailsViewController {
  @FXML
  private ImageView photoView;
  @FXML
  private Label membershipIdLabel;
  @FXML
  private Label fullNameLabel;
  @FXML
  private Label nidNumberLabel;
  @FXML
  private Label addressLabel;
  @FXML
  private Label lifestyleLabel;
  @FXML
  private Label genderLabel;
  @FXML
  private Label dateOfBirthLabel;
  @FXML
  private Label heightLabel;
  @FXML
  private Label weightLabel;
  @FXML
  private Label phoneNumberLabel;
  @FXML
  private Label emailLabel;
  @FXML
  private Label joiningDateLabel;
  @FXML
  private Label membershipPackageLabel;
  @FXML
  private Label classScheduleLabel;
  @FXML
  private Button backButton;
  @FXML
  private Button homeButton;

  @FXML
  public void handleBackButtonClick(ActionEvent event) throws IOException {
    FXMLLoader loader = new FXMLLoader(getClass().getResource("DatabaseView.fxml"));
    Pane root = loader.load();
    Scene databaseView = new Scene(root);
    Stage currentStage = (Stage) this.backButton.getScene().getWindow();
    currentStage.setScene(databaseView);
    currentStage.setTitle("SBC GYM Members Management System | Database Window");
    currentStage.show();

  }

  @FXML
  public void handleHomeButtonClick(ActionEvent event) throws IOException {
    FXMLLoader loader = new FXMLLoader(getClass().getResource("ChooseLoginMethod.fxml"));
    Pane root = loader.load();
    Scene homeScene = new Scene(root);
    Stage currentStage = (Stage) this.homeButton.getScene().getWindow();
    currentStage.setScene(homeScene);
    currentStage.setTitle("SBC GYM Members Management System | Home Window");
    currentStage.show();
  }

  public void transferMemberData(Member member) {

    int membershipId = member.getMembershipId();
    String fullName = member.getFirstName() + " " + member.getLastName();
    String nidNumber = member.getNidNumber();
    String address = member.getAddress();
    String lifestyle = member.getLifeStyle();
    String gender = member.getGender();
    LocalDate dateOfBirth = member.getDateOfBirth();
    double height = member.getHeight();
    double weight = member.getWeight();
    String phoneNumber = member.getPhoneNumber();
    String email = member.getEmail();
    String pathToPhoto = member.getPathToPhoto();
    LocalDate joiningDate = member.getJoiningDate();
    String membershipPackage = member.getMembershipPackage();
    String classSchedule = member.getClassSchedule();

    this.membershipIdLabel.setText(String.valueOf(membershipId));
    this.fullNameLabel.setText(fullName);
    this.nidNumberLabel.setText(nidNumber);
    this.addressLabel.setText(address);
    this.lifestyleLabel.setText(lifestyle);
    this.genderLabel.setText(gender);
    this.dateOfBirthLabel.setText(dateOfBirth.toString());
    this.heightLabel.setText(String.valueOf(height) + "cm");
    this.weightLabel.setText(String.valueOf(weight) + "kg");
    this.phoneNumberLabel.setText(phoneNumber);
    this.emailLabel.setText(email);

    this.photoView.setImage(new Image(pathToPhoto));
    this.joiningDateLabel.setText(joiningDate.toString());
    this.membershipPackageLabel.setText(membershipPackage);
    this.classScheduleLabel.setText(classSchedule);
  }
}
