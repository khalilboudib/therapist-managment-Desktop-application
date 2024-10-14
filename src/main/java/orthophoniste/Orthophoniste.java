package orthophoniste;

import java.io.Serializable;

public class Orthophoniste implements Serializable {
    public String nom;
    public String prenom;
    public String adresse;
    public int telephone;
    public String email;
    public String mot_de_passe;
    public Orthophoniste(){

    }
    public Orthophoniste(String nom,String prenom,String adresse,int telephone,String email,String mot_de_passe){
        this.nom=nom;
        this.prenom=prenom;
        this.adresse=adresse;
        this.telephone=telephone;
        this.email=email;
        this.mot_de_passe=mot_de_passe;
    }
    public void afficher(){
        System.out.println("nom : "+this.nom+", prenom : "+this.prenom+", adresse : "+this.adresse+", telephone :"+this.telephone+", email : "+this.email+", mot de passe : "+this.mot_de_passe);
    }
}
