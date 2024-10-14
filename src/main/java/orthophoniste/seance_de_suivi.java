package orthophoniste;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class seance_de_suivi extends Rendez_vous{
    int num_dossier;
    boolean presentiel;
    fiche_de_suivi fiche_suivi;

    public void setNum_dossier(int num_dossier) {
        this.num_dossier = num_dossier;
    }

    public void setPresentiel(boolean presentiel) {
        this.presentiel = presentiel;
    }

    public void setFiche_suivi(fiche_de_suivi fiche_suivi) {
        this.fiche_suivi = fiche_suivi;
    }

    public void setNote(float note) {
        this.note = note;
    }

    float note;
    public seance_de_suivi(){
        this.type="seance de suivi";
    }
    public seance_de_suivi(LocalDate date, String heure, String duree, int num_dossier, boolean presentiel) {
        super(date, heure, duree);
        this.num_dossier = num_dossier;
        this.presentiel = presentiel;
        this.type="seance de suivi";
    }
    public void evaluer(fiche_de_suivi fiche){
        float note;
        float total_note=0;
        for (objectif i :fiche.objectifs){
            System.out.println("donner une pour chaque objectif : ");
            System.out.println("nom d'objectif : "+i.nom);
            System.out.println("type d'objectif : "+i.type);
            System.out.print("note : ");
            Scanner sc =new Scanner(System.in);
            note=sc.nextFloat();
            total_note+=note;
        }
        total_note=total_note/fiche.objectifs.size();
        this.note=total_note;
    }
    public void cree_fiche(fiche_de_suivi fiche){
        List<objectif> objs=new ArrayList<>();
        boolean stop=false;
        Scanner sc=new Scanner(System.in);
        type_objectif[] type =type_objectif.values();
        while (!stop){
            System.out.println("nom d'objectif : ");
            String nom=sc.nextLine();
            System.out.println("type d'objectif : (0:"+type[0]+", 1:"+type[1]+" ,2:"+type[2]+") :");
            int typee=sc.nextInt();
            objectif obj=new objectif(nom,type[typee]);
            objs.add(obj);
        }
        fiche=new fiche_de_suivi(objs);
    }
    public void sauvgarde_fiche(fiche_de_suivi fiche){

    }
    public void afficher(){
        System.out.println("date : "+this.date+", heure : "+this.heure+" ,duree :"+this.duree+" ,num dossuer : "+this.num_dossier+" ,presentiel : "+this.presentiel);
    }
}
