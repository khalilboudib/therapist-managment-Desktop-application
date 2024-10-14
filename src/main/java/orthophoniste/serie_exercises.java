package orthophoniste;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class serie_exercises extends Test{
    public List<exercise> exercises ;
    transient Iterator<exercise> iterator;

    public serie_exercises() {
        this.exercises = new ArrayList<>();
        this.type="Series d'exercices";
        resetIterator();
    }

    public void addExo(exercise ex){
        this.exercises.add(ex);
        resetIterator();
    }

    public boolean hasNext() {
        return iterator != null && iterator.hasNext();
    }

    public exercise getNext() {
        if (iterator == null || !iterator.hasNext()) {
            resetIterator(); // Reset iterator to allow re-iteration if necessary
        }
        return iterator.next();
    }

    private void resetIterator() {
        this.iterator = exercises.iterator();
    }


    @Override
    public float calculer_score() {
        float score=0;
        float moy=0;
        for (exercise ex :this.exercises){
            if (Collections.frequency(this.exercises,ex)>1){
                moy=score_moyen((ArrayList<exercise>) this.exercises,ex);
                moy=moy/Collections.frequency(this.exercises,ex);
                score+=moy;
            }else {
                score+=ex.score;
            }
        }
        return score;
    }

    public static float score_moyen(ArrayList<exercise> arr,exercise exercisee){
        float score=0;
        exercise ex;
        int i;
        while (true){
            i=arr.indexOf(exercisee);
            if (i==-1){
                break;
            }
           ex=arr.get(i);
           score+=ex.score;
        }
        return score;
    }
}
