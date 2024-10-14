package gui_tp.tp_poo;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import orthophoniste.*;
import orthophoniste.Rendez_vous;

import java.io.IOException;
import java.time.LocalDate;

import static gui_tp.tp_poo.CreeRendez.atelierDeGroupe;
import static gui_tp.tp_poo.HelloApplication.app;

public class CreeAtelier {
    @FXML
    private TableColumn<Patient, Integer> NumDosColm=new TableColumn<>();

    @FXML
    private TableColumn<Patient, String> PatientColm=new TableColumn<>();

    @FXML
    private TableView<Patient> PatientTab=new TableView<>();

    @FXML
    private TextField ThematiqueField;

    @FXML
    void addPatient(ActionEvent event) {
        atelierDeGroupe.setThematique(ThematiqueField.getText());
        Patient patient=PatientTab.getSelectionModel().getSelectedItem();
        atelierDeGroupe.patients.add(patient);
        atelierDeGroupe.addNumDossier(patient.getDossier().getNumero());
        atelierDeGroupe.afficher();
        app.rendezVous.add(atelierDeGroupe);

    }

    @FXML
    void next(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Rendez_vous.fxml"));
        Stage stage =(Stage) ((Node)event.getSource()).getScene().getWindow();
        Scene scene =new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void intialize(){
        PatientColm.setCellValueFactory(new PropertyValueFactory<Patient, String>("nom"));
        //NumDosColm.setCellValueFactory(new PropertyValueFactory<Patient, Integer>("dossier.numero"));
        ObservableList<Patient> obs=PatientTab.getItems();
        obs.addAll((Patient) app.patients);
        PatientTab.setItems(obs);

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
