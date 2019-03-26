package sample;

import javafx.scene.control.Label;

public class VueNbBoxDeplacerIHMFX {
	Controleur controleur;
    Label label = new Label("NbBoxDeplacer");
    CommandeInt commande;

    public VueNbBoxDeplacerIHMFX(Controleur controleur) {
        this.controleur=controleur;
        commande = controleur.commandeNbBoxDeplacer();
    }

    public void dessine() {
        label.setText(commande.exec()+"");
    }
}
