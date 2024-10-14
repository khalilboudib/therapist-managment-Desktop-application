package gui_tp.tp_poo;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class LoginController {

    @FXML
    private TextField emailField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private void handleLogin() {
        String email = emailField.getText();
        String password = passwordField.getText();

        if (validateEmail(email) && validatePassword(password)) {
            if (authenticate(email, password)) {
                showAlert(AlertType.INFORMATION, "Login Successful!", "Welcome " + email + "!");
            } else {
                showAlert(AlertType.ERROR, "Login Failed", "Invalid email or password.");
            }
        } else {
            showAlert(AlertType.ERROR, "Validation Error", "Please enter a valid email and password.");
        }
    }

    private boolean validateEmail(String email) {
        // Simple regex for email validation
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        return email.matches(emailRegex);
    }

    private boolean validatePassword(String password) {
        // Password must be at least 6 characters long
        return password != null && password.length() >= 6;
    }

    private boolean authenticate(String email, String password) {
        // Replace this with actual authentication logic (e.g., database query)
        // For demonstration, we'll assume a static check
        return "user@example.com".equals(email) && "password123".equals(password);
    }

    private void showAlert(AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
