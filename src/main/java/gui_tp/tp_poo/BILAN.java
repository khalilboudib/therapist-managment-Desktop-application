package gui_tp.tp_poo;

import javafx.collections.FXCollections;
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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import orthophoniste.*;

import java.io.IOException;

import static gui_tp.tp_poo.HelloApplication.app;
import static gui_tp.tp_poo.detailpatient.bo;
import static gui_tp.tp_poo.patientpage.patient;

public class BILAN {
    @FXML
    private Label NomAnam=new Label();

    @FXML
    private TableColumn<trouble, String> NomTrouble=new TableColumn<>();

    @FXML
    private Label ProjetLabel=new Label();

    @FXML
    private TableView<trouble> TroubleTab=new TableView<>();

    @FXML
    private TableColumn<trouble, type_categorie> TypeTrouble=new TableColumn<>();

    @FXML
    void initialize(){
        NomTrouble.setCellValueFactory(new PropertyValueFactory<trouble,String>("nom"));
        TypeTrouble.setCellValueFactory(new PropertyValueFactory<trouble,type_categorie>("categorie"));
    }

    @FXML
    void Gotest(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("ConsultTest.fxml"));
        Stage stage =(Stage) ((Node)event.getSource()).getScene().getWindow();
        Scene scene =new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void LoadBilan(ActionEvent event) {
        ObservableList<trouble> obs = FXCollections.observableArrayList(bo.diagnostic.troubles);
        TroubleTab.setItems(obs);
        ProjetLabel.setText(bo.projet_the);
        NomAnam.setText(((premier_BO)bo).amne.getNom());
    }

    @FXML
    void goAnam(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("ConsultAnam.fxml"));
        Stage stage =(Stage) ((Node)event.getSource()).getScene().getWindow();
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
