package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import dataclass.Member;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import utilities.Serializer;

public class DatabaseViewController {
  @FXML
  protected ListView membersListView;
  @FXML
  private Button viewButton;
  @FXML
  private Button editButton;
  @FXML
  private Button deleteButton;
  @FXML
  private Button backButton;

  private ArrayList<Member> memberArrayList = null;
  public static int indexOfChosenMember = -1;

  @FXML
  public void handleViewButtonClick(ActionEvent event) throws IOException {
    Member choosenMember = (Member) this.membersListView.getSelectionModel().getSelectedItem();

    if (choosenMember != null) {
      FXMLLoader loader = new FXMLLoader(getClass().getResource("DatabaseDetailsView.fxml"));
      Pane root = loader.load();
      DatabaseDetailsViewController databaseDetailsViewController = loader.getController();
      databaseDetailsViewController.transferMemberData(choosenMember);
      Scene databaseDetailsViewScene = new Scene(root);
      Stage currentStage = (Stage) this.viewButton.getScene().getWindow();
      currentStage.setScene(databaseDetailsViewScene);
      currentStage.setTitle("SBC GYM Members Management System | View Details Info Window");
      currentStage.show();
    }
  }

  @FXML
  public void handleEditButtonClick(ActionEvent event) throws IOException {
    this.indexOfChosenMember = this.membersListView.getSelectionModel().getSelectedIndex();
    if (this.indexOfChosenMember != -1) {
      FXMLLoader loader = new FXMLLoader(getClass().getResource("EditSelectedIndex.fxml"));
      Pane root = loader.load();
      Scene enrollMembersInfoWindowView = new Scene(root);
      Stage currentStage = (Stage) this.editButton.getScene().getWindow();
      currentStage.setScene(enrollMembersInfoWindowView);
      currentStage.setTitle("SBC GYM Members Management System | Enroll Members Info Window");
      currentStage.show();
    }
  }

  @FXML
  public void handleDeleteButtonClick(ActionEvent event) {
    this.indexOfChosenMember = this.membersListView.getSelectionModel().getSelectedIndex();
    this.memberArrayList = Serializer.deserialize(Serializer.databasePath);
    memberArrayList.remove(this.indexOfChosenMember);
    Serializer.serialize(Serializer.databasePath, this.memberArrayList);
    EnrollMembersInfoController.observableMemberList = FXCollections.observableArrayList(memberArrayList);
    this.membersListView.setItems(EnrollMembersInfoController.observableMemberList);
    this.membersListView.refresh();
  }

  @FXML
  public void handleBackButtonClick(ActionEvent event) throws IOException {
    FXMLLoader loader = new FXMLLoader(getClass().getResource("LoginUI.fxml"));
    Pane root = loader.load();
    Scene loginWindowView = new Scene(root);
    Stage currentStage = (Stage) this.backButton.getScene().getWindow();
    currentStage.setScene(loginWindowView);
    currentStage.setTitle("SBC GYM Members Management System | Login Window");
    currentStage.show();
  }

  @FXML
  public void initialize() {

    this.memberArrayList = Serializer.deserialize(Serializer.databasePath);

    if (this.memberArrayList == null) {
      this.memberArrayList = new ArrayList<>();
    }

    EnrollMembersInfoController.observableMemberList = FXCollections.observableArrayList(memberArrayList);
    this.membersListView.setItems(EnrollMembersInfoController.observableMemberList);
    this.membersListView.refresh();
  }
}
