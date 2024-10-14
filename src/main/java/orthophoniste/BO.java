package orthophoniste;

import java.io.Serializable;

public class BO implements Serializable {
    public epreuve epreuves;
    public Diagnostic diagnostic;
    public String projet_the;
    public String nom;
    static int n=1;

    public String getNom(){
        return nom;
    }

    public BO(epreuve epreuves, Diagnostic diagnostic, String projet_the) {
        this.epreuves = epreuves;
        this.diagnostic = diagnostic;
        this.projet_the = projet_the;
        this.nom="BO"+n;
        n++;
    }

}
