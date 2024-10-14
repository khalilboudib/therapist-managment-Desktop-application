package gui_tp.tp_poo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

import static gui_tp.tp_poo.HelloApplication.app;

public class SignUpController {

    @FXML
    private VBox nomField2;

    @FXML
    private TextField nomTextField2;

    @FXML
    private Label nomErrorLabel2;

    @FXML
    private VBox nomField21;

    @FXML
    private TextField nomTextField21;

    @FXML
    private Label nomErrorLabel21;

    @FXML
    private VBox nomField22;

    @FXML
    private TextField nomTextField22;

    @FXML
    private Label nomErrorLabel22;

    @FXML
    private VBox nomField23;

    @FXML
    private TextField nomTextField23;

    @FXML
    private Label nomErrorLabel23;

    @FXML
    private VBox nomField24;

    @FXML
    private TextField nomTextField24;

    @FXML
    private Label nomErrorLabel24;

    @FXML
    private VBox nomField25;

    @FXML
    private TextField nomTextField25;

    @FXML
    private Label nomErrorLabel25;

    public void initialize() {
        addListenersToTextFields();
    }

    @FXML
    private void signUpClicked(ActionEvent event) throws IOException {
        clearErrorLabels(); // Clear previous error labels

        validateTextField(nomTextField2, nomField2, nomErrorLabel2, "Fill this field");
        validateTextField(nomTextField21, nomField21, nomErrorLabel21, "Fill this field");
        validateTextField(nomTextField22, nomField22, nomErrorLabel22, "Fill this field");
        validateTextField(nomTextField23, nomField23, nomErrorLabel23, "Fill this field");
        validateTextField(nomTextField24, nomField24, nomErrorLabel24, "Fill this field");
        validateTextField(nomTextField25, nomField25, nomErrorLabel25, "Fill this field");
        app.cree_compte(nomTextField2.getText(),nomTextField21.getText(),nomTextField24.getText(),nomTextField22.getText(),nomTextField23.getText(),Integer.parseInt(nomTextField25.getText()));
        app.orthophoniste.afficher();
        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene =new Scene(root);
        stage.setScene(scene);
        stage.show();
        // You can add additional validation logic here
    }

    private void addListenersToTextFields() {
        addListenerToTextField(nomTextField2, nomField2, nomErrorLabel2);
        addListenerToTextField(nomTextField21, nomField21, nomErrorLabel21);
        addListenerToTextField(nomTextField22, nomField22, nomErrorLabel22);
        addListenerToTextField(nomTextField23, nomField23, nomErrorLabel23);
        addListenerToTextField(nomTextField24, nomField24, nomErrorLabel24);
        addListenerToTextField(nomTextField25, nomField25, nomErrorLabel25);
    }

    private void addListenerToTextField(TextField textField, VBox field, Label errorLabel) {
        textField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.isEmpty()) {
                resetFieldStyle(field, errorLabel);
            }
        });
    }

    private void validateTextField(TextField textField, VBox field, Label errorLabel, String errorMessage) {
        if (isTextFieldEmpty(textField)) {
            setFieldError(field, errorLabel, errorMessage);
        }
    }

    private boolean isTextFieldEmpty(TextField textField) {
        return textField.getText().isEmpty();
    }

    private void setFieldError(VBox field, Label errorLabel, String errorMessage) {
        TextField textField = (TextField) field.getChildren().get(1); // Assuming the TextField is the second child
        textField.setStyle("-fx-background-color: #F3F7FB;-fx-border-radius: 20;-fx-border-color: red;-fx-border-width: 0.44;-fx-padding: 15");
        errorLabel.setText(errorMessage);
    }

    private void resetFieldStyle(VBox field, Label errorLabel) {
        TextField textField = (TextField) field.getChildren().get(1); // Assuming the TextField is the second child
        textField.setStyle("-fx-background-color: #F3F7FB;-fx-border-radius: 20;-fx-border-color: #575553;-fx-border-width: 0.44;-fx-padding: 15"); // Reset style
        errorLabel.setText(""); // Clear error message
    }

    private void clearErrorLabels() {
        nomErrorLabel2.setText("");
        nomErrorLabel21.setText("");
        nomErrorLabel22.setText("");
        nomErrorLabel23.setText("");
        nomErrorLabel24.setText("");
        nomErrorLabel25.setText("");
    }
}
