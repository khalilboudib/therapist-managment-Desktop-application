package gui_tp.tp_poo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Pagination;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import orthophoniste.questionaire_enfant;
import orthophoniste.type_enfant;
import orthophoniste.*;

import java.io.IOException;
import java.time.LocalDate;

import static gui_tp.tp_poo.CreeRendez.Consultation;
import static gui_tp.tp_poo.HelloApplication.app;

public class Rendez_vous {
    Stage stage;
    Scene scene;

    public static orthophoniste.Rendez_vous selectedRendez;
    @FXML
    public TableColumn<orthophoniste.Rendez_vous, LocalDate> DateColm;

    @FXML
    public TableColumn<orthophoniste.Rendez_vous, ?> DetailColm;

    @FXML
    public TableColumn<orthophoniste.Rendez_vous, String> DureeColm;

    @FXML
    public TableColumn<orthophoniste.Rendez_vous, String> PatientColm;

    @FXML
    public TableColumn<orthophoniste.Rendez_vous, Boolean> PrensColm;

    @FXML
    public TableView<orthophoniste.Rendez_vous> RendezTable;

    @FXML
    public TableColumn<orthophoniste.Rendez_vous, ?> StatusColm;

    @FXML
    public TableColumn<orthophoniste.Rendez_vous, String> TimeColm;

    @FXML
    public TableColumn<orthophoniste.Rendez_vous, String> TypeColm;

    @FXML
    public Pagination pagination;


    @FXML
    void GoCreeRendez(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("CreeRendez.fxml"));
        stage =(Stage) ((Node)event.getSource()).getScene().getWindow();
        scene =new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void StartRendez(ActionEvent event) throws IOException {
        selectedRendez = RendezTable.getSelectionModel().getSelectedItem();
        app.rendezVous.remove(selectedRendez);
        if (selectedRendez instanceof consultation){
            Parent root = FXMLLoader.load(getClass().getResource("AddPatient.fxml"));
            stage =(Stage) ((Node)event.getSource()).getScene().getWindow();
            scene =new Scene(root);
            stage.setScene(scene);
            stage.show();
        }else{
            Parent root = FXMLLoader.load(getClass().getResource("StartRendez.fxml"));
            stage =(Stage) ((Node)event.getSource()).getScene().getWindow();
            scene =new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }

    @FXML
    void reload(ActionEvent event){
        ObservableList<orthophoniste.Rendez_vous> obs =RendezTable.getItems();
        obs.addAll(app.rendezVous);
        RendezTable.setItems(obs);
    }

    @FXML
    void initialize() {
        DateColm.setCellValueFactory(new PropertyValueFactory<orthophoniste.Rendez_vous,LocalDate>("date"));
        DureeColm.setCellValueFactory(new PropertyValueFactory<orthophoniste.Rendez_vous,String>("duree"));
        PatientColm.setCellValueFactory(new PropertyValueFactory<orthophoniste.Rendez_vous,String>("nom"));
        PrensColm.setCellValueFactory(new PropertyValueFactory<orthophoniste.Rendez_vous,Boolean>("presentiel"));
        TimeColm.setCellValueFactory(new PropertyValueFactory<orthophoniste.Rendez_vous,String>("heure"));
        TypeColm.setCellValueFactory(new PropertyValueFactory<orthophoniste.Rendez_vous,String>("type"));
        ObservableList<orthophoniste.Rendez_vous> obs = FXCollections.observableArrayList(app.rendezVous);
        RendezTable.setItems(obs);
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
