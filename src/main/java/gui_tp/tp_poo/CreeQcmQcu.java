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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import orthophoniste.question;

import java.io.IOException;

import static gui_tp.tp_poo.CreeQuestionaire.qcm;
import static gui_tp.tp_poo.CreeTest.simpleQuestionaire;

public class CreeQcmQcu {

    @FXML
    private TableColumn<String , String> QcmColm=new TableColumn<>();

    @FXML
    private TableView<String> QcmTab=new TableView<>();

    @FXML
    private TextField questionTextField;

    @FXML
    private TextField choix;

    @FXML
    void initialize(){
        QcmColm.setCellValueFactory(cellData -> new javafx.beans.property.SimpleStringProperty(cellData.getValue()));
        ObservableList<String> obser =FXCollections.observableArrayList(qcm.reponse_propose);
        QcmTab.setItems(obser);
    }

    @FXML
    private void addChoix(ActionEvent event) throws IOException {
        qcm.add_reponse_propose(choix.getText());
        for (String jj :qcm.reponse_propose){
            System.out.println(jj);
        }
        Parent root = FXMLLoader.load(getClass().getResource("CreeQcmQcu.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene =new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    void ajouteChoix(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("AddChoix.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene =new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void sauv(ActionEvent event) throws IOException {
        qcm.setEnonce(questionTextField.getText());
        simpleQuestionaire.questions.add(qcm);
        Parent root = FXMLLoader.load(getClass().getResource("CreeQuestionaire.fxml"));
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
