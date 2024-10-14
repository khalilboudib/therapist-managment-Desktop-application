package orthophoniste;

import java.util.ArrayList;
import java.util.List;

public class QCM extends question{
    public List<String> reponse_propose;
    List<Integer> reponses;
    public QCM(){
        reponse_propose=new ArrayList<>();
        reponses=new ArrayList<>();
    }
    public void addAll_reponse(List<Integer> reponse){
        this.reponses=reponse;
    }
    public void affiche_reponse(){
        for (int i :reponses){
            System.out.println(reponse_propose.get(i));
        }
    }
    public void add_reponse_propose(String reponse_propose){
        this.reponse_propose.add(reponse_propose);
    }
    public void add_reponse(int reponse){
        this.reponses.add(reponse);
    }
    public void setScore(float score){
        this.score=score;
    }
}
