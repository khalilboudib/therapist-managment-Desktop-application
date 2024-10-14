package orthophoniste;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Dossier implements Serializable {
    int numero;
    public List<Rendez_vous> rendezVous ;
    public List<BO> BOs ;
    public List<fiche_de_suivi> fiches_Des_Suivi;


    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Dossier(){
        this.rendezVous=new ArrayList<>();
        this.BOs= new ArrayList<>();
        this.fiches_Des_Suivi= new ArrayList<>();
    }

    public Dossier(int numero) {
        this.numero = numero;
        this.rendezVous=new ArrayList<>();
        this.BOs= new ArrayList<>();
        this.fiches_Des_Suivi= new ArrayList<>();

    }
    public void addRendezvous(Rendez_vous rendezVous){
        this.rendezVous.add(rendezVous);
    }
    public void addBO(BO bo){
        this.BOs.add(bo);
    }
    public void addFichesuivi(fiche_de_suivi fiche_de_suivi){
        this.fiches_Des_Suivi.add(fiche_de_suivi);
    }
}
