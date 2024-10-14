package orthophoniste;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class atelier_de_groupe extends Rendez_vous{
    String thematique;
    Set<Integer> nums_dossier;
    public List<Patient> patients;
    public atelier_de_groupe(){
        this.nums_dossier =new HashSet<Integer>();
        this.patients =new ArrayList<>();
        this.type="Atelier de groupe";
    }

    public void setThematique(String thematique) {
        this.thematique = thematique;
    }
    public void addNumDossier(int num){
        this.nums_dossier.add(num);
    }

    public atelier_de_groupe(LocalDate date, String heure, String duree, String thematique, Set<Integer> nums_dossier) {
        super(date, heure, duree);
        this.thematique = thematique;
        this.nums_dossier = nums_dossier;
        this.type="Atelier de groupe";
    }
    public void afficher(){
        System.out.println("date : "+this.date+", heure : "+this.heure+" ,duree :"+this.duree+" ,thematique : "+this.thematique);
    for (int i :this.nums_dossier){
        System.out.println("num dossier : "+i);
    }
    }
}
