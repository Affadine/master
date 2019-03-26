package sample;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Dictionnaire {
    BufferedReader reader=null;
    String listeDeToutesLesGrilles;
    Map<Integer,String> map;

    public Dictionnaire() {
        BufferedReader reader = null;
        String line="";
        try {
            reader = new BufferedReader(new FileReader("microCosmos.txt"));
            line = reader.readLine();
            listeDeToutesLesGrilles =line+"\n";
            int nbLigne=0;
            
            while (line!=null) {
                nbLigne++;
                line = reader.readLine();
                listeDeToutesLesGrilles=listeDeToutesLesGrilles+line+"\n";
            }
            
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        } finally {
            try { if (reader!=null) reader.close(); } catch (Exception e) {}
        }
        
    }

  public int tailleDico() {
	  return this.listeDeToutesLesGrilles.length();
  }
  
  
    public String etape(int level) {
        int cpt=0;
        int debut=level-1;
        int fin=level+1;
        int nbreVirgule=0;
        String grille="";
        while(cpt<=this.listeDeToutesLesGrilles.length()) {

            if(nbreVirgule>=debut) {
                int cpt1=0;
                while(cpt1<2 && level > 1) {
                    if(this.listeDeToutesLesGrilles.charAt(cpt) == '\n')
                        cpt1++;
                    cpt++;
                }
                while(nbreVirgule<=fin && listeDeToutesLesGrilles.charAt(cpt) != ';') {
                    grille=grille+listeDeToutesLesGrilles.charAt(cpt);
                    cpt++;
                }
                break;
            }
            cpt++;
            if(nbreVirgule==level)
                return grille;
            if(listeDeToutesLesGrilles.charAt(cpt)==';')
                nbreVirgule++;
        }


        return grille;
    }


    private void initMap(){
        map = new TreeMap<>() ;
        for (int  i=1; i<41 ;i++)
            map.put(i, etape(i));

    }

    public  String getValues(int niveau) {
        return map.get((niveau));
    }
    

	public  void toStringDictionnaire() {
		System.out.println(this.listeDeToutesLesGrilles);
		}
	

}
