package sample;

import javafx.scene.control.Label;

public class VueNbCoupIHMFX  {
    Controleur controleur;
    Label label = new Label("NbCoup");
    CommandeInt commande;

    public VueNbCoupIHMFX(Controleur controleur) {
        this.controleur=controleur;
        commande = controleur.commandeNbCoup();
    }

    public void dessine() {
        label.setText(commande.exec()+"");
    }
}
