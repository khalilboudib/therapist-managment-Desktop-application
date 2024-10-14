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
import orthophoniste.Patient;
import orthophoniste.Rendez_vous;
import orthophoniste.*;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import static gui_tp.tp_poo.HelloApplication.app;

public class patientpage {
    @FXML
    private TableColumn<orthophoniste.Rendez_vous, LocalDate> DateColm=new TableColumn<>();

    @FXML
    private TableColumn<orthophoniste.Rendez_vous, String > DureeColm=new TableColumn<>();

    @FXML
    private TableColumn<orthophoniste.Rendez_vous, Boolean> PrensColm= new TableColumn<>();

    @FXML
    private TableView<orthophoniste.Rendez_vous> RendezTable= new TableView<>();

    @FXML
    private TableColumn<orthophoniste.Rendez_vous, ?> StatusColm= new TableColumn<>();

    @FXML
    private TableColumn<orthophoniste.Rendez_vous, ?> StatusColm1= new TableColumn<>();

    @FXML
    private TableColumn<orthophoniste.Rendez_vous, String > TimeColm= new TableColumn<>();

    @FXML
    private TableColumn<Patient, String> NomPatient=new TableColumn<>();

    @FXML
    private TableColumn<Patient, Integer> NumDossier=new TableColumn<>();

    @FXML
    private TableView<Patient> PatientTab=new TableView<>();

    @FXML
    private TableColumn<Patient, String> PrenomPatient=new TableColumn<>();

    static Patient patient;

    @FXML
    private Label AdresseLabel=new Label();
    @FXML
    private Label DateLabel=new Label();
    @FXML
    private Label LieuLabel=new Label();

    @FXML
    private Label NomLabel=new Label();

    @FXML
    private Label NumDossLabel=new Label();

    @FXML
    private Label PrenomLabel=new Label();
    @FXML
    private Label TelLabel=new Label();
    @FXML
    private Label TypeLabel=new Label();

    public static Rendez_vous rendezVous;
    public static fiche_de_suivi fichee;

    @FXML
    private TableView<fiche_de_suivi> FicheTab=new TableView<>();
    @FXML
    private TableColumn<fiche_de_suivi, String> NomFicheLabel=new TableColumn<>();

    @FXML
    void seeDetailsFiche(ActionEvent event) throws IOException {
        fichee = FicheTab.getSelectionModel().getSelectedItem();
        Parent root = FXMLLoader.load(getClass().getResource("Tabfiche.fxml"));
        Stage stage =(Stage) ((Node)event.getSource()).getScene().getWindow();
        Scene scene =new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    @FXML
    void ShowInfo(ActionEvent event) {
        AdresseLabel.setText(patient.adresse);
        DateLabel.setText(patient.date_de_naissance);
        LieuLabel.setText(patient.lien_de_naissance);
        NomLabel.setText(patient.nom);
        NumDossLabel.setText(String.valueOf(patient.getNumDossi()));
        PrenomLabel.setText(patient.prenom);
        TelLabel.setText(String.valueOf(patient.getTelephone()));
        TypeLabel.setText(patient.getType());
        ObservableList<Rendez_vous> obse= FXCollections.observableArrayList(patient.dossier.rendezVous);
        RendezTable.setItems(obse);
        ObservableList<fiche_de_suivi> obser=FXCollections.observableArrayList(patient.dossier.fiches_Des_Suivi);
        FicheTab.setItems(obser);
    }


    @FXML
    void DetailPatient(ActionEvent event) throws IOException {
        patient=PatientTab.getSelectionModel().getSelectedItem();
        Parent root = FXMLLoader.load(getClass().getResource("patientpage.fxml"));
        Stage stage =(Stage) ((Node)event.getSource()).getScene().getWindow();
        Scene scene =new Scene(root);
        stage.setScene(scene);
        stage.show();
    }



    @FXML
    void initialize(){
        NumDossier.setCellValueFactory(new PropertyValueFactory<Patient, Integer >("NumDossi"));
        NomPatient.setCellValueFactory(new PropertyValueFactory<Patient, String  >("nom"));
        PrenomPatient.setCellValueFactory(new PropertyValueFactory<Patient, String  >("prenom"));
        DateColm.setCellValueFactory(new PropertyValueFactory<Rendez_vous, LocalDate >("date"));
        DureeColm.setCellValueFactory(new PropertyValueFactory<Rendez_vous, String >("duree"));
        TimeColm.setCellValueFactory(new PropertyValueFactory<Rendez_vous, String >("heure"));
        NomFicheLabel.setCellValueFactory(new PropertyValueFactory<fiche_de_suivi, String >("nom"));

        ObservableList<Patient> obs= FXCollections.observableArrayList(app.patients);
        PatientTab.setItems(obs);



    }


    @FXML
    void seeDetailsRendez(ActionEvent event) throws IOException {
        rendezVous = RendezTable.getSelectionModel().getSelectedItem();
        Parent root = FXMLLoader.load(getClass().getResource("detailpatient.fxml"));
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
