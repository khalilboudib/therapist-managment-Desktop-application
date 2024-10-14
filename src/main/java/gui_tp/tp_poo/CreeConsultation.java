package gui_tp.tp_poo;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;

import static gui_tp.tp_poo.CreeRendez.Consultation;
import static gui_tp.tp_poo.CreeRendez.*;
import static gui_tp.tp_poo.HelloApplication.app;

import javafx.stage.Stage;
import orthophoniste.*;
import orthophoniste.Rendez_vous;

import java.io.IOException;


public class CreeConsultation {
    Stage stage;
    Scene scene;
    @FXML
    private TextField Age;

    @FXML
    private TextField Nom;

    @FXML
    private TextField Prenom;

    @FXML
    void next(ActionEvent event) throws IOException {
        String nom=Nom.getText();
        String prenom=Prenom.getText();
        String age=Age.getText();
        Consultation.setNom(nom);
        Consultation.setPrenom(prenom);
        Consultation.setAge(Integer.parseInt(age));
        app.rendezVous.add(Consultation);
        for (Rendez_vous rend :app.rendezVous){
            rend.afficher();
        }
        Parent root = FXMLLoader.load(getClass().getResource("Rendez_vous.fxml"));
        stage =(Stage) ((Node)event.getSource()).getScene().getWindow();
        scene =new Scene(root);
        stage.setScene(scene);
        stage.show();
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
