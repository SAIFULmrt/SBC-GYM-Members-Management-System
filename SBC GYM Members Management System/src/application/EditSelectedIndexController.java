package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import dataclass.Member;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import utilities.DataValidator;
import utilities.Serializer;
import javafx.scene.control.CheckBox;

import javafx.scene.control.DatePicker;

import javafx.scene.control.ChoiceBox;

public class EditSelectedIndexController {
  @FXML
  private TextField membershipIdTextField;
  @FXML
  private DatePicker joiningDateField;
  @FXML
  private TextField firstNameTextField;
  @FXML
  private TextField lastNameTextField;
  @FXML
  private TextField nidNumberTextField;
  @FXML
  private Button choosePhotoButton;
  @FXML
  private ImageView choosenPhotoView;
  @FXML
  private TextField addressTextField;
  @FXML
  private TextField lifestyleTextField;
  @FXML
  private CheckBox genderMaleCheckBox;
  @FXML
  private CheckBox genderFemaleCheckBox;
  @FXML
  private DatePicker dateOfBirthField;
  @FXML
  private TextField heightTextField;
  @FXML
  private TextField weightTextField;
  @FXML
  private TextField phoneNumberTextField;
  @FXML
  private TextField emailTextField;
  @FXML
  private ChoiceBox<String> chooseMembershipPackageChoiceBox;
  @FXML
  private ChoiceBox<String> chooseClassScheduleChoiceBok;
  @FXML
  private Button saveButton;
  @FXML
  private Button clearButton;
  @FXML
  private Button backButton;

  ObservableList list = FXCollections.observableArrayList();
  ObservableList list1 = FXCollections.observableArrayList();
  private String choosenPhotoPath = null;
  private ArrayList<Member> memberArrayList = null;
  public static ObservableList<Member> observableMemberList = null;

  @FXML
  public void handleChoosePhotoButton(ActionEvent event) {
    FileChooser fileChooser = new FileChooser();
    Stage mainWindow = (Stage) this.choosePhotoButton.getScene().getWindow();
    File selectedPhoto = fileChooser.showOpenDialog(mainWindow);

    if (selectedPhoto != null) {
      this.choosenPhotoPath = "file://" + selectedPhoto.toURI().getPath();
      Image choosenPhoto = new Image(this.choosenPhotoPath);
      this.choosenPhotoView.setImage(choosenPhoto);
    }
  }

  @FXML
  public void handleSaveButtonClick(ActionEvent event) {
    String membershipIdString = this.membershipIdTextField.getText();
    LocalDate joiningDate = this.joiningDateField.getValue();
    String firstName = this.firstNameTextField.getText();
    String lastName = this.lastNameTextField.getText();
    String nidNumberString = this.nidNumberTextField.getText();
    String pathToPhoto = this.choosenPhotoPath;
    String addressString = this.addressTextField.getText();
    String lifeStyleString = this.lifestyleTextField.getText();
    String gender = handleGenderMaleCheckBox();
    LocalDate dateOfBirth = this.dateOfBirthField.getValue();
    String heightString = this.heightTextField.getText();
    String weightString = this.weightTextField.getText();
    String phoneNumberString = this.phoneNumberTextField.getText();
    String emailString = this.emailTextField.getText();
    String mPackage = chooseMembershipPackageChoiceBox.getValue();
    String classSchedule = chooseClassScheduleChoiceBok.getValue();

    try {
      boolean validation = DataValidator.isValidData(membershipIdString, joiningDate, firstName, lastName,
          nidNumberString, pathToPhoto, addressString, lifeStyleString, gender, dateOfBirth, heightString, weightString,
          phoneNumberString, emailString, mPackage, classSchedule);

      int membershipId = Integer.parseInt(membershipIdString);
      double height = Double.parseDouble(heightString);
      double weight = Double.parseDouble(weightString);

      Member member = new Member(membershipId, joiningDate, firstName, lastName, nidNumberString, pathToPhoto,
          addressString, lifeStyleString, gender, dateOfBirth, height, weight, phoneNumberString, emailString, mPackage,
          classSchedule);

      this.memberArrayList.set(DatabaseViewController.indexOfChosenMember, member);
      this.observableMemberList.set(DatabaseViewController.indexOfChosenMember, member);
      boolean isSerializationSuccessful = Serializer.serialize(Serializer.databasePath, this.memberArrayList);
      this.resetUI();
    } catch (Exception exception) {
      Stage parentStage = (Stage) this.saveButton.getScene().getWindow();
      ViewErrorWind.showErrorMessageDialogueBox(exception.getMessage(), parentStage);
    }

  }

