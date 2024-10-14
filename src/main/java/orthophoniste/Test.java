package orthophoniste;

import java.io.Serializable;
import java.util.*;

public abstract class Test implements Serializable {
    String nom;
    String type;

    public String getType() {
        return this.type;
    }

    int capacite;
    float score_totale;
    String conclusion;
    public void redige_conclusion(String conclusion){
        this.conclusion=conclusion;
    }

    public void setNom(String nom){
        this.nom=nom;
    }

    public int getCapacite() {
        return capacite;
    }

    public String getConclusion() {
        return conclusion;
    }

    public String getNom() {
        return nom;
    }
    public float getScore_totale(){
        return score_totale;
    }

    public void setCapacite(int capacite) {
        this.capacite = capacite;
    }

    public void setScore_totale(float score_totale) {
        this.score_totale = score_totale;
    }

    public abstract float calculer_score();
}

