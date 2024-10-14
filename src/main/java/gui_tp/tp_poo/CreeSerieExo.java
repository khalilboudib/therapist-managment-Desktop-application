package gui_tp.tp_poo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import orthophoniste.Test;
import orthophoniste.*;

import java.io.IOException;

import static gui_tp.tp_poo.CreeTest.serieExercises;
import static gui_tp.tp_poo.HelloApplication.app;

public class CreeSerieExo {

    @FXML
    private TableColumn<exercise, String> EnonceExo= new TableColumn<>();

    @FXML
    private TableColumn<?, ?> actions;

    @FXML
    private TableView<exercise> ExoTab= new TableView<>();
    @FXML
    private TextField EnonceField;

    @FXML
    private TextField MaterielField;

    @FXML
    void AddExo(ActionEvent event) throws IOException {
        exercise exo=new exercise(EnonceField.getText(),MaterielField.getText());
        serieExercises.addExo(exo);
        for (exercise ex :serieExercises.exercises){
            System.out.println(ex.getConsigne());
            System.out.println(ex.getNom_material());
        }
        ObservableList<exercise> obs =ExoTab.getItems();
        obs.add(exo);
        ExoTab.setItems(obs);
        Parent root = FXMLLoader.load(getClass().getResource("CreeSerieExo.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene =new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void ajouteExo(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("CreeExo.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene =new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void supprimer(ActionEvent event){
        exercise ex=ExoTab.getSelectionModel().getSelectedItem();
        int i =ExoTab.getSelectionModel().getSelectedIndex();
        ExoTab.getItems().remove(i);
        serieExercises.exercises.remove(ex);
    }

    @FXML
    void initialize() {
        EnonceExo.setCellValueFactory(new PropertyValueFactory<>("consigne"));
        ObservableList<exercise> obs = FXCollections.observableArrayList(serieExercises.exercises);
        ExoTab.setItems(obs);
    }

    @FXML
    void terminer(ActionEvent event) throws IOException {
        app.epreuve.add_test(serieExercises);
        Parent root = FXMLLoader.load(getClass().getResource("TabTest.fxml"));
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
