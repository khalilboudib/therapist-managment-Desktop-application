package gui_tp.tp_poo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import orthophoniste.Rendez_vous;
import orthophoniste.type_enfant;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;

import static gui_tp.tp_poo.HelloApplication.app;
import orthophoniste.*;

public class CreeRendez {

    Stage stage;
    Scene scene;
    Parent root;
    public static consultation Consultation;
    public static seance_de_suivi seanceDeSuivi;
    public static atelier_de_groupe atelierDeGroupe;

    @FXML
    private DatePicker DateRendez;

    @FXML
    private TextField DureeRendez;

    @FXML
    private TextField HeureRendez;

    @FXML
    private ChoiceBox<String> TypeRendez;

    @FXML
    void next(ActionEvent event) throws IOException {
        String heure=HeureRendez.getText();
        String duree=DureeRendez.getText();
        String type=TypeRendez.getValue();
        LocalDate date =DateRendez.getValue();
        Consultation=new consultation();
        if (type.compareTo("consultation")==0){
            Parent root = FXMLLoader.load(getClass().getResource("CreeConsultation.fxml"));
            stage =(Stage) ((Node)event.getSource()).getScene().getWindow();
            scene =new Scene(root);
            stage.setScene(scene);
            stage.show();
            Consultation.setDate(date);
            Consultation.setDuree(duree);
            Consultation.setHeure(heure);
        } else if (type.compareTo("seance de suivi")==0) {
            Parent root = FXMLLoader.load(getClass().getResource("CreeSeanceSuivi.fxml"));
            stage =(Stage) ((Node)event.getSource()).getScene().getWindow();
            scene =new Scene(root);
            stage.setScene(scene);
            stage.show();
            seanceDeSuivi =new seance_de_suivi();
            seanceDeSuivi.setDate(date);
            seanceDeSuivi.setDuree(duree);
            seanceDeSuivi.setHeure(heure);
        }else if (type.compareTo("atelier de groupe")==0){
            Parent root = FXMLLoader.load(getClass().getResource("CreeAtelier.fxml"));
            stage =(Stage) ((Node)event.getSource()).getScene().getWindow();
            scene =new Scene(root);
            stage.setScene(scene);
            stage.show();
            atelierDeGroupe =new atelier_de_groupe();
            atelierDeGroupe.setDate(date);
            atelierDeGroupe.setDuree(duree);
            atelierDeGroupe.setHeure(heure);
        }

    }
    @FXML
    void initialize(){
        TypeRendez.getItems().addAll("consultation","seance de suivi","atelier de groupe");
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
