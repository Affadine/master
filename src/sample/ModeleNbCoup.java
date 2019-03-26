package sample;

import java.util.ArrayList;

public class ModeleNbCoup implements Modele {
    Modele modele;
    int nbCoup =0;
    int niveau=1;
    int [][] etat;
    public ModeleNbCoup(ModeleConcret modele) {
        this.modele = modele;
    }

    public int nbCoup(){
        return nbCoup;
    }
  
    public boolean move(int pos) {
        nbCoup++;
        return modele.move(pos);
    }
    public void reset(){
        nbCoup=0;
        modele.reset();
    }

	public int[][] getEtat() {
		return modele.getEtat();
	}

	public int getX() {
		return modele.getX();
	}
	
	public int getY() {
		return modele.getY();
	}

	public void demove(int pos, boolean caisse) {
		nbCoup--;
		modele.demove( pos,caisse);
		
	}
	
	public void setEtat(int[][] etat) {
		modele.setEtat(etat);
		nbCoup=0;
	}

	public ArrayList<Integer> getList() {
		return modele.getList();
	}


}