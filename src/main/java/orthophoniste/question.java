package orthophoniste;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public abstract class question implements Serializable {
    public String enonce;
    float score;
    public question(){
    }
    public void setEnonce(String enonce){
        this.enonce=enonce;
    }

    public String getEnonce() {
        return enonce;
    }

    public abstract void setScore(float score);
}

