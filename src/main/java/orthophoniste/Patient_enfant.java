package orthophoniste;

public class Patient_enfant extends Patient{
    String classe_etude;
    int telephone_parent;

    public void setClasse_etude(String classe_etude) {
        this.classe_etude = classe_etude;
    }

    public void setTelephone_parent(int telephone_parent) {
        this.telephone_parent = telephone_parent;
    }

    public Patient_enfant(){

    }

    public Patient_enfant(String nom, String prenom, String date_de_naissance, String lien_de_naissance, String adresse, String classe_etude, int telephone_parent) {
        super(nom, prenom, date_de_naissance, lien_de_naissance, adresse);
        this.classe_etude = classe_etude;
        this.telephone_parent = telephone_parent;
    }
    public void afficher() {
        System.out.println("nom : "+this.nom+", prenom : "+this.prenom+", adresse : "+this.adresse+", date de naissanec :"+this.date_de_naissance+", lieu de naissance : "+this.lien_de_naissance+", classe d'etude : "+this.classe_etude+", telephone de parent : "+this.telephone_parent);
    }
}
