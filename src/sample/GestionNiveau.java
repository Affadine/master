package sample;

public class GestionNiveau {
		
		int niveau=1;
		Fichier fic =new Fichier(niveau);
	    int[][] etat =fic.tableau;

		public int[][] suivant() {
			this.niveau = niveau < 40 ? niveau+1 :1;
			Fichier f =new Fichier(niveau);
			return f.tableau;
		}
		
		public int [][] niveau(){
			Fichier fic =new Fichier(niveau);
			return fic.tableau;
		}

		public int[][] precedent() {
			niveau=(niveau > 1) ? niveau-1:40;
			Fichier f =new Fichier(niveau);
			return f.tableau;
		}

		
}
