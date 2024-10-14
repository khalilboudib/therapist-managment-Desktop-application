package orthophoniste;

public class Patient_adulte extends Patient{
    String diplome;
    String proffession;
    int telephone;

    public void setDiplome(String diplome) {
        this.diplome = diplome;
    }

    public void setProffession(String proffession) {
        this.proffession = proffession;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }

    public Patient_adulte(){

    }
    public void afficher() {
            System.out.println("nom : "+this.nom+", prenom : "+this.prenom+", adresse : "+this.adresse+", date de naissanec :"+this.date_de_naissance+", lieu de naissance : "+this.lien_de_naissance+", diplome : "+this.diplome+", proffession : "+this.proffession+", telephone : "+this.telephone);
    }

    public Patient_adulte(String nom, String prenom, String date_de_naissance, String lien_de_naissance, String adresse, String diplome, String proffession, int telephone) {
        super(nom, prenom, date_de_naissance, lien_de_naissance, adresse);
        this.diplome = diplome;
        this.proffession = proffession;
        this.telephone = telephone;
    }
}
