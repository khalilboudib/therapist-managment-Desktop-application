package orthophoniste;

import java.util.ArrayList;
import java.util.List;

public class QCU extends question{
    public List<String> reponse_propose;
    int reponse;
    public QCU(){
        reponse_propose=new ArrayList<>();
    }

    public void add_reponse_propose(String reponse_propose){
        this.reponse_propose.add(reponse_propose);
    }

    public void setReponse(int reponse){
        this.reponse=reponse;
    }

    public void setScore(float score){
        this.score=score;
    }

}
