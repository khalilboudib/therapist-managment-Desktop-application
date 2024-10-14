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
import static gui_tp.tp_poo.StartTrouble.ProjetTherapeutique;

public class StartFiche {

    static fiche_de_suivi fiche;
    static int num =1000000;

    @FXML
    private TextField NomFiche;

    @FXML
    private TableColumn<objectif, Float > NoteColm= new TableColumn<>();

    @FXML
    private TableColumn<objectif, String> ObjectifColm= new TableColumn<>();

    @FXML
    private TableView<objectif> ObjectifTab= new TableView<>();

    @FXML
    private TableColumn<objectif, type_objectif> TypeColm=new TableColumn<>();

    @FXML
    private TextField NomObjectif;

    @FXML
    private TextField NoteObjec;

    @FXML
    private ChoiceBox<type_objectif> TypeObjec= new ChoiceBox<>();

    @FXML
    void initialize(){
        if (fiche==null){
            fiche =new fiche_de_suivi();
        }
        TypeObjec.getItems().addAll(type_objectif.values());
        ObjectifColm.setCellValueFactory(new PropertyValueFactory<objectif, String >("nom"));
        TypeColm.setCellValueFactory(new PropertyValueFactory<objectif, type_objectif >("type"));
        NoteColm.setCellValueFactory(new PropertyValueFactory<objectif, Float >("note"));
        ObservableList<objectif> obs = FXCollections.observableArrayList(fiche.objectifs);
        ObjectifTab.setItems(obs);
    }

    @FXML
    void AddObjectif(ActionEvent event) throws IOException {
        objectif obj = new objectif(NomObjectif.getText(),TypeObjec.getValue());
        obj.setNote(Float.parseFloat(NoteObjec.getText()));
        fiche.objectifs.add(obj);
        Parent root = FXMLLoader.load(getClass().getResource("CreeFiche.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene =new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void AjouteObjectif(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("CreeObjectif.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene =new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void next2(ActionEvent event) throws IOException {
        Patient pat=selectedRendez.patient;
        pat.dossier.addRendezvous(selectedRendez);
        BO bo =new BO(app.epreuve,app.diagnostic,ProjetTherapeutique);
        pat.dossier.addBO(bo);
        pat.dossier.addFichesuivi(fiche);
        Parent root = FXMLLoader.load(getClass().getResource("Home_Page.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene =new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void supprimer(ActionEvent event) {

    }

    @FXML
    void next(ActionEvent event) throws IOException {
        fiche=new fiche_de_suivi();
        fiche.setNom(NomFiche.getText());
        Parent root = FXMLLoader.load(getClass().getResource("CreeFiche.fxml"));
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
