package orthophoniste;

public class question_libre extends question{
    public String reponse;
    public void setScore(float score){
        this.score=score;
    }
    public void addReponse(String reponse){
        this.reponse=reponse;
    }
}
