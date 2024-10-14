package orthophoniste;

import java.io.Serializable;

public abstract class questionaire implements Serializable {
    public String enonce;
    public String reponse;
    public void setReponse(String resp){
        this.reponse=resp;
    }
    public void setEnonce(String enonce){
        this.enonce=enonce;
    }

    public String getEnonce() {
        return enonce;
    }

    public String getReponse() {
        return reponse;
    }
}

