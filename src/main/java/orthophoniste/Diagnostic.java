package orthophoniste;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Diagnostic implements Serializable {
    public List<trouble> troubles ;

    public Diagnostic() {
        this.troubles = new ArrayList<>();
    }
    public void addtrouble(trouble trouble){
        troubles.add(trouble);
    }
}
