package sample;
import java.util.ArrayList;

public class Controleur implements Sujet {
    private static Controleur singleton;


    public static Controleur getControleur() {
        if (singleton == null)
            singleton = new Controleur(new FacadeModele());
        return singleton;
    }

    FacadeModele facadeModele;
    GestionNiveau gestionNiveau= new GestionNiveau();
    ArrayList<Observateur> observateurs = new ArrayList<Observateur>();

    private Controleur(FacadeModele facadeModele) {
        this.facadeModele = facadeModele;
    }

    public void abonne(Observateur observateur) {
        observateurs.add(observateur);
    }

    @Override
    public void notifie() {
        for (Observateur observateur:observateurs)
            observateur.actualise();
    }

    public void move(int pos ) {
        facadeModele.move(pos);
        notifie();
    }

    public void reset() {
        facadeModele.setEtatIni(gestionNiveau.niveau());
        facadeModele.reset();
        notifie();
    }

    public void undo() {
        facadeModele.undo();
        notifie();
    }

    public int getX() {
    	notifie();
    	return facadeModele.getX();
    }
    
    public int getY() {
    	notifie();
    	return facadeModele.getY();
    }

    public CommandeTabInt commandeGetEtat() {
        return new CommandeTabInt() {
            @Override
            public int[][] exec() {
                return facadeModele.getEtat();
            }
        };
    }

	public CommandeInt commandeNbCoup() {
		return new CommandeInt() {
			public int exec() {
				return facadeModele.nbCoup();
			}
		};
	}

	public void redo() {
		facadeModele.redo();
		notifie();
	}

	public void suivant() {
		facadeModele.setEtat(gestionNiveau.suivant());
		notifie();
		
	}

	public void precedent() {
		facadeModele.setEtat(gestionNiveau.precedent());
		notifie();
		
	}


	public CommandeInt commandeNbBoxDeplacer() {
		return new CommandeInt() {
			public int exec() {
				return facadeModele.nbBoxDeplacer();
			}
		};
	}


}
