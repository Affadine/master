package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;import javafx.scene.input.KeyCode;

public class ControleurIHMFX {
    Controleur controleur;
    Animation annimation;
    VueIHMFX vue;
    Button reset;
    Button undo;
	Button redo;
	Button suivant;
	Button precedent;
	Button animation;


    public ControleurIHMFX(Controleur controleur,Animation annimation, VueIHMFX vue) {
        this.controleur = controleur;
        this.annimation=annimation;
        this.vue = vue;
        vue.gridPane.setFocusTraversable(true);
        vue.gridPane.setOnKeyPressed(new EventHandler<javafx.scene.input.KeyEvent>() {
            @Override
            public void handle(javafx.scene.input.KeyEvent keyEvent) {
                
                        if(keyEvent.getCode()==KeyCode.DOWN) controleur.move(2);
                        
                        else if(keyEvent.getCode()== KeyCode.UP) controleur.move(8);
                        	
                        else if(keyEvent.getCode()== KeyCode.RIGHT) controleur.move(6);
                        else if(keyEvent.getCode()== KeyCode.LEFT) controleur.move(4);
                   
                        
                    }
        });

        reset = new Button("Reset");
        reset.setFocusTraversable(false);
        reset.setOnAction(new ActionReset());
        undo= new Button("Undo");
        undo.setFocusTraversable(false);
        undo.setOnAction((new ActionUndo()));
        redo=new Button("Redo");
        redo.setFocusTraversable(false);
        redo.setOnAction(new ActionRedo());
        precedent=new Button("Precedent");
        precedent.setFocusTraversable(false);
        precedent.setOnAction(new ActionPrecedent());
        suivant =new Button("Suivant");
        suivant.setFocusTraversable(false);
        suivant.setOnAction(new ActionSuivant());
        animation= new Button("Animation");
        animation.setFocusTraversable(false);
        animation.setOnAction(new ActionAnimation());
    }

    class ActionReset implements EventHandler<ActionEvent> {
        public void handle(ActionEvent event) {
            controleur.reset();
        }

    }

    class ActionUndo implements EventHandler<ActionEvent> {
		public void handle(ActionEvent event) { controleur.undo(); }
    }
    

    class ActionRedo implements EventHandler<ActionEvent> {
		public void handle(ActionEvent event) { controleur.redo(); }
    }

    class ActionPrecedent implements EventHandler<ActionEvent>{
		public void handle(ActionEvent event) {
			controleur.precedent();
		}
    	
    }


	class ActionSuivant implements EventHandler<ActionEvent> {
		public void handle(ActionEvent event) { controleur.suivant();}
	}
	
	class ActionAnimation implements EventHandler<ActionEvent>{
		public void handle(ActionEvent event) {
			annimation.animer();
		}
		
	}

}



