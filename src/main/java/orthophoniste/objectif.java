package orthophoniste;

import java.io.Serializable;

public class objectif implements Serializable {
    String nom;
    type_objectif type;
    float note;
    public objectif(){

    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setType(type_objectif type) {
        this.type = type;
    }

    public void setNote(float note) {
        this.note = note;
    }

    public String getNom() {
        return nom;
    }

    public type_objectif getType() {
        return type;
    }

    public float getNote() {
        return note;
    }

    public objectif(String nom, type_objectif type) {
        this.nom = nom;
        this.type = type;
    }
}
