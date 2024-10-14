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

import static gui_tp.tp_poo.CreeQuestionaire.qcu;
import static gui_tp.tp_poo.CreeTest.simpleQuestionaire;

public class CreeQcu {

    @FXML
    private TableColumn<String , String> QcuColm= new TableColumn<>();

    @FXML
    private TableView<String> QcuTab= new TableView<>();

    @FXML
    private TextField choix;

    @FXML
    private TextField questionTextField;


    @FXML
    void initialize(){
        QcuColm.setCellValueFactory(cellData -> new javafx.beans.property.SimpleStringProperty(cellData.getValue()));
        ObservableList<String> obserr =FXCollections.observableArrayList(qcu.reponse_propose);
        QcuTab.setItems(obserr);

    }

    @FXML
    void ajouteChoixQCU(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("AddChoixQcu.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene =new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void addChoixQcu(ActionEvent event) throws IOException {
        qcu.add_reponse_propose(choix.getText());
        for (String jj :qcu.reponse_propose){
            System.out.println(jj);
        }
        Parent root = FXMLLoader.load(getClass().getResource("CreeQcu.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene =new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void sauvQCU(ActionEvent event) throws IOException {
        qcu.setEnonce(questionTextField.getText());
        simpleQuestionaire.questions.add(qcu);
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
