package sample;
import java.util.ArrayList;

public class ModeleUndoRedo implements Modele {
	
	Modele modele;
	int nbUndo=0;
	ArrayList<Integer> memoire = new ArrayList<>();
	ArrayList<Integer> memoire_inverse = new ArrayList<>();
	ArrayList<Boolean> box_deplacer = new ArrayList<>();
	ArrayList<Integer> list =new ArrayList<>();
	
	public ModeleUndoRedo(Modele modele) {
		this.modele=modele;
	}
	
	
	
	public int[][] getEtat() {
		return modele.getEtat();
	}
	
	public boolean move(int pos) {
		int indice=getX();
		int j=getY();
		boolean a=modele.move(pos);
		if(getX() !=indice || getY() != j) {
			box_deplacer.add(a);
			list.add(pos);
			switch(pos) {
				case 2:
					memoire.add(8);
					break;
				case 8:
					memoire.add(2);
					break;
				case 4:
					memoire.add(6);
					break;
				case 6:
					memoire.add(4);
					break;
				default:
					break;
			
			}
		}
		return a;
		
	}
	
	public boolean move1(int pos) {
		int indice=getX();
		int j=getY();
		boolean a=modele.move(pos);
		if(getX() !=indice || getY() != j) {
			box_deplacer.add(a);
			switch(pos) {
				case 2:
					memoire.add(8);
					break;
				case 8:
					memoire.add(2);
					break;
				case 4:
					memoire.add(6);
					break;
				case 6:
					memoire.add(4);
					break;
				default:
					break;
			
			}
		}
		return a;
		
	}
	
	public void demove(int pos, boolean caisse) {
		modele.demove(pos,caisse);
		
	}
	
	public void undo() {
		if(memoire.size() > 0 && box_deplacer.size() >0) {
			modele.demove(memoire.get(memoire.size()-1),box_deplacer.get(box_deplacer.size()-1));
			switch(memoire.get(memoire.size()-1)) {
				case 2:
					memoire_inverse.add(8);
					break;
				case 8:
					memoire_inverse.add(2);
					break;
				case 4:
					memoire_inverse.add(6);
					break;
				case 6:
					memoire_inverse.add(4);
					break;
				default:
					break;
			}
			box_deplacer.remove(box_deplacer.size()-1);
			memoire.remove(memoire.size()-1);
			
		}
		
	}
	
	public void redo() {
		if(memoire_inverse.size() >0) {
            modele.move(memoire_inverse.get(memoire_inverse.size()-1));
			memoire_inverse.remove(memoire_inverse.size()-1);
		}
	}
	
	@Override
	public void reset() {
		memoire=new ArrayList<>();
		memoire_inverse=new ArrayList<>();
		box_deplacer =new ArrayList<>();
		modele.reset();
	}
	@Override
	public int getX() {
		return modele.getX();
	}
	@Override
	public int getY() {
		return modele.getY();
	}



	@Override
	public void setEtat(int[][] etat) {
		modele.setEtat(etat);
	}


	public ArrayList<Integer> getList() {
		return list;
	}
	

}
