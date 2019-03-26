package sample;

import java.util.ArrayList;

public interface Modele {
    public int[][] getEtat();
    
    public boolean move(int pos);
    
    public void demove(int pos, boolean caisse);
    
    public void reset();
    
    public int getX();
    
    public int getY();
    
    public void setEtat(int[][] etat);
    
    public ArrayList<Integer> getList();

}
