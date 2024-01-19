import java.util.ArrayList;
import java.util.Scanner;

public class Client {
    private String nom;
    private int nbcompts;
    ArrayList<Compt> compts = new ArrayList<>();

    public Client(String nom) {
        this.nom = nom;
        Compt compt = new Compt(1, 0);
        compts.add(compt);
    }

    public Client(String nom, int nbcompts, ArrayList<Compt> compts) {
        this.nom = nom;
        this.nbcompts = nbcompts;
        this.compts = compts;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getNbcompts() {
        return nbcompts;
    }

    public void setNbcompts(int nbcompts) {
        this.nbcompts = nbcompts;
    }

    public ArrayList<Compt> getCompts() {
        return compts;
    }

    public void setCompts(ArrayList<Compt> compts) {
        this.compts = compts;
    }
    public void ajouteCompte(Compt compt){
        if(compts.size()<=10){
            compts.add(compt);
        }
    }
    public float soldeTotale(){
       float soldetotale=0;
       for(int i=0;i<compts.size();i++){
           soldetotale+=compts.get(i).getSolde();
       }return soldetotale;
    }
    public void bilancli(){
        for(int i=0;i<compts.size();i++)
            System.out.println("le sode du compte numero  " +(i+1)+"  est de  "+compts.get(i).getSolde());
    }
    public void operationclient(int x){
        Scanner scanner=new Scanner(System.in);
        Client client=Banque.clients.get(x-1);
        int i1 = 0;
        do{

            System.out.println("******************* Menu client**********************");
            System.out.println("Quelle operation voullez-vous effectuer sur le client "+client.getNom());
            System.out.println("1)Afficher bilan");
            System.out.println("2)Faire un retrait");
            System.out.println("3)Faire un depot");
            System.out.println("4)Faire un virement");
            System.out.println("5)Revenir au minu Banque");
            i1=scanner.nextInt();
            switch (i1){
                case 1:{
                    client.bilancli();
                    break;
                }
                case 2:{
                    System.out.println("Quelle est le montant voulez vous retirer");
                    float montant=scanner.nextFloat();
                    try{
                        client.compts.get(0).retrait(montant);
                    }catch (Exception e){
                        System.out.println("solde insufisant");
                        break;
                    }
                }
                case 3:{
                    System.out.println("Quelle est le montant voulez vous deposer");
                    float montant=scanner.nextFloat();
                    try{
                        client.compts.get(0).depot(montant);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                }
                case 4:{
                    System.out.println("a quelle?");
                    for(int i =0;i<Banque.clients.size();i++) {
                        System.out.println((i + 1) + " ) " + Banque.clients.get(i).getNom());
                    }
                    int a=scanner.nextInt();
                    Client distinataire=Banque.clients.get(a-1);
                    System.out.println("quell est le montant voulez vous virer");
                    float montant=scanner.nextFloat();
                    client.compts.get(0).virer(montant,distinataire.compts.get(0));
                }
            }
        }
        while (i1 != 5);
    }
}