package gui_tp.tp_poo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.stage.Stage;
import orthophoniste.*;

import java.io.IOException;

import static gui_tp.tp_poo.HelloApplication.app;

public class AddPatient {
    static Patient patient;
    static int i =0;
    @FXML
    private TextField addresse;

    @FXML
    private ToggleButton adulte;

    @FXML
    private TextField dateNaiss;

    @FXML
    private ToggleButton enfant;

    @FXML
    private TextField lieuNaiss;

    @FXML
    private TextField nom;

    @FXML
    private TextField prenom;

    @FXML
    private TextField NumTel;

    @FXML
    private TextField classEtude;

    @FXML
    private TextField Diplome;

    @FXML
    private TextField NumTelAdulte;

    @FXML
    private TextField Proffession;

    @FXML
    void next(ActionEvent event) throws IOException {

        if (adulte.isSelected()){
            patient=new Patient_adulte();
            patient.setNom(nom.getText());
            patient.setPrenom(prenom.getText());
            patient.setAdresse(addresse.getText());
            patient.setDate_de_naissance(dateNaiss.getText());
            patient.setLien_de_naissance(lieuNaiss.getText());
            Parent root = FXMLLoader.load(getClass().getResource("AddPatientAdulte.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene =new Scene(root);
            stage.setScene(scene);
            stage.show();
        }else if (enfant.isSelected()){
            patient=new Patient_enfant();
            patient.setNom(nom.getText());
            patient.setPrenom(prenom.getText());
            patient.setAdresse(addresse.getText());
            patient.setDate_de_naissance(dateNaiss.getText());
            patient.setLien_de_naissance(lieuNaiss.getText());
            Parent root = FXMLLoader.load(getClass().getResource("AddPatientEnfant.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene =new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }

    @FXML
    void AddPat(ActionEvent event) throws IOException {
            ((Patient_enfant) patient).setClasse_etude(classEtude.getText());
            ((Patient_enfant) patient).setTelephone_parent(Integer.parseInt(NumTel.getText()));
            app.patients.add(patient);
            patient.afficher();
        Parent root = FXMLLoader.load(getClass().getResource("StartRendez.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene =new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void AddAdulte(ActionEvent event) throws IOException {
        ((Patient_adulte)patient).setDiplome(Diplome.getText());
        ((Patient_adulte) patient).setProffession(Proffession.getText());
        ((Patient_adulte) patient).setTelephone(Integer.parseInt(NumTelAdulte.getText()));
        app.patients.add(patient);
        patient.afficher();
        Parent root = FXMLLoader.load(getClass().getResource("StartRendez.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene =new Scene(root);
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
