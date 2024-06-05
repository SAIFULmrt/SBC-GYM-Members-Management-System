package application;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/*
 *  Name: Md. Saiful Islam
 *  ID: 1922071
 *  Course: CSE215L.16
 *  Instructor Name: Shaikh Shawon Arefin Shimon
 *  @date 19 Jan 2021
 */
public class ViewErrorWind {
  public static void showErrorMessageDialogueBox(String errorMessage, Stage parentStage) {

    try {
      FXMLLoader loader = new FXMLLoader(ViewErrorWind.class.getResource("ErrorView.fxml"));
      Pane errorView = (Pane) loader.load();

      ErrorViewController errorViewController = loader.getController();
      errorViewController.setErrorMessageLabel(errorMessage);

      Stage errorStage = new Stage();
      Scene errorScene = new Scene(errorView);
      errorStage.setScene(errorScene);
      errorStage.initOwner(parentStage);
      errorStage.initModality(Modality.APPLICATION_MODAL);
      errorStage.setTitle("Error");
      errorStage.showAndWait();
    } catch (IOException exception) {
      System.out.println("Could not load the ErrorView.fxml file");
    }
  }
}