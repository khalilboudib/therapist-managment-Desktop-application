package orthophoniste;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class fiche_de_suivi implements Serializable {
    public String nom;
    public List<objectif> objectifs ;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    public fiche_de_suivi(){
        objectifs = new ArrayList<objectif>();
    }
    public fiche_de_suivi(List<objectif> objectifs) {
        this.objectifs = objectifs;
    }
}
