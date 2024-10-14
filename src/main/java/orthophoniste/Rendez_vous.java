package orthophoniste;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Objects;

public class Rendez_vous implements Serializable {
    LocalDate date;
    String heure;

    String duree;
    String observation;
    String type;



    public String getObservation() {
        return observation;
    }

    public String getType() {
        return type;
    }

    public Patient patient;

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void addPatient(Patient patient){
        this.patient=patient;
    }

    public void setHeure(String heure) {
        this.heure = heure;
    }

    public void setDuree(String duree) {
        this.duree = duree;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getHeure() {
        return heure;
    }

    public String getDuree() {
        return duree;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    public Rendez_vous(){
    }

    public Rendez_vous(LocalDate date, String heure, String duree) {
        this.date = date;
        this.heure = heure;
        this.duree = duree;
    }
    public void afficher(){

    }
    public String getobservation(){
        return this.observation;
    }
}

class Premier_Rendez_vous extends Rendez_vous{
    Patient patient;

    public Premier_Rendez_vous(){

    }
    public Premier_Rendez_vous(LocalDate date, String heure, String duree) {
        super(date, heure, duree);
    }
    public Patient inscrire_patient(){
        Patient patient;
        Scanner sc=new Scanner(System.in);
        System.out.println("inscription d'un patient : ");
        System.out.println("-> nom :");
        String nom=sc.nextLine();
        System.out.println("-> prenom :");
        String prenom=sc.nextLine();
        System.out.println("-> date de naissance :");
        String date_de_naissance=sc.nextLine();
        System.out.println("-> lieu de naissance :");
        String lieu_de_naissance=sc.nextLine();
        System.out.println("-> adresse :");
        String adresse=sc.nextLine();
        System.out.print("entrer 1 si le patient est un enfant,0 sinon : ");
        int type = sc.nextInt();
        sc.nextLine();
        if (type==1){
            System.out.println("-> classe d'etude :");
            String classe_etude=sc.nextLine();
            System.out.println("-> telephone des parents :");
            int telephone=sc.nextInt();
            patient =new Patient_enfant(nom,prenom,date_de_naissance,lieu_de_naissance,adresse,classe_etude,telephone);
            return patient;
        } else if (type==0) {
            System.out.println("-> diplome :");
            String diplome=sc.nextLine();
            System.out.println("-> proffession :");
            String proffession=sc.nextLine();
            System.out.println("-> telephone :");
            int telephone=sc.nextInt();
            patient =new Patient_adulte(nom,prenom,date_de_naissance,lieu_de_naissance,adresse,diplome,proffession,telephone);
            return patient;
        }
        return null;
    }
}

