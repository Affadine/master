package sample;

public class Fichier {
    Dictionnaire map;
    String p ;
    char [] figure;
    int [][] tableau;

    Fichier(int level){
        map=new Dictionnaire();
        p=map.etape(level);
        tableau = new int [tailleL()][tailleC()];
        tableau = Etat(veritableEtat(etat_()));
    }
    
    public void initEtat(){
        char []etat =new char [p.length()];
        for(int i=0;i<p.length();i++) {
            etat[i]=p.charAt(i);
        }
        figure=etat;
    }


    public  void afficherTab() {
        for(int i=0;i<figure.length;i++)
            System.out.println(figure[i]);
    }

    public int tailleL() {
        int cpt=0;
        for(int i=0;i<p.length();i++) {
            if(p.charAt(i)=='\n')
                cpt=cpt+1;
        }
        return cpt;
    }

    public int tailleC() {
        int cpt=0;
        int max=0;
        for(int i=0;i<p.length();i++) {
            if(p.charAt(i)=='\n')
                cpt=0;
            else
                cpt=cpt+1;
            if(max<cpt)
                max=cpt;

        }
        return max;
    }

  
    public int [][] etat_(){
        int ligne=tailleL();
        int colonne=tailleC();
        int cpt=0;
        int j=0;
        int i=0;
        char charc=' ';
        int [][] etat=new int [ligne][colonne];
        cpt=0;
       // System.out.println("a "+ligne+" ligne et "+colonne+" Colonne");
        do {
            while(p.charAt(cpt)!='\n') {
                charc=p.charAt(cpt);
                switch (charc) {
                    case '@':
                        etat[i][j]=1;
                        break;

                    case '$':

                        etat[i][j]=2;
                        break;

                    case ' ':
                    	etat[i][j]=3;
                        break;

                    case '#':
                        etat[i][j]=4;
                        break;

                    case '.':
                        etat[i][j]=5;
                        break;

                    case '*':
                        etat[i][j]=6;
                        break;

                    case '+':
                        etat[i][j]=7;
                        break;


                    default:
                        System.out.println(" error");
                        break;
                }
                cpt=cpt+1;
                j=j+1;
            }
            cpt=cpt+1;
            j=0;
            i=i+1;
        }while(i!=ligne);
       return etat;
    }

    
    public int[][] veritableEtat(int [][] tableau){
        int [][]etat=etat_();
        for(int i=0;i< tableau.length;i++ ) {
            for(int j=0;j<tableau[i].length;j++){
                if(tableau[i][j]==0)
                    etat[i][j]=3;
                else
                    etat[i][j]=tableau[i][j];
            }
        }
        return etat;
        
    }

    
    public int[][] Etat(int [][] tableau){
        int [][]etat=veritableEtat(tableau);
        for(int i=0;i< tableau.length;i++ ) {
            for(int j=0;j<tableau[i].length;j++){
                etat[i][j]=tableau[i][j]-1;
            }
        }
        return etat;
       
    }
    
    public void toStringEtat() {
    	for(int i=0; i< this.tableau.length;i++) {
    		for(int j=0;j<tableau[i].length;j++) {
    			System.out.print(tableau[i][j]);
    		}
    		System.out.println();
    	}
    }
    

}



