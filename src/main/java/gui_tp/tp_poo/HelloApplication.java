package gui_tp.tp_poo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Dialog;
import javafx.stage.Stage;

import java.io.*;

public class HelloApplication extends Application {
    public static orthophoniste.Application app = new orthophoniste.Application() ;
    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Login.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
        loadObject();
        stage.setOnCloseRequest(e -> saveObject());
    }

    public static void main(String[] args) {
        launch();
    }

    private void saveObject() {
        try (FileOutputStream fileOut = new FileOutputStream("AppFile.ser");
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(app);
            System.out.println("Serialized data is saved in myObject.ser");
        } catch (IOException i) {
            i.printStackTrace();
        }
    }
    private void loadObject() {
        try (FileInputStream fileIn = new FileInputStream("AppFile.ser");
             ObjectInputStream in = new ObjectInputStream(fileIn)) {
            app = (orthophoniste.Application) in.readObject();
        } catch (IOException i) {
            System.out.println("Object not found, creating new one.");
            i.printStackTrace();
        } catch (ClassNotFoundException c) {
            System.out.println("MyObject class not found");
            c.printStackTrace();
        }
    }
}
