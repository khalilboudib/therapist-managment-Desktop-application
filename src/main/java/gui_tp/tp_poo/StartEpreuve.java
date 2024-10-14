package gui_tp.tp_poo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import orthophoniste.*;

import java.io.IOException;

import static gui_tp.tp_poo.CreeQuestionaire.qcm;
import static gui_tp.tp_poo.HelloApplication.app;

public class StartEpreuve {
    @FXML
    private TextField Observ;
    
    public static Test currentTest;

    @FXML
    private TableColumn<Test, String> TestColm=new TableColumn<>();

    @FXML
    private TableView<Test> Testtab=new TableView<>();

    @FXML
    private Label EnonceExo=new Label();

    @FXML
    private Label QueLibreEnonce=new Label();

    @FXML
    private TextField ExoReponse;

    @FXML
    private TextField ExoScore;

    static exercise ex;
    static question que;

    @FXML
    private TextField QueLibreReponse;

    @FXML
    private TextField QueLibreScore;

    @FXML
    private Label EnonceQCM= new Label();

    @FXML
    private TableColumn<String, String> PropoColm=new TableColumn<>();

    @FXML
    private TextField QCMScore;

    @FXML
    private TableView<String> QCMTab=new TableView<>();

    static ObservableList<Integer> obs;

    @FXML
    private TextArea AddConclusion;

    @FXML
    private Label ScoreText= new Label();



