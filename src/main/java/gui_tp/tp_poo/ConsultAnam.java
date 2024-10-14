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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import orthophoniste.*;

import java.io.IOException;

import static gui_tp.tp_poo.detailpatient.bo;
import static gui_tp.tp_poo.patientpage.patient;

public class ConsultAnam {
    @FXML
    private TableView<questionaire> AnamTab=new TableView<>();

    @FXML
    private TableColumn<questionaire, String > QueColm=new TableColumn<>();

    @FXML
    private TableColumn<questionaire, String> ReponseColm=new TableColumn<>();

    @FXML
    void goback(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("BILAN.fxml"));
        Stage stage =(Stage) ((Node)event.getSource()).getScene().getWindow();
        Scene scene =new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void initialize(){
        QueColm.setCellValueFactory(new PropertyValueFactory<questionaire,String>("enonce"));
        ReponseColm.setCellValueFactory(new PropertyValueFactory<questionaire,String>("reponse"));
        if (((premier_BO)bo).amne instanceof amnese_enfant){
            ObservableList<questionaire> obse= FXCollections.observableArrayList(((amnese_enfant) ((premier_BO)bo).amne).questionaires);
            AnamTab.setItems(obse);
        } else if (((premier_BO)bo).amne instanceof amnese_adulte) {
            ObservableList<questionaire> obse= FXCollections.observableArrayList(((amnese_adulte) ((premier_BO)bo).amne).questionaires);
            AnamTab.setItems(obse);
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
