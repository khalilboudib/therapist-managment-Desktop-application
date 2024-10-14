package gui_tp.tp_poo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.stage.Stage;
import orthophoniste.*;

import java.io.IOException;

public class CreeTest {

    public static serie_exercises serieExercises;
    public static simple_questionaire simpleQuestionaire;

    @FXML
    private TextField CapaciteTest;

    @FXML
    private TextField NomTest;

    @FXML
    private ToggleButton questionaire;

    @FXML
    private ToggleButton serie_exo;
    @FXML
    private Label error_msg;


    @FXML
    void next(ActionEvent event) throws IOException {
        String nom=NomTest.getText();
        int cap=Integer.parseInt(CapaciteTest.getText());
        if (serie_exo.isSelected() && questionaire.isSelected()){
            error_msg.setText("choose only one type");
        } else if (serie_exo.isSelected()) {
            serieExercises = new serie_exercises();
            serieExercises.setNom(nom);
            serieExercises.setCapacite(cap);
            Parent root = FXMLLoader.load(getClass().getResource("CreeSerieExo.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } else if (questionaire.isSelected()) {
            simpleQuestionaire= new simple_questionaire();
            simpleQuestionaire.setNom(nom);
            simpleQuestionaire.setCapacite(cap);
            Parent root = FXMLLoader.load(getClass().getResource("CreeQuestionaire.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }else {
            error_msg.setText("choose one type");
        }
    }


    @FXML
    void GoAnamnese(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Anamnese.fxml"));
        Stage stage =(Stage) ((Node)event.getSource()).getScene().getWindow();
        Scene scene =new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void GoHome(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Home_Page.fxml"));
        Stage stage =(Stage) ((Node)event.getSource()).getScene().getWindow();
        Scene scene =new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void GoPatient(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("PatientTab.fxml"));
        Stage stage =(Stage) ((Node)event.getSource()).getScene().getWindow();
        Scene scene =new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void GoRendezVous(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Rendez_vous.fxml"));
        Stage stage =(Stage) ((Node)event.getSource()).getScene().getWindow();
        Scene scene =new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void GoTest(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("TabTest.fxml"));
        Stage stage =(Stage) ((Node)event.getSource()).getScene().getWindow();
        Scene scene =new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void LogOut(ActionEvent event) throws IOException {
        Parent root =FXMLLoader.load(getClass().getResource("Login.fxml"));
        Stage stage =(Stage) ((Node)event.getSource()).getScene().getWindow();
        Scene scene =new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
