package orthophoniste;

import javafx.fxml.FXML;

import java.io.Serializable;
import java.util.*;

public class Application implements Serializable {
    public Orthophoniste orthophoniste;
    public Set<Patient> patients;
    public List<Rendez_vous> rendezVous;
    public amnese_enfant amnese_enfant;
    public amnese_adulte amnese_adulte;
    public List<amnese> anamneses;
    public epreuve epreuve;
    public Diagnostic diagnostic;
    public Application(){
        this.orthophoniste =new Orthophoniste();
        patients =new HashSet<>();
        rendezVous= new ArrayList<>();
        amnese_enfant =new amnese_enfant();
        amnese_adulte =new amnese_adulte();
        anamneses= new ArrayList<>();
        this.epreuve =new epreuve();
        diagnostic=new Diagnostic();
    }


    public void cree_compte(String nom,String prenom,String adresse,String email,String pass,int telephone){
        this.orthophoniste.nom=nom;
        this.orthophoniste.prenom=prenom;
        this.orthophoniste.adresse=adresse;
        this.orthophoniste.email=email;
        this.orthophoniste.mot_de_passe=pass;
        this.orthophoniste.telephone=telephone;
    }

    public boolean Sign_in(){
        Scanner sc =new Scanner(System.in);
        System.out.println("-> e-mail :");
        String email =sc.nextLine();
        System.out.println("-> mot de passe :");
        String mot_de_passe =sc.nextLine();
        if ((this.orthophoniste.email.compareTo(email)==0) && (this.orthophoniste.mot_de_passe.compareTo(mot_de_passe)==0)){
            return true;
        }
        return false;
    }

//    public void programmer_rendezvous(){
//        Scanner sc =new Scanner(System.in);
//        System.out.println("-> date :");
//        String date=sc.nextLine();
//        System.out.println("-> heure :");
//        String heure=sc.nextLine();
//        System.out.println("-> duree :");
//        String duree=sc.nextLine();
//        System.out.println("-> type (0:consultation , 1:seance de suivi , 2:atelier de groupe) :");
//        int type=sc.nextInt();
//        sc.nextLine();
//        if (type==0){
//            System.out.println("-> nom :");
//            String nom=sc.nextLine();
//            System.out.println("-> prenom :");
//            String prenom=sc.nextLine();
//            System.out.println("-> age :");
//            int age=sc.nextInt();
//            rendezVous.add(new consultation(date,heure,duree,nom,prenom,age));
//        } else if (type==1) {
//            System.out.println("-> numero de dossier :");
//            int num=sc.nextInt();
//            System.out.println("-> presentiel/online (0:presentiel , 1:online) :");
//            int bool=sc.nextInt();
//            if (bool==0){
//                rendezVous.add(new seance_de_suivi(date,heure,duree,num,true));
//            } else if (bool==1) {
//                rendezVous.add(new seance_de_suivi(date,heure,duree,num,false));
//            }
//
//        } else if (type==2) {
//            System.out.println("-> thematique :");
//            String thematique=sc.nextLine();
//            System.out.println("-> nombre de patient :");
//            int n=sc.nextInt();
//            Set<Integer> nums_dossier=new HashSet<Integer>();
//            for (int i = 1; i <= n; i++) {
//                System.out.println("-> nums_dossier "+i+" :");
//                nums_dossier.add(sc.nextInt());
//            }
//            rendezVous.add(new atelier_de_groupe(date,heure,duree,thematique,nums_dossier));
//        }
//
//    }
    public void add_que_enfant(String enonce,type_enfant type){
        questionaire_enfant questionaireEnfant=new questionaire_enfant(type);
        questionaireEnfant.setEnonce(enonce);
        amnese_enfant.questionaires.add(questionaireEnfant);
    }
    public void  cree_amnese(){
        Scanner sc=new Scanner(System.in);
            for (type_enfant type :type_enfant.values()){
                questionaire_enfant questionaireEnfant=new questionaire_enfant(type);
                System.out.println("enonce de question de type "+type+" : ");
                String enonce=sc.nextLine();
                questionaireEnfant.setEnonce(enonce);
                amnese_enfant.questionaires.add(questionaireEnfant);
            }
            for (type_adulte typee :type_adulte.values()){
            questionaire_adulte questionaireAdulte=new questionaire_adulte(typee);
            System.out.println("enonce de question de type "+typee+" : ");
            String enonce=sc.nextLine();
            questionaireAdulte.setEnonce(enonce);
            amnese_adulte.questionaires.add(questionaireAdulte);
        }
    }

