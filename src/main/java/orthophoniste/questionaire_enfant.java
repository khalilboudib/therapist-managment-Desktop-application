package orthophoniste;

public class questionaire_enfant extends questionaire{
    public type_enfant type;
    public questionaire_enfant(type_enfant type){
        this.type=type;
    }

    public type_enfant getType() {
        return type;
    }
    public String getEnonce(){
        return enonce;
    }
}
