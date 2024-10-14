package gui_tp.tp_poo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import orthophoniste.*;

import java.io.IOException;

import static gui_tp.tp_poo.CreeTest.serieExercises;
import static gui_tp.tp_poo.CreeTest.simpleQuestionaire;
import static gui_tp.tp_poo.HelloApplication.app;

public class CreeQuestionaire {
    @FXML
    private TableColumn<question, ?> Actions;

    @FXML
    private TableColumn<question, String> EnonceQue= new TableColumn<>();

    @FXML
    private TableView<question> QueTab= new TableView<>();

    @FXML
    private TableColumn<question, String> TypeQue;

    @FXML
    private ToggleButton Qcm;

    @FXML
    private ToggleButton Qcu;

    @FXML
    private ToggleButton QueLibre;

    @FXML
    private TextField QueLibreEnonce;

    @FXML
    private TextField questionTextField;


    static QCU qcu;
    static QCM qcm;


    @FXML
    void AjouteQue(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("CreeQue.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene =new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void supprimer(ActionEvent event){
        question que =QueTab.getSelectionModel().getSelectedItem();
        int i =QueTab.getSelectionModel().getSelectedIndex();
        QueTab.getItems().remove(i);
        simpleQuestionaire.questions.remove(que);
    }

    @FXML
    void suivant(ActionEvent event) throws IOException {
        if (Qcm.isSelected()){
            qcm =new QCM();
            Parent root = FXMLLoader.load(getClass().getResource("CreeQcmQcu.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene =new Scene(root);
            stage.setScene(scene);
            stage.show();
        } else if (QueLibre.isSelected()) {
            Parent root = FXMLLoader.load(getClass().getResource("CreeQueLibre.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene =new Scene(root);
            stage.setScene(scene);
            stage.show();
        }else if (Qcu.isSelected()){
            qcu =new QCU();
            Parent root = FXMLLoader.load(getClass().getResource("CreeQcu.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene =new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }
    @FXML
    void AddQueLibre(ActionEvent event) throws IOException {
        question_libre que =new question_libre();
        que.setEnonce(QueLibreEnonce.getText());
        simpleQuestionaire.questions.add(que);
        ObservableList<question> obs =QueTab.getItems();
        obs.add(que);
        QueTab.setItems(obs);
        Parent root = FXMLLoader.load(getClass().getResource("CreeQuestionaire.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene =new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void initialize(){
        EnonceQue.setCellValueFactory(new PropertyValueFactory<>("enonce"));
        ObservableList<question> obs = FXCollections.observableArrayList(simpleQuestionaire.questions);
        QueTab.setItems(obs);

    }



    @FXML
    void terminer(ActionEvent event) throws IOException {
        app.epreuve.add_test(simpleQuestionaire);
        Parent root = FXMLLoader.load(getClass().getResource("TabTest.fxml"));
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
