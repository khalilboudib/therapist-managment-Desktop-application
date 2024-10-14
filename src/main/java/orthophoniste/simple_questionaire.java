package orthophoniste;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

public class simple_questionaire extends Test{
    public Set<question> questions;
    transient Iterator<question> iterator;

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        question question = (question) o;
//        return Objects.equals(enonce, ((orthophoniste.question) question).enonce);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(enonce);
//    }



    public simple_questionaire(){
        questions =new HashSet<>();
        this.type="Simple questionnaire";
        resetIterator();
    }

    public simple_questionaire(String nom,int capacite) {
        this.nom=nom;
        this.capacite=capacite;
        questions =new HashSet<>();
    }

    public boolean hasNext() {
        return iterator != null && iterator.hasNext();
    }

    public question getNext() {
        if (iterator == null || !iterator.hasNext()) {
            resetIterator(); // Reset iterator to allow re-iteration if necessary
        }
        return iterator.next();
    }

    private void resetIterator() {
        this.iterator = questions.iterator();
    }

    public void add_question(question question){
        this.questions.add(question);
        resetIterator();
    }

    @Override
    public float calculer_score() {
        float score=0;
        for (question que :questions){
            score+=que.score;
        }
        return score;
    }
}
