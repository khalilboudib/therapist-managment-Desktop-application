package orthophoniste;

import java.time.LocalDate;

public class consultation extends Premier_Rendez_vous{
    String nom;
    String prenom;
    int age;
    public consultation(){
        this.type="consultation";
    }
    public consultation(LocalDate date, String heure, String duree, String nom, String prenom, int age) {
        super(date, heure, duree);
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
        this.type="consultation";
    }
    public void afficher(){
        System.out.println("date : "+this.date+", heure : "+this.heure+" ,duree :"+this.duree+" ,nom : "+this.nom+" ,prenom : "+this.prenom+" ,age : "+this.age);
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public int getAge() {
        return age;
    }
}
