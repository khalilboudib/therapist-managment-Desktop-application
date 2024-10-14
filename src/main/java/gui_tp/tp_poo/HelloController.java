package gui_tp.tp_poo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import orthophoniste.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import orthophoniste.*;

import java.io.IOException;
import java.net.URL;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;
import static gui_tp.tp_poo.HelloApplication.app;

public class HelloController {
    Stage stage;
    Scene scene;
    Parent root;

    @FXML
    private TextField enonce_button;

    @FXML
    private Button add_button;

    @FXML
     ImageView image;

    @FXML
    private TextField add;

    @FXML
    private PasswordField pass;

    @FXML
    private Button sign_upp;

    @FXML
    private TextField telephone;

    @FXML
    private TextField nom;

    @FXML
    private TextField prenom;

    @FXML
    private TextField email;

    @FXML
    private TextField NomAnam;

    static amnese_enfant amneseEnfant;
    static amnese_adulte amneseAdulte;

    @FXML
     void sign_up(ActionEvent event) throws IOException {
        String nom_ =nom.getText();
        String prenom_ =prenom.getText();
        String email_=email.getText();
        String add_ =add.getText();
        int telephone_ =Integer.parseInt(telephone.getText());
        String pass_=pass.getText();
        app.cree_compte(nom_,prenom_,add_,email_,pass_,telephone_);
        app.orthophoniste.afficher();
        Parent root =FXMLLoader.load(getClass().getResource("Anamnese.fxml"));
        stage =(Stage) ((Node)event.getSource()).getScene().getWindow();
        scene =new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    void questionaire_enfant(ActionEvent event) throws IOException {
        amneseEnfant=new amnese_enfant();
        amneseEnfant.setNom(NomAnam.getText());
        Parent root =FXMLLoader.load(getClass().getResource("tabQueEnf.fxml"));
        stage =(Stage) ((Node)event.getSource()).getScene().getWindow();
        scene =new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    void questionaire_adulte(ActionEvent event) throws IOException {
        amneseAdulte =new amnese_adulte();
        amneseAdulte.setNom(NomAnam.getText());
        Parent root =FXMLLoader.load(getClass().getResource("questionaire_adulte.fxml"));
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