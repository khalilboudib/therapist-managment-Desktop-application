package orthophoniste;

public class questionaire_adulte extends questionaire{
    public type_adulte type;

    public questionaire_adulte(type_adulte type) {
        this.type = type;
    }

    public type_adulte getType() {
        return type;
    }
}
