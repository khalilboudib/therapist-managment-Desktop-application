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
import orthophoniste.Test;
import orthophoniste.amnese;

import java.io.IOException;

import static gui_tp.tp_poo.HelloApplication.app;

public class TabTest {
    @FXML
    private TableColumn<Test, String> ActionColm = new TableColumn<>();

    @FXML
    private TableColumn<Test, String> NomColm=new TableColumn<>();

    @FXML
    private TableView<Test> TestTab=new TableView<>();

    @FXML
    void CreeTest(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("CreeTest.fxml"));
        Stage stage =(Stage) ((Node)event.getSource()).getScene().getWindow();
        Scene scene =new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void initialize(){
        NomColm.setCellValueFactory(new PropertyValueFactory<Test, String >("nom"));
        ActionColm.setCellValueFactory(new PropertyValueFactory<Test, String >("type"));
        ObservableList<Test> obs= FXCollections.observableArrayList(app.epreuve.test);
        TestTab.setItems(obs);
    }

    @FXML
    void reload(){
        TestTab.getItems().clear();
        ObservableList<Test> obs= FXCollections.observableArrayList(app.epreuve.test);
        TestTab.setItems(obs);
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
    void supprimer(ActionEvent event){
        Test test = TestTab.getSelectionModel().getSelectedItem();
        int id=TestTab.getSelectionModel().getSelectedIndex();
        TestTab.getItems().remove(id);
        app.epreuve.test.remove(test);
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
