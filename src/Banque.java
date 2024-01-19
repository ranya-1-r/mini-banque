import java.util.ArrayList;
import java.util.Scanner;

public class Banque {
    public static ArrayList<Client>clients=new ArrayList<>();
    private int nbcompt;
    public void ajouterClient( String nom){
        this.clients.add(new Client(nom));
        System.out.println("les client "+nom+"est bien ajouter");
    }
    public void interaction(){
        int d;
        Scanner scanner=new Scanner(System.in);
        do{
            System.out.println("*****************Menu Banque*******************");
            System.out.println("Quelle operation voulez-vous effectuer?");
            System.out.println("1) ajouter un client");
            System.out.println("2)Effectuer une operation sur un client");
            System.out.println("3)Qutter le programme");
            d=scanner.nextInt();
            switch (d){
                case 1:{
                    System.out.println("Enter le nom su client");
                    ajouterClient(scanner.next());
                    break;
                }
                case 2:{
                    System.out.println("Quel client");
                    for(int i=0;i<Banque.clients.size();i++) {
                        System.out.println((i + 1) + ")" + Banque.clients.get(i).getNom());
                    }
                    int c=scanner.nextInt();
                    clients.get(c-1).operationclient(c);
                    break;
                }
            }
        }while (d!=3);
    }
}
