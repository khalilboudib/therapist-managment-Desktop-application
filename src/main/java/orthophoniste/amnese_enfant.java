package orthophoniste;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class amnese_enfant extends amnese{
    public Set<questionaire_enfant> questionaires;
    transient Iterator<questionaire_enfant> iterator;
    public amnese_enfant(){
        this.questionaires=new HashSet<>();
        this.type="Anamnese Enfant";
        resetIterator();
    }
    public void add_questionaire(questionaire_enfant questionaire){
        this.questionaires.add(questionaire);
        resetIterator();
    }

    public boolean hasNext() {
        //Iterator<questionaire_enfant> iterator = questionaires.iterator();
        return iterator != null && iterator.hasNext();
    }

    public questionaire_enfant getNext() {
        //Iterator<questionaire_enfant> iterator = questionaires.iterator();
        if (iterator == null || !iterator.hasNext()) {
            resetIterator(); // Reset iterator to allow re-iteration if necessary
        }
        return iterator.next();
    }
    private void resetIterator() {
        this.iterator = questionaires.iterator();
    }
}
