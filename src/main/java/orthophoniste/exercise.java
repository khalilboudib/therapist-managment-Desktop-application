package orthophoniste;

import java.io.Serializable;

public class exercise implements Serializable {

    String consigne;
    String nom_material;
    float score;
    String reponse;
    public String getConsigne() {
        return consigne;
    }

    public String getNom_material() {
        return nom_material;
    }

    public exercise(String consigne, String nom_material) {
        this.consigne = consigne;
        this.nom_material = nom_material;
    }
    public void setReponse(String reponse){
        this.reponse=reponse;
    }
    public void setScore(float score){
        this.score=score;
    }
}
