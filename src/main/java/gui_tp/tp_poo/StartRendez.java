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
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import orthophoniste.*;

import java.io.IOException;

import static gui_tp.tp_poo.HelloApplication.app;
import static gui_tp.tp_poo.Rendez_vous.selectedRendez;

public class StartRendez {

    @FXML
    private TableColumn<amnese, String> AnamColm=new TableColumn<>();

    @FXML
    private TableView<amnese> AnamTab= new TableView<>();

    public static amnese selectedAnam;
    static questionaire_enfant queEnf;
    static orthophoniste.questionaire_adulte queAdulte;

    @FXML
    private Label QueAnm=new Label();

    @FXML
    private TextField QueReponse;

    @FXML
    private Label TypeAnm=new Label();

    @FXML
    void startrendez(ActionEvent event) throws IOException {
        if (selectedRendez instanceof consultation){
            Parent root = FXMLLoader.load(getClass().getResource("StartAnamnese.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene =new Scene(root);
            stage.setScene(scene);
            stage.show();
        }else {
            Parent root = FXMLLoader.load(getClass().getResource("StartEpreuve.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene =new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }

    @FXML
    void next(ActionEvent event) throws IOException {
        selectedAnam = AnamTab.getSelectionModel().getSelectedItem();
        Parent root = FXMLLoader.load(getClass().getResource("StartQueAnam.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene =new Scene(root);
        stage.setScene(scene);
        stage.show();
        if (selectedAnam instanceof amnese_enfant){
            queEnf = ((amnese_enfant) selectedAnam).getNext();
            QueAnm.setText(queEnf.enonce);
            TypeAnm.setText(queEnf.type.toString());
        } else if (selectedAnam instanceof amnese_adulte) {
            queAdulte = ((amnese_adulte) selectedAnam).getNext();
            QueAnm.setText(queAdulte.enonce);
            TypeAnm.setText(queAdulte.type.toString());
        }
    }
    @FXML
    void loadAnam(ActionEvent event){
        if (selectedAnam instanceof amnese_enfant){
            queEnf = ((amnese_enfant) selectedAnam).getNext();
            QueAnm.setText(queEnf.enonce);
            TypeAnm.setText(queEnf.type.toString());
        } else if (selectedAnam instanceof amnese_adulte) {
            queAdulte = ((amnese_adulte) selectedAnam).getNext();
            QueAnm.setText(queAdulte.enonce);
            TypeAnm.setText(queAdulte.type.toString());
        }
    }
    @FXML
    void initialize(){
        AnamColm.setCellValueFactory(new PropertyValueFactory<amnese, String >("nom"));
        ObservableList<amnese> obs= FXCollections.observableArrayList(app.anamneses);
        AnamTab.setItems(obs);
    }

    @FXML
    void nextQue(ActionEvent event) throws IOException {
        if (selectedAnam instanceof amnese_enfant){
            if (((amnese_enfant) selectedAnam).hasNext()) {
                queEnf.setReponse(QueReponse.getText());
                System.out.println(queEnf.reponse);
                queEnf = ((amnese_enfant) selectedAnam).getNext();
                QueAnm.setText(queEnf.enonce);
                TypeAnm.setText(queEnf.type.toString());
            }else {
                queEnf.setReponse(QueReponse.getText());
                System.out.println("->>>");
                for (questionaire qu : ((amnese_enfant) selectedAnam).questionaires){
                    System.out.println(qu.reponse);
                }
                Parent root = FXMLLoader.load(getClass().getResource("StartEpreuve.fxml"));
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                Scene scene =new Scene(root);
                stage.setScene(scene);
                stage.show();
            }
        } else if (selectedAnam instanceof amnese_adulte) {
            if (((amnese_adulte) selectedAnam).hasNext()) {
                queAdulte.setReponse(QueReponse.getText());
                System.out.println(queAdulte.reponse);
                queAdulte = ((amnese_adulte) selectedAnam).getNext();
                QueAnm.setText(queAdulte.enonce);
                TypeAnm.setText(queAdulte.type.toString());
            }else {
                queAdulte.setReponse(QueReponse.getText());
                System.out.println("->>>");
                for (questionaire qu : ((amnese_adulte) selectedAnam).questionaires){
                    System.out.println(qu.reponse);
                }
                Parent root = FXMLLoader.load(getClass().getResource("StartEpreuve.fxml"));
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                Scene scene =new Scene(root);
                stage.setScene(scene);
                stage.show();
            }
        }

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
