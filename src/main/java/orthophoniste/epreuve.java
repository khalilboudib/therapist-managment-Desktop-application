package orthophoniste;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class epreuve implements Serializable {
    public String Observation;
    public List<Test> test;
    transient Iterator<Test> iterator;

    public epreuve() {
        this.test = new ArrayList<>();
        resetIterator();
    }
    public void setObservation(String observation){
        this.Observation=observation;
    }
    public void add_test(Test test){
        this.test.add(test);
        resetIterator();
    }
    public boolean hasNext() {
        return iterator != null && iterator.hasNext();
    }

    public Test getNext() {
        if (iterator == null || !iterator.hasNext()) {
            resetIterator(); // Reset iterator to allow re-iteration if necessary
        }
        return iterator.next();
    }

    private void resetIterator() {
        this.iterator = test.iterator();
    }

}