  public void resetUI() {
    this.membershipIdTextField.setText("");
    this.joiningDateField.setValue(null);
    this.firstNameTextField.setText("");
    this.lastNameTextField.setText("");
    this.nidNumberTextField.setText("");
    this.choosenPhotoPath = null;
    this.choosenPhotoView.setImage(null);
    this.addressTextField.setText("");
    this.lifestyleTextField.setText("");
    this.dateOfBirthField.setValue(null);
    this.heightTextField.setText("");
    this.weightTextField.setText("");
    this.phoneNumberTextField.setText("");
    this.emailTextField.setText("");
  }

  @FXML
  public void handleClearButtonClick(ActionEvent event) {
    this.resetUI();
  }

  @FXML
  public void handleBackButtonClick(ActionEvent event) throws IOException {
    FXMLLoader loader = new FXMLLoader(getClass().getResource("DatabaseView.fxml"));
    Pane root = loader.load();
    Scene databaseView = new Scene(root);
    Stage currentStage = (Stage) this.backButton.getScene().getWindow();
    currentStage.setScene(databaseView);
    currentStage.setTitle(null);
    currentStage.show();
  }

  @FXML
  public String handleGenderMaleCheckBox() {
    if (genderMaleCheckBox.isSelected()) {
      genderFemaleCheckBox.setSelected(false);
      return "Male";
    }
    return "Female";
  }

  @FXML
  public void handleGenderFemaleCheckBox() {
    if (genderFemaleCheckBox.isSelected()) {
      genderMaleCheckBox.setSelected(false);
    }
  }

  private void loadData() {
    list.removeAll(list);
    list.addAll("Monthly", "Quarterly", "Half Yearly", "Yearly");
    chooseMembershipPackageChoiceBox.getItems().addAll(list);
    chooseMembershipPackageChoiceBox.setValue("Monthly");

    list1.removeAll(list);
    list1.addAll("Morning", "Afternoon", "Night");
    chooseClassScheduleChoiceBok.getItems().addAll(list1);
    chooseClassScheduleChoiceBok.setValue("Morning");

  }

  @FXML
  public void initialize() {

    loadData();

    this.memberArrayList = new ArrayList<>();
    this.memberArrayList = Serializer.deserialize(Serializer.databasePath);

    if (this.memberArrayList == null) {
      this.memberArrayList = new ArrayList<>();
    }

    Member choosenMember = this.memberArrayList.get(DatabaseViewController.indexOfChosenMember);

    this.membershipIdTextField.setText(String.valueOf(choosenMember.getMembershipId()));
    this.joiningDateField.setValue(choosenMember.getJoiningDate());
    this.firstNameTextField.setText(choosenMember.getFirstName());
    this.lastNameTextField.setText(choosenMember.getLastName());
    this.nidNumberTextField.setText(choosenMember.getNidNumber());
    this.choosenPhotoPath = choosenMember.getPathToPhoto();
    this.choosenPhotoView.setImage(new Image(this.choosenPhotoPath));
    this.addressTextField.setText(choosenMember.getAddress());
    this.lifestyleTextField.setText(choosenMember.getLifeStyle());
    this.genderMaleCheckBox.setSelected(choosenMember.getGender().equals("Male"));
    this.genderFemaleCheckBox.setSelected(choosenMember.getGender().equals("Female"));
    this.dateOfBirthField.setValue(choosenMember.getDateOfBirth());
    this.heightTextField.setText(String.valueOf(choosenMember.getHeight()));
    this.weightTextField.setText(String.valueOf(choosenMember.getWeight()));
    this.phoneNumberTextField.setText(choosenMember.getPhoneNumber());
    this.emailTextField.setText(choosenMember.getEmail());
    this.chooseMembershipPackageChoiceBox.setValue(choosenMember.getMembershipPackage());
    this.chooseClassScheduleChoiceBok.setValue(choosenMember.getClassSchedule());
    this.observableMemberList = FXCollections.observableArrayList(memberArrayList);

  }

}
