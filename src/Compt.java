public class Compt {
  private int numero;
  private float solde;

    public Compt(int numero, float solde) {
        this.numero = numero;
        this.solde = solde;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public float getSolde() {
        return solde;
    }

    public void setSolde(float solde) {
        this.solde = solde;
    }
    public void affichSolde(){
        System.out.println("votre soldes est :"+this.solde);
    }
    public void depot(float valeure) throws Exception{
        if(valeure>0){
            this.solde=this.solde+valeure;
           this.affichSolde();
        }else
            throw new Exception("valeure invalide");
    }
    public void retrait( float valeure) throws Exception{
        if(valeure<this.solde){
            this.solde=this.solde-valeure;
            this.affichSolde();
        }else
            throw new Exception("solde insufisant");
    }
    public void virer(float valeure,Compt distinataire){
       try{
           this.retrait(valeure);
           distinataire.depot(valeure);
       }
       catch (Exception e){
           System.out.println("operation invalide");
       }

    }
}
