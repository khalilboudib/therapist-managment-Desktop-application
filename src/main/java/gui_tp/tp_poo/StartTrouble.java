package gui_tp.tp_poo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import orthophoniste.*;

import java.io.IOException;

import static gui_tp.tp_poo.AddPatient.patient;
import static gui_tp.tp_poo.HelloApplication.app;
import static gui_tp.tp_poo.Rendez_vous.selectedRendez;
import static gui_tp.tp_poo.StartRendez.selectedAnam;

public class StartTrouble {
    @FXML
    private TableColumn<trouble, type_categorie> CategColm= new TableColumn<>();

    @FXML
    private TableColumn<trouble, String > TroubleColm=new TableColumn<>();

    @FXML
    private TableView<trouble> TroubleTab= new TableView<>();

    @FXML
    private TextField NomTrouble;

    @FXML
    private ChoiceBox<type_categorie> TypeTrouble=new ChoiceBox<>();

    static String ProjetTherapeutique;

    static int num=20240000;

    @FXML
    void initialize(){
        TroubleColm.setCellValueFactory(new PropertyValueFactory<trouble, String >("nom"));
        CategColm.setCellValueFactory(new PropertyValueFactory<trouble, type_categorie>("categorie"));
        ObservableList<trouble> obs= FXCollections.observableArrayList(app.diagnostic.troubles);
        TroubleTab.setItems(obs);
        TypeTrouble.getItems().addAll(type_categorie.values());
    }

    @FXML
    private TextField ProjetThe;

    @FXML
    void next2(ActionEvent event) throws IOException {
        ProjetTherapeutique=ProjetThe.getText();
        if (selectedRendez instanceof seance_de_suivi){
            Parent root = FXMLLoader.load(getClass().getResource("SetNomFiche.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene =new Scene(root);
            stage.setScene(scene);
            stage.show();
        }else if (selectedRendez instanceof consultation){
            Dossier dossier =new Dossier();
            dossier.setNumero(num++);
            patient.NumDossier=num;
            dossier.addRendezvous(selectedRendez);
             BO bo =new premier_BO(app.epreuve,app.diagnostic,ProjetTherapeutique,selectedAnam);
            dossier.addBO(bo);
            patient.setDossier(dossier);
            Parent root = FXMLLoader.load(getClass().getResource("Home_Page.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene =new Scene(root);
            stage.setScene(scene);
            stage.show();
        }else if (selectedRendez instanceof atelier_de_groupe){
            for (Patient pat : ((atelier_de_groupe) selectedRendez).patients){
                pat.dossier.addRendezvous(selectedRendez);
                BO bo =new BO(app.epreuve,app.diagnostic,ProjetTherapeutique);
                pat.dossier.addBO(bo);
            }
        }
    }


    @FXML
    void AjouteTrouble(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("CreeTrouble.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene =new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void next(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("StartProjetTherapeutique.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene =new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void supprimer(ActionEvent event) {
        trouble troub=TroubleTab.getSelectionModel().getSelectedItem();
        int i =TroubleTab.getSelectionModel().getSelectedIndex();
        TroubleTab.getItems().remove(i);
        app.diagnostic.troubles.remove(troub);
    }

    @FXML
    void AddTrouble(ActionEvent event) throws IOException {
        trouble trb =new trouble(NomTrouble.getText(),TypeTrouble.getValue());
        app.diagnostic.addtrouble(trb);
        Parent root = FXMLLoader.load(getClass().getResource("StartTrouble.fxml"));
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
