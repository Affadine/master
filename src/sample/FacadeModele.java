package sample;

import java.util.ArrayList;

public class FacadeModele {
	int niveau=1;
	Fichier fic =new Fichier(niveau);
    int[][] etat =fic.tableau;
    ModeleConcret modeleConcret=new ModeleConcret(etat);
	ModeleNbCoup modeleNbCoup =new ModeleNbCoup(modeleConcret);
	ModeleBoxDeplacer modeleBoxDeplacer= new ModeleBoxDeplacer(modeleNbCoup);
	ModeleUndoRedo modele =new ModeleUndoRedo(modeleBoxDeplacer);

    public void move(int pos) {
        modele.move(pos);
    }

    public void reset() {
    	 modele.list=new ArrayList <>();
    	 modele.reset();
    }
    
    public void ajour() {
   	 modele.reset();
   }

    public void undo(){modele.undo();}

    public int[][]  getEtat() {
        return  modeleBoxDeplacer.getEtat();
    }

    public void  setEtat(int[][] etat) {
    	 modele.setEtat(etat);
    	 modele.list=new ArrayList <>();
    }

    public int getX(){
        return   modele.getX();
    }

    public  int getY(){
        return   modele.getY();
    }

	public int nbCoup() {
		return modeleNbCoup.nbCoup();
	}

	public void redo() {
		 modele.redo();
		
	}

	public int nbBoxDeplacer() {
		return modeleBoxDeplacer.nbBoxDeplacer();
	}

	public void setEtatIni(int[][] etatIni) {
		modeleConcret.setEtatIni(etatIni);
	}

	public ArrayList<Integer> getList() {
		return modele.getList();
		
	}
	
	 public void move1(int pos) {
	        modele.move1(pos);
	    }
	
}
