package sample;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class VueIHMFX  {


    Controleur controlleur;
    CommandeTabInt commandeGetEtat;
    ImageView[][] myImage;
    GridPane gridPane = new GridPane();
    int TAILLE=46;

    Image[] sokoban = new Image[]{ new Image(new FileInputStream(
            "Character4.png"),TAILLE,TAILLE,false,false),
            new Image(new FileInputStream(
                    "Crate_Beige.png"),TAILLE,TAILLE,false,false),
            new Image(new FileInputStream(
                    "Ground_Sand.png"),TAILLE,TAILLE,false,false),
            new Image(new FileInputStream(
                    "Wall_Beige.png"),TAILLE,TAILLE,false,false),
            new Image(new FileInputStream(
                    "EndPoint_Red.png"),TAILLE,TAILLE,false,false),
            new Image(new FileInputStream(
                    "Crate_Red.png"),TAILLE,TAILLE,false,false),
            new Image(new FileInputStream(
                    "Character4.png"),TAILLE,TAILLE,false,false)

            };


    public VueIHMFX(Controleur controleur) throws FileNotFoundException  {
        this.controlleur=controleur;
        commandeGetEtat = controleur.commandeGetEtat();
        myImage= new ImageView[commandeGetEtat.exec().length][commandeGetEtat.exec()[0].length];
        for (int i=0;i<commandeGetEtat.exec().length;i++) {
            for (int j=0;j<commandeGetEtat.exec()[0].length;j++) {
                myImage[i][j] = new ImageView();
                myImage[i][j].setFitHeight(20);
                myImage[i][j].setFitWidth(20);

            }
        }
        dessine();
    }
    

    public void dessine() {
    	myImage =new ImageView[commandeGetEtat.exec().length][commandeGetEtat.exec()[0].length];
        for (int i=0;i<commandeGetEtat.exec().length;i++) {
            for (int j=0;j<commandeGetEtat.exec()[0].length;j++) {
                myImage[i][j]=new ImageView(sokoban[commandeGetEtat.exec()[i][j]]);
                gridPane.add(myImage[i][j], j, i);
            }
        }
    }
}
