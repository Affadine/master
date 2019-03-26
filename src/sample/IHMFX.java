package sample;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class IHMFX extends Application implements Observateur{

    VueIHMFX vue;
    VueNbCoupIHMFX vueNbCoup;
    VueNbBoxDeplacerIHMFX vueNbBoxDeplacer;

    public void actualise(){
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
            	vue.gridPane.getChildren().clear();
            	vueNbCoup.dessine();
            	vueNbBoxDeplacer.dessine();
                vue.dessine();
            }
        });
    };

    @Override
    public void start(Stage primaryStage) throws Exception{
    	Controleur controleur;
    	Animation animation;
        controleur = Controleur.getControleur();
        animation= Animation.getAnimation();
        animation.facadeModele=controleur.facadeModele;
        animation.gestionNiveau=controleur.gestionNiveau;
        controleur.abonne(this);
        animation.abonne(this);
        vue=new VueIHMFX(controleur);
        ControleurIHMFX controleurIHMFX =new ControleurIHMFX(controleur,animation,vue);
        vueNbCoup=new VueNbCoupIHMFX(controleur);
        vueNbCoup.label.setAlignment(Pos.CENTER);
        vueNbBoxDeplacer = new VueNbBoxDeplacerIHMFX(controleur);
        vueNbBoxDeplacer.label.setAlignment(Pos.CENTER);
        
        vue.gridPane.setAlignment(Pos.CENTER);

        /* montage de la scene */
        MonteurScene monteurScene = new MonteurScene();

        Scene scene = monteurScene.
                setCentre(vue.gridPane).
                ajoutBas(controleurIHMFX.reset).
                ajoutBas(controleurIHMFX.undo).
                ajoutBas(controleurIHMFX.redo).
                ajoutBas(controleurIHMFX.precedent).
                ajoutBas(controleurIHMFX.suivant).
                ajoutBas(vueNbCoup.label).
                ajoutBas(vueNbBoxDeplacer.label).
                ajoutBas(controleurIHMFX.animation).
                setLargeur(800).
                setHauteur(700).
                retourneScene();

        primaryStage.setScene(scene);
        vue.gridPane.setStyle("-fx-background-color:#ECE3CE");

        primaryStage.setTitle("Sokoban");
        primaryStage.show();
    }

    public void lance() {
        launch(new String[]{});
    }
}

