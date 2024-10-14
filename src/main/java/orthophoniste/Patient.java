package orthophoniste;

import java.io.Serializable;

public abstract class Patient implements Serializable {
    public String nom;
    public String prenom;
    public String date_de_naissance;
    public String lien_de_naissance;
    public String adresse;
    public int NumDossier;
    public Dossier dossier;
    public Patient(){
        dossier =new Dossier();
    }
    public void setNumDossier(){
        this.NumDossier=this.dossier.numero;
    }
    public int getNumDossier(){
        return this.NumDossier;
    }
    public int getNumDossi(){
        return this.dossier.numero;
    }
    public int getTelephone(){
        int tel=0;
        if (this instanceof Patient_adulte){
            tel=((Patient_adulte) this).telephone;
        } else if (this instanceof Patient_enfant) {
            tel= ((Patient_enfant) this).telephone_parent;
        }
        return tel;
    }
    public String getType(){
        String st="";
        if (this instanceof Patient_adulte){
            st="Adulte";
        } else if (this instanceof Patient_enfant) {
            st="Enfant";
        }
        return st;
    }


    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setDate_de_naissance(String date_de_naissance) {
        this.date_de_naissance = date_de_naissance;
    }

    public void setLien_de_naissance(String lien_de_naissance) {
        this.lien_de_naissance = lien_de_naissance;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getDate_de_naissance() {
        return date_de_naissance;
    }

    public String getLien_de_naissance() {
        return lien_de_naissance;
    }

    public String getAdresse() {
        return adresse;
    }

    public Dossier getDossier() {
        return dossier;
    }

    public Patient(String nom, String prenom, String date_de_naissance, String lien_de_naissance, String adresse){
        this.nom=nom;
        this.prenom=prenom;
        this.date_de_naissance=date_de_naissance;
        this.lien_de_naissance=lien_de_naissance;
        this.adresse=adresse;
        dossier =new Dossier();
    }

    public void setDossier(Dossier dossier){
        this.dossier=dossier;
    }
    public abstract void afficher();
}

