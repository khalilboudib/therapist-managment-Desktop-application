package gui_tp.tp_poo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import orthophoniste.Patient;
import orthophoniste.Rendez_vous;

import java.io.IOException;

import static gui_tp.tp_poo.CreeRendez.seanceDeSuivi;
import static gui_tp.tp_poo.HelloApplication.app;

public class CreeSeanceSuivi {
    @FXML
    private TextField NumDossier;

    @FXML
    private ToggleButton Presentiel;

    @FXML
    private TableColumn<Patient, Integer> NumDosColm=new TableColumn<>();

    @FXML
    private TableColumn<Patient, String> PatientColm=new TableColumn<>();

    @FXML
    private TableView<Patient> PatientTab=new TableView<>();

    @FXML
    void initialize(){
        NumDosColm.setCellValueFactory(new PropertyValueFactory<Patient,Integer>("NumDossier"));
        PatientColm.setCellValueFactory(new PropertyValueFactory<Patient,String>("nom"));
        ObservableList<Patient> obs = FXCollections.observableArrayList(app.patients);
        PatientTab.setItems(obs);
    }
    @FXML
    void next(ActionEvent event) throws IOException {
        Patient pat=PatientTab.getSelectionModel().getSelectedItem();
        seanceDeSuivi.addPatient(pat);
        seanceDeSuivi.setNum_dossier(pat.getNumDossier());
        seanceDeSuivi.setPresentiel(Presentiel.isSelected());
        app.rendezVous.add(seanceDeSuivi);

        Parent root = FXMLLoader.load(getClass().getResource("Rendez_vous.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
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