    public void cree_test(){
        Scanner sc =new Scanner(System.in);
        System.out.println("-------------------cree test-----------------");
        System.out.println("nom de test : ");
        String nom=sc.nextLine();
        System.out.println("capacite de test : ");
        int capacite =sc.nextInt();
        System.out.println("0:simple_questionaire , 1:serie exercises : ");
        int type=sc.nextInt();
        if (type==0){
            simple_questionaire simple_questionaire =new simple_questionaire(nom,capacite);
            System.out.println("nombre des questions : ");
            int n=sc.nextInt();
            sc.nextLine();
            for(int j=1 ; j<=n ; j++) {
                System.out.println("0:question libre ,1:QCM ,2:QCU : ");
                type=sc.nextInt();
                sc.nextLine();
                switch (type) {
                    case 0:
                        System.out.println("enonce :");
                        String enonce = sc.nextLine();
                        question_libre question = new question_libre();
                        question.setEnonce(enonce);
                        simple_questionaire.questions.add(question);
                        break;
                    case 1:
                        System.out.println("enonce :");
                         enonce = sc.nextLine();
                        QCM questionn = new QCM();
                        questionn.setEnonce(enonce);
                        System.out.println("nombre de proposition");
                        type=sc.nextInt();
                        sc.nextLine();
                        for (int i = 1; i <=type ; i++) {
                            System.out.println("reponse propose : ");
                            String propose=sc.nextLine();
                            questionn.add_reponse_propose(propose);
                        }
                        simple_questionaire.questions.add(questionn);
                        break;
                    case 2:
                        System.out.println("enonce :");
                        enonce = sc.nextLine();
                        QCU questionnn = new QCU();
                        questionnn.setEnonce(enonce);
                        System.out.println("nombre de proposition");
                        type=sc.nextInt();
                        sc.nextLine();
                        for (int i = 1; i <=type ; i++) {
                            System.out.println("reponse propose : ");
                            String propose=sc.nextLine();
                            questionnn.add_reponse_propose(propose);
                        }
                        simple_questionaire.questions.add(questionnn);
                        break;
                }
            }
            epreuve.test.add(simple_questionaire);
        }else if (type==1){
            serie_exercises serieExercises=new serie_exercises();
            System.out.println("nombre des exercises : ");
            int n=sc.nextInt();
            sc.nextLine();
            for(int j=1 ; j<=n ; j++){
                System.out.println("consigne : ");
                String consigne =sc.nextLine();
                System.out.println("nom de material : ");
                String nom_material=sc.nextLine();
                exercise exercise=new exercise(consigne,nom_material);
                serieExercises.exercises.add(exercise);
            }
            epreuve.test.add(serieExercises);
        }

    }

