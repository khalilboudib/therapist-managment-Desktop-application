package orthophoniste;

public class premier_BO extends BO{
    public amnese amne;

    public premier_BO(epreuve epreuves, Diagnostic diagnostic, String projet_the,amnese amne){
        super(epreuves,diagnostic,projet_the);
        this.amne=amne;
    }


}
