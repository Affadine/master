package sample;

import java.util.Scanner;

public class IHMTerminal implements Observateur{
    Controleur controleur;
    Animation animateur;
    Scanner scanner = new Scanner(System.in);

    public void actualise() {
        dessine();
        System.out.print(">");
    }

    void dessine() {
        int[][]etat= controleur.commandeGetEtat().exec();
        for (int i=0; i< etat.length;i++) {
        	for(int j=0; j< etat[i].length;j++) {
        		System.out.print(etat[i][j] + " ");
        	}
        	 System.out.println("");
        }
            
       
    }

    public void lance() {
        controleur = Controleur.getControleur();
        animateur = Animation.getAnimation();
        controleur.abonne(this);
        animateur.abonne(this);
        dessine();
        System.out.print(">");

        boolean fin = false;
        while (!fin) {
            String commande = scanner.next();
            if (commande.equals("f"))
                fin = true;
            else if (commande.equals("r"))
                controleur.reset();
            else
                try {
                    int coup = Integer.parseInt(commande);
                    controleur.move( coup);
                } catch (Exception e) {
                    System.out.print("non!>");
                }
        }
    }
}
