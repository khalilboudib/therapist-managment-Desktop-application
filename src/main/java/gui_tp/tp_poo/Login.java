package gui_tp.tp_poo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

import static gui_tp.tp_poo.HelloApplication.app;
import static gui_tp.tp_poo.Home_Page.DocteurName;

public class Login {
    @FXML
    private Label emailErrorLabel;

    @FXML
    private Label passwordErrorLabel;

    @FXML
    private TextField emailTextField;

    @FXML
    private TextField passwordTextField;

    @FXML
    void SignIn(ActionEvent event) throws IOException {
        if(app.orthophoniste.email.compareTo(emailTextField.getText())==0 && app.orthophoniste.mot_de_passe.compareTo(passwordTextField.getText())==0){
            DocteurName.setText(app.orthophoniste.nom);
            Parent root = FXMLLoader.load(getClass().getResource("Home_Page.fxml"));
            Stage stage =(Stage) ((Node)event.getSource()).getScene().getWindow();
            Scene scene =new Scene(root);
            stage.setScene(scene);
            stage.show();
        } else if (app.orthophoniste.email.compareTo(emailTextField.getText())!=0) {
            emailErrorLabel.setText("Wrong Email");
        } else if (app.orthophoniste.mot_de_passe.compareTo(passwordTextField.getText())!=0) {
            passwordErrorLabel.setText("Wrong Password");
        }else {
            emailErrorLabel.setText("Wrong Email");
            passwordErrorLabel.setText("Wrong Password");
        }
    }

    @FXML
    void SignUp(ActionEvent event) throws IOException {
        Parent root =FXMLLoader.load(getClass().getResource("SignUp.fxml"));
        Stage stage =(Stage) ((Node)event.getSource()).getScene().getWindow();
        Scene scene =new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
