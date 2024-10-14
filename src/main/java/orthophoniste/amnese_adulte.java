package orthophoniste;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class amnese_adulte extends amnese{
    public Set<questionaire_adulte> questionaires;
    transient Iterator<questionaire_adulte> iterator;
    public amnese_adulte(){
        this.questionaires=new HashSet<>();
        this.type="Anamnese Adulte";
        resetIterator();
    }
    public void add_questionaire(questionaire_adulte questionaire){
        this.questionaires.add(questionaire);
        resetIterator();
    }

    public boolean hasNext() {
        //Iterator<questionaire_adulte> iterator = questionaires.iterator();
        return iterator != null && iterator.hasNext();
    }

    public questionaire_adulte getNext() {
        //Iterator<questionaire_adulte> iterator = questionaires.iterator();
        if (iterator == null || !iterator.hasNext()) {
            resetIterator(); // Reset iterator to allow re-iteration if necessary
        }
        return iterator.next();
    }
    private void resetIterator() {
        this.iterator = questionaires.iterator();
    }
}
