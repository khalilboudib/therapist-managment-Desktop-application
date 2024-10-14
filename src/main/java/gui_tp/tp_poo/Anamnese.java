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
import orthophoniste.Rendez_vous;
import orthophoniste.amnese;
import orthophoniste.questionaire_enfant;

import java.io.IOException;
import java.time.LocalDate;

import static gui_tp.tp_poo.CreeTest.simpleQuestionaire;
import static gui_tp.tp_poo.HelloApplication.app;
import static gui_tp.tp_poo.HelloController.amneseEnfant;

public class Anamnese {
    Stage stage;
    Scene scene;
    Parent root;
    @FXML
    private TableColumn<amnese, String> ActionColm;

    @FXML
    private TableView<amnese> AnamTab=new TableView<>();

    @FXML
    private TableColumn<amnese, String > NomColm= new TableColumn<>();

    @FXML
    private TableColumn<amnese, String> TypeColm=new TableColumn<>();
    @FXML
    public void creer_anamnese(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
        stage =(Stage) ((Node)event.getSource()).getScene().getWindow();
        scene =new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void initialize(){
        NomColm.setCellValueFactory(new PropertyValueFactory<amnese, String >("nom"));
        TypeColm.setCellValueFactory(new PropertyValueFactory<amnese, String >("type"));
        ObservableList<amnese> obs= FXCollections.observableArrayList(app.anamneses);
        AnamTab.setItems(obs);
    }

    @FXML
    void supprimer(ActionEvent event){
        amnese amn=AnamTab.getSelectionModel().getSelectedItem();
        int i =AnamTab.getSelectionModel().getSelectedIndex();
        AnamTab.getItems().remove(i);
        app.anamneses.remove(amn);
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
