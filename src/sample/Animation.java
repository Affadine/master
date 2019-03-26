package sample;
import java.util.ArrayList;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.util.Duration;

public class Animation implements Sujet{
	 private static Animation animateur;


    public static Animation getAnimation() {
        animateur = new Animation(new FacadeModele());
        return animateur;
    }

    FacadeModele facadeModele;
    GestionNiveau gestionNiveau= new GestionNiveau();
    ArrayList<Observateur> observateurs = new ArrayList<Observateur>();
	
	private Animation(FacadeModele facadeModele) {
        this.facadeModele = facadeModele;
    }
	
	@Override
	public void abonne(Observateur observateur) {
		 observateurs.add(observateur);
		
	}

	@Override
	public void notifie() {
		  for (Observateur observateur:observateurs)
	            observateur.actualise();
		
	}
	
	Timeline timer = new Timeline(new KeyFrame(Duration.seconds(1),
            new EventHandler<ActionEvent>() {
                public void handle(ActionEvent event) {
                	if(facadeModele.getList().size() >0) {
                		facadeModele.move1(facadeModele.getList().get(0));
                		facadeModele.getList().remove(0);
                		notifie();
                
                	}
                    
                }
            }));

	public void animer() {
		if(facadeModele.getList().size() > 0) {
			facadeModele.setEtatIni(gestionNiveau.niveau());
	        facadeModele.ajour();
	        notifie();
			timer.setCycleCount(facadeModele.getList().size());
			timer.play();
			
		}
	}
	
	

}
