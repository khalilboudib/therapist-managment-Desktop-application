package gui_tp.tp_poo;

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

import static gui_tp.tp_poo.HelloApplication.app;
import static gui_tp.tp_poo.HelloController.amneseAdulte;
import static gui_tp.tp_poo.HelloController.amneseEnfant;

public class questionaire_adulte {
    @FXML
    private TableColumn<orthophoniste.questionaire_adulte,type_adulte > cate_enfant=new TableColumn<>();

    @FXML
    private TableColumn<orthophoniste.questionaire_adulte, String > enonce_enfant=new TableColumn<>();

    @FXML
    private TableView<orthophoniste.questionaire_adulte> que_enfant_table=new TableView<>();

    @FXML
    private TextField enonce_button;

    @FXML
    private ChoiceBox<type_adulte> typeEnfant=new ChoiceBox<>();

    @FXML
    void addQueEnfant(ActionEvent event) throws IOException {
        orthophoniste.questionaire_adulte questionaireEnfant =new orthophoniste.questionaire_adulte(typeEnfant.getValue());
        questionaireEnfant.setEnonce(enonce_button.getText());
        amneseAdulte.questionaires.add(questionaireEnfant);
        for (orthophoniste.questionaire_adulte que : amneseAdulte.questionaires){
            System.out.println(que.enonce);
            System.out.println(que.type);
        }
        Parent root = FXMLLoader.load(getClass().getResource("questionaire_adulte.fxml"));
        Stage stage =(Stage) ((Node)event.getSource()).getScene().getWindow();
        Scene scene =new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void initialize(){
        enonce_enfant.setCellValueFactory(new PropertyValueFactory<orthophoniste.questionaire_adulte,String>("enonce"));
        cate_enfant.setCellValueFactory(new PropertyValueFactory<orthophoniste.questionaire_adulte,type_adulte>("type"));
        ObservableList<orthophoniste.questionaire_adulte> obser = que_enfant_table.getItems();
        obser.addAll(amneseAdulte.questionaires);
        que_enfant_table.setItems(obser);
        typeEnfant.getItems().addAll(type_adulte.values());
    }

    @FXML
    void ajoute_question_enfant(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("QueAnaAdulte.fxml"));
        Stage stage =(Stage) ((Node)event.getSource()).getScene().getWindow();
        Scene scene =new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    @FXML
    void supprimer(ActionEvent event) {
        orthophoniste.questionaire_adulte que=que_enfant_table.getSelectionModel().getSelectedItem();
        int id =que_enfant_table.getSelectionModel().getSelectedIndex();
        que_enfant_table.getItems().remove(id);
        amneseAdulte.questionaires.remove(que);
    }

    @FXML
    void terminer(ActionEvent event) throws IOException {
        app.anamneses.add(amneseAdulte);
        for (amnese an :app.anamneses){
            System.out.println(an.getNom());
        }
        Parent root = FXMLLoader.load(getClass().getResource("Anamnese.fxml"));
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
