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
import orthophoniste.amnese;
import orthophoniste.questionaire_enfant;
import orthophoniste.type_enfant;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static gui_tp.tp_poo.HelloApplication.app;
import static gui_tp.tp_poo.HelloController.amneseEnfant;

public class tabQueEnf {
    Stage stage;
    Scene scene;
    Parent root;

    @FXML
    public  TableColumn<?, ?> actions_enfant;

    @FXML
    public  TableColumn<questionaire_enfant, type_enfant> cate_enfant;

    @FXML
    public TableColumn<questionaire_enfant, String > enonce_enfant;

    @FXML
    public TableView<questionaire_enfant> que_enfant_table;

    @FXML
    void initialize() {
        enonce_enfant.setCellValueFactory(new PropertyValueFactory<questionaire_enfant,String>("enonce"));
        cate_enfant.setCellValueFactory(new PropertyValueFactory<questionaire_enfant,type_enfant>("type"));
        ObservableList<questionaire_enfant> obser = que_enfant_table.getItems();
        obser.addAll(amneseEnfant.questionaires);
        que_enfant_table.setItems(obser);
    }
    @FXML
    void ajoute_question_enfant(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("QueAnaEnf.fxml"));
        stage =(Stage) ((Node)event.getSource()).getScene().getWindow();
        scene =new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
//    @FXML
//    void reload(ActionEvent event){
//        que_enfant_table.getItems().clear();
//        ObservableList<questionaire_enfant> obser = que_enfant_table.getItems();
//        obser.addAll(amneseEnfant.questionaires);
//        que_enfant_table.setItems(obser);
//    }
    @FXML
    void supprimer(){
        questionaire_enfant que=que_enfant_table.getSelectionModel().getSelectedItem();
        int id =que_enfant_table.getSelectionModel().getSelectedIndex();
        que_enfant_table.getItems().remove(id);
        amneseEnfant.questionaires.remove(que);
    }
    @FXML
    void terminer(ActionEvent event) throws IOException {
        app.anamneses.add(amneseEnfant);
        for (amnese an :app.anamneses){
            System.out.println(an.getNom());
        }
        Parent root = FXMLLoader.load(getClass().getResource("Anamnese.fxml"));
        stage =(Stage) ((Node)event.getSource()).getScene().getWindow();
        scene =new Scene(root);
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