    public void start_premier_rendez_vous(consultation rendezVous){
        Patient patient = rendezVous.inscrire_patient();
        Scanner sc=new Scanner(System.in);
        System.out.println("---------------------amnese----------------------");
        if (patient instanceof Patient_enfant){
            for (questionaire_enfant que :amnese_enfant.questionaires){
                System.out.println("type de question : "+que.type);
                System.out.println("enonce : "+que.enonce);
                System.out.println("reponse : ");
                String resp=sc.nextLine();
                que.setReponse(resp);
            }
        } else if (patient instanceof Patient_adulte) {
            for (questionaire_adulte que :amnese_adulte.questionaires){
                System.out.println("type de question : "+que.type);
                System.out.println("enonce : "+que.enonce);
                System.out.println("reponse : ");
                String resp=sc.nextLine();
                que.setReponse(resp);
            }
        }
        System.out.println("----------------------epreuve------------------------");
        for (Test test : epreuve.test){
            if(test instanceof simple_questionaire){
                for (question que :((simple_questionaire) test).questions){
                    if (que instanceof question_libre){
                        System.out.println("enonce : "+que.enonce);
                        System.out.println("reponse : ");
                        String reponse =sc.nextLine();
                        ((question_libre) que).addReponse(reponse);
                    } else if (que instanceof QCU) {
                        System.out.println("enonce : "+que.enonce);
                        for (String rep :((QCU) que).reponse_propose){
                            System.out.println("-> "+rep);
                        }
                        System.out.println("reponse : ");
                        int rep=sc.nextInt();
                        sc.nextLine();
                        ((QCU) que).setReponse(rep);
                    } else if (que instanceof QCM) {
                        System.out.println("enonce : "+que.enonce);
                        for (String rep :((QCM) que).reponse_propose){
                            System.out.println("-> "+rep);
                        }
                        for (int i=1;i<=((QCM) que).reponse_propose.size();i++){
                            int rep=sc.nextInt();
                            sc.nextLine();
                            ((QCM) que).reponses.add(rep);
                        }
                    }
                    System.out.println("score (1-10): ");
                    que.setScore(sc.nextFloat());
                }
            }else if(test instanceof serie_exercises){
                for (exercise ex : ((serie_exercises) test).exercises){
                    System.out.println("consigne :"+ex.consigne);
                    System.out.println("material : "+ex.nom_material);
                    System.out.println("reponse : ");
                    String rep=sc.nextLine();
                    ex.setReponse(rep);
                    float score=sc.nextFloat();
                    ex.setScore(score);
                    sc.nextLine();
                }
            }
            test.setScore_totale(test.calculer_score());
            System.out.println("score totale : "+test.score_totale);
            //test.redige_conclusion();
        }
        System.out.println("------------------diagnostic--------------------");
        while (true){
            System.out.println("categori : "+type_categorie.values());
            System.out.println("categori de trouble :");
            int b=sc.nextInt();
            sc.nextLine();
            System.out.println("nom : ");
            String nom=sc.nextLine();
            if (b==1){
                trouble trouble=new trouble(nom,type_categorie.valueOf("troubles_de_deglutition"));
                diagnostic.addtrouble(trouble);
            } else if (b==2) {
                trouble trouble=new trouble(nom,type_categorie.valueOf("troubles_neuro_dev"));
                diagnostic.addtrouble(trouble);
            } else if (b==3) {
                trouble trouble=new trouble(nom,type_categorie.valueOf("troubles_cognitifs"));
                diagnostic.addtrouble(trouble);
            }
            System.out.println("stop ? (1:yes/0:no)");
            int i=sc.nextInt();
            sc.nextLine();
            if (i==1){
                break;
            }
        }
        System.out.println("-------------------projet therapeutique-----------------");
        System.out.println("-> ");
        String projet_therapeutique=sc.nextLine();
        System.out.println("numero de dossier : ");
        int num =sc.nextInt();
        sc.nextLine();
        patient.dossier=new Dossier(num);
        if (patient instanceof Patient_adulte){
            premier_BO bo=new premier_BO(epreuve,diagnostic,projet_therapeutique,amnese_adulte);
            patient.dossier.addBO(bo);
        }else if (patient instanceof Patient_enfant){
            premier_BO bo=new premier_BO(epreuve,diagnostic,projet_therapeutique,amnese_enfant);
            patient.dossier.addBO(bo);
        }
        patient.dossier.addRendezvous(rendezVous);
        //patients.put(num,patient);
    }

    public void start_rendez_vous(Rendez_vous rendezVous){

    }


    public static void main(String arg[]){
        System.out.println("---------------application-----------------");
        Scanner sc=new Scanner(System.in);
        Application app=new Application();
       // app.cree_compte();
        app.orthophoniste.afficher();
        while (true) {
            boolean bool =app.Sign_in();
            System.out.println(bool);
            if (bool){
                break;
            }
        }
        boolean stop =false;
        while (!stop) {
            System.out.println("--------------------------menu--------------------------");
            System.out.println("1-programmer rendez vous");
            System.out.println("2-afficher les rendez vous ");
            System.out.println("3-premier rendez vous ");
            System.out.println("4-ajouter questionaires amnese ");
            System.out.println("5-ajouter test");
            System.out.println("6-exit");
            System.out.println("-> choice : ");
            int choice =sc.nextInt();
            switch (choice){
                case 1 :
                    //app.programmer_rendezvous();
                    break;
                case 2 :
                    for (Rendez_vous rend : app.rendezVous) {
                        rend.afficher();
                    }
                    break;
                case 3 :
                    app.start_premier_rendez_vous((consultation) app.rendezVous.getFirst());
                    break;
                case 4 :
                    app.cree_amnese();
                    break;
                case 5 :
                    app.cree_test();
                    break;
                case 6 :
                    stop=true;
            }
        }
    }
}