    @FXML
    void GoTrouble(ActionEvent event) throws IOException {
        currentTest.redige_conclusion(AddConclusion.getText());
        if(app.epreuve.hasNext()){
            currentTest=app.epreuve.getNext();
            if (currentTest instanceof serie_exercises){
                ex= ((serie_exercises)currentTest).getNext();
                EnonceExo.setText(ex.getConsigne());

                Parent root = FXMLLoader.load(getClass().getResource("StartExercise.fxml"));
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                Scene scene =new Scene(root);
                stage.setScene(scene);
                stage.show();
            } else if (currentTest instanceof simple_questionaire) {
                que = ((simple_questionaire)currentTest).getNext();
                if (que instanceof question_libre){
                    Parent root = FXMLLoader.load(getClass().getResource("StartQueLibre.fxml"));
                    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    Scene scene =new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                    QueLibreEnonce.setText(que.enonce);
                } else if (que instanceof QCM) {
                    Parent root = FXMLLoader.load(getClass().getResource("StartQCM.fxml"));
                    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    Scene scene =new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                    EnonceQCM.setText(que.enonce);
                    ObservableList<String> obser =FXCollections.observableArrayList( ((QCM)que).reponse_propose );
                    QCMTab.setItems(obser);
                }else if (que instanceof QCU){
                    Parent root = FXMLLoader.load(getClass().getResource("StartQCU.fxml"));
                    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    Scene scene =new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                    EnonceQCM.setText(que.enonce);
                }
            }
        }else {
            Parent root = FXMLLoader.load(getClass().getResource("StartTrouble.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene =new Scene(root);
            stage.setScene(scene);
            stage.show();

        }
    }

    @FXML
    void next(ActionEvent event) throws IOException {
        app.epreuve.setObservation(Observ.getText());
        currentTest =app.epreuve.getNext();
        if (currentTest instanceof serie_exercises){
            ex= ((serie_exercises)currentTest).getNext();
            EnonceExo.setText(ex.getConsigne());

            Parent root = FXMLLoader.load(getClass().getResource("StartExercise.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene =new Scene(root);
            stage.setScene(scene);
            stage.show();
        } else if (currentTest instanceof simple_questionaire) {
            que = ((simple_questionaire)currentTest).getNext();
            if (que instanceof question_libre){
                Parent root = FXMLLoader.load(getClass().getResource("StartQueLibre.fxml"));
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                Scene scene =new Scene(root);
                stage.setScene(scene);
                stage.show();
                QueLibreEnonce.setText(que.enonce);
            } else if (que instanceof QCM) {
                Parent root = FXMLLoader.load(getClass().getResource("StartQCM.fxml"));
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                Scene scene =new Scene(root);
                stage.setScene(scene);
                stage.show();
                EnonceQCM.setText(que.enonce);
                ObservableList<String> obser =FXCollections.observableArrayList( ((QCM)que).reponse_propose );
                QCMTab.setItems(obser);
            }else if (que instanceof QCU){
                Parent root = FXMLLoader.load(getClass().getResource("StartQCU.fxml"));
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                Scene scene =new Scene(root);
                stage.setScene(scene);
                stage.show();
                EnonceQCM.setText(que.enonce);
            }
        }
//        Parent root = FXMLLoader.load(getClass().getResource("StartTrouble.fxml"));
//        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//        Scene scene =new Scene(root);
//        stage.setScene(scene);
//        stage.show();
    }

    @FXML
    void nextExo(ActionEvent event) throws IOException {
        ex.setReponse(ExoReponse.getText());
        ex.setScore(Float.parseFloat(ExoScore.getText()));
        if (((serie_exercises)currentTest).hasNext()){
            ex =((serie_exercises)currentTest).getNext();
            EnonceExo.setText(ex.getConsigne());
        }else {
            currentTest.setScore_totale(currentTest.calculer_score());
            System.out.println(currentTest.getScore_totale());
            ScoreText.setText(String.valueOf(currentTest.getScore_totale()));
            Parent root = FXMLLoader.load(getClass().getResource("score.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene =new Scene(root);
            stage.setScene(scene);
            stage.show();

        }

    }

    @FXML
    void LoadChoix(ActionEvent event) {
        ObservableList<String> obser =FXCollections.observableArrayList( ((QCM)que).reponse_propose );
        QCMTab.setItems(obser);
        EnonceQCM.setText(que.enonce);
    }
    @FXML
    void loadQueLibre(ActionEvent event){
        QueLibreEnonce.setText(que.enonce);
    }
    @FXML
    void loadExo(ActionEvent event){
        EnonceExo.setText(ex.getConsigne());
    }
    @FXML
    void QCMsubmit(ActionEvent event) {
        ((QCM)que).add_reponse(QCMTab.getSelectionModel().getSelectedIndex());
    }

    @FXML
    void nextQCM(ActionEvent event) throws IOException {
        //obs =QCMTab.getSelectionModel().getSelectedIndices();
        //((QCM)que).addAll_reponse(obs);
        ((QCM)que).affiche_reponse();
        que.setScore(Float.parseFloat(QCMScore.getText()));
        if (((simple_questionaire)currentTest).hasNext()){
            que =((simple_questionaire)currentTest).getNext();
            if (que instanceof question_libre){
                Parent root = FXMLLoader.load(getClass().getResource("StartQueLibre.fxml"));
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                Scene scene =new Scene(root);
                stage.setScene(scene);
                stage.show();
                QueLibreEnonce.setText(que.enonce);
            }else if (que instanceof  QCU){
                Parent root = FXMLLoader.load(getClass().getResource("StartQCU.fxml"));
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                Scene scene =new Scene(root);
                stage.setScene(scene);
                stage.show();
                EnonceQCM.setText(que.enonce);
            } else if (que instanceof QCM) {
                Parent root = FXMLLoader.load(getClass().getResource("StartQCM.fxml"));
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                Scene scene =new Scene(root);
                stage.setScene(scene);
                stage.show();
                EnonceQCM.setText(que.enonce);
                ObservableList<String> obser =FXCollections.observableArrayList( ((QCM)que).reponse_propose );
                QCMTab.setItems(obser);
            }
        }else {
            currentTest.setScore_totale(currentTest.calculer_score());
            System.out.println(currentTest.getScore_totale());
            ScoreText.setText(String.valueOf(currentTest.getScore_totale()));
            Parent root = FXMLLoader.load(getClass().getResource("score.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene =new Scene(root);
            stage.setScene(scene);
            stage.show();

        }

    }

    @FXML
    void LoadChoixQCU(ActionEvent event) {
        ObservableList<String> obser =FXCollections.observableArrayList( ((QCU)que).reponse_propose );
        QCMTab.setItems(obser);
        EnonceQCM.setText(que.enonce);
    }

    @FXML
    void nextQCU(ActionEvent event) throws IOException {
        ((QCU)que).setReponse(QCMTab.getSelectionModel().getSelectedIndex());
        que.setScore(Float.parseFloat(QCMScore.getText()));
        if (((simple_questionaire)currentTest).hasNext()){
            que =((simple_questionaire)currentTest).getNext();
            if (que instanceof question_libre){
                Parent root = FXMLLoader.load(getClass().getResource("StartQueLibre.fxml"));
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                Scene scene =new Scene(root);
                stage.setScene(scene);
                stage.show();
                QueLibreEnonce.setText(que.enonce);
            }else if (que instanceof  QCU){
                Parent root = FXMLLoader.load(getClass().getResource("StartQCU.fxml"));
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                Scene scene =new Scene(root);
                stage.setScene(scene);
                stage.show();
                EnonceQCM.setText(que.enonce);
            } else if (que instanceof QCM) {
                Parent root = FXMLLoader.load(getClass().getResource("StartQCM.fxml"));
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                Scene scene =new Scene(root);
                stage.setScene(scene);
                stage.show();
                EnonceQCM.setText(que.enonce);
                ObservableList<String> obser =FXCollections.observableArrayList( ((QCM)que).reponse_propose );
                QCMTab.setItems(obser);
            }
        }else {
            currentTest.setScore_totale(currentTest.calculer_score());
            System.out.println(currentTest.getScore_totale());
            ScoreText.setText(String.valueOf(currentTest.getScore_totale()));
            Parent root = FXMLLoader.load(getClass().getResource("score.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene =new Scene(root);
            stage.setScene(scene);
            stage.show();

        }

    }

    @FXML
    void nextQueLibre(ActionEvent event) throws IOException {
        ((question_libre) que).addReponse(QueLibreReponse.getText());
        System.out.println(((question_libre) que).reponse);
        que.setScore(Float.parseFloat(QueLibreScore.getText()));
        if (((simple_questionaire)currentTest).hasNext()){
            que =((simple_questionaire)currentTest).getNext();
            if (que instanceof question_libre){
                QueLibreEnonce.setText(que.enonce);
            }else if (que instanceof  QCU){
                Parent root = FXMLLoader.load(getClass().getResource("StartQCU.fxml"));
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                Scene scene =new Scene(root);
                stage.setScene(scene);
                stage.show();
                EnonceQCM.setText(que.enonce);
            } else if (que instanceof QCM) {
                Parent root = FXMLLoader.load(getClass().getResource("StartQCM.fxml"));
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                Scene scene =new Scene(root);
                stage.setScene(scene);
                stage.show();
                EnonceQCM.setText(que.enonce);
                ObservableList<String> obser =FXCollections.observableArrayList( ((QCM)que).reponse_propose );
                QCMTab.setItems(obser);
            }
        }else {
            currentTest.setScore_totale(currentTest.calculer_score());
            System.out.println(currentTest.getScore_totale());
            ScoreText.setText(String.valueOf(currentTest.getScore_totale()));
            Parent root = FXMLLoader.load(getClass().getResource("score.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene =new Scene(root);
            stage.setScene(scene);
            stage.show();

        }
    }
    @FXML
    void load(ActionEvent event){
        ScoreText.setText(String.valueOf(currentTest.getScore_totale()));
    }
    @FXML
    void start(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("SetObservation.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene =new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void initialize(){
        TestColm.setCellValueFactory(new PropertyValueFactory<Test, String >("nom"));
        ObservableList<Test> obs= FXCollections.observableArrayList(app.epreuve.test);
        Testtab.setItems(obs);
        QCMTab.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        PropoColm.setCellValueFactory(cellData -> new javafx.beans.property.SimpleStringProperty(cellData.getValue()));
//        ObservableList<String> obser =FXCollections.observableArrayList( ((QCM)que).reponse_propose );
//        QCMTab.setItems(obser);
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
