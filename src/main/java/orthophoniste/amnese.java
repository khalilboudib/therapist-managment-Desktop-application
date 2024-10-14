package orthophoniste;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class amnese implements Serializable {
    String nom;
    String type;

    public String getType() {
        return type;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }
}

