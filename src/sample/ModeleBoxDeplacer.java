package sample;

import java.util.ArrayList;

public class ModeleBoxDeplacer implements Modele{
	Modele modele;
	int nbBoxDeplacer=0;
	
	public ModeleBoxDeplacer(Modele modele) {
		this.modele=modele;
	}

	public int[][] getEtat() {
		return modele.getEtat();
	}
	
	 public int nbBoxDeplacer(){
	        return nbBoxDeplacer;
	    }

	public boolean move(int pos) {
		boolean a= modele.move(pos);
		if (a==true) nbBoxDeplacer++ ; 
		return a;
		
	}

	public void demove(int pos, boolean caisse) {
		if(nbBoxDeplacer >0) nbBoxDeplacer--;
		modele.demove(pos,caisse);
	}

	public void reset() {
		nbBoxDeplacer=0;
		modele.reset();
		
	}

	public int getX() {
		return modele.getX();
	}

	public int getY() {
		return modele.getY();
	}

	public void setEtat(int[][] etat) {
		modele.setEtat(etat);
		nbBoxDeplacer=0;
		
	}

	@Override
	public ArrayList<Integer> getList() {
		return modele.getList();
	}

}
