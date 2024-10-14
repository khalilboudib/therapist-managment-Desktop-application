package orthophoniste;

import java.io.Serializable;

public class trouble implements Serializable {
    public String nom;
    public type_categorie categorie;

    public String getNom() {
        return nom;
    }

    public type_categorie getCategorie() {
        return categorie;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setCategorie(type_categorie categorie) {
        this.categorie = categorie;
    }

    public trouble(String nom, type_categorie categorie) {
        this.nom = nom;
        this.categorie = categorie;
    }
}
