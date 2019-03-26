package sample;

import java.util.ArrayList;

public class ModeleConcret implements Modele {
	Modele modele;
    int[][] etat ;
    int [][] etatIni;
    		
    ModeleConcret(int[][] etat) {
    	this.etat = etat;
    }
    
    public void setEtat(int[][] etat) {
    	this.etat = etat;
    }
    
    public int[][] getEtat() {
        return etat;
    }
    
    

    public boolean move(int pos) {
    		int i=getX();
    		int j=getY();
    		if(pos ==2) {
    			return move_down_up(i,j,1);
    		}
    		
    		else if (pos == 8) {
    			return move_down_up(i,j,-1);
    		}
    		
    		else if (pos ==4 ) {
    			return move_right_left(i,j,-1);
    		}
    			
    		else if (pos == 6) {
    			return move_right_left(i,j,1);
    		}
    		return false;
    			
    }
    
    public  void demove( int pos,boolean caisse) {
    	int i=getX();
		int j=getY();
    	if (pos ==2 ) {
    		demove_down_up(i,j,-1,caisse);
    	}
    	else if (pos == 8) {
			demove_down_up(i,j,1,caisse);
		}
		
		else if (pos ==4 ) {
			demove_right_left(i,j,1,caisse);
		}
			
		else if (pos == 6) {
			demove_right_left(i,j,-1,caisse);
		}
    }
    
	public void demove_down_up(int i, int j, int c, boolean caisse) {
			if ((etat[i][j])==0 || (etat[i][j])==6 && caisse==true) {
		    		if(etat[i+c][j]==1 ) {
		    				if(etat[i-c][j]==2) etat[i-c][j]=0;
		    				else if(etat[i-c][j]==4) etat[i-c][j]=6;
		    				if(etat[i][j]==6) etat[i][j]=5;
		    				else if(etat[i][j]==0) etat[i][j]=1;
		    				etat[i+c][j]=2;
		    		}
		    		else if(etat[i+c][j] ==5 && caisse==true ) {
		    			if (etat[i-c][j]==2) etat[i-c][j]=0;
		    			else if(etat[i-c][j]== 6) etat[i-c][j]=6;
	    				if(etat[i][j]==6) etat[i][j]= 5;
	    				else if(etat[i][j]==0) etat[i][j]= 1;
	    				etat[i+c][j]=4;
					}
		    		else{
		    			move_down_up(i,j,-c);
		    			
		    		}
		    		
			}
		
		
	}

	public void demove_right_left(int i ,int j,int c,boolean caisse) {
			if ((etat[i][j])==0 || (etat[i][j])==6 && caisse==true) {
		    		if(etat[i][j+c]==1 ) {
		    			if (etat[i][j-c]==2) etat[i][j-c]=0;
		    			else if(etat[i][j-c]== 4) etat[i][j-c]=6;
		    			if (etat[i][j]==6) etat[i][j]=5;
		    			else if(etat[i][j]==0) etat[i][j]=1;
		    			etat[i][j+c]=2;
		    		}
		    		else if(etat[i][j+c] ==5 && caisse==true) {
		    			if (etat[i][j-c]==2) etat[i][j-c]=0;
		    			else if(etat[i][j-c]== 4) etat[i][j-c]=6;
		    			if (etat[i][j]==6) etat[i][j]=5;
		    			else if(etat[i][j]==0) etat[i][j]=1;
						etat[i][j+c]= 4;
					}
		    		else {
		    			move_right_left(i,j,-c);
		    		}
			}
					
	    	
	}
	
	public boolean move_right_left(int i ,int j,int c) {
		int cpt= etat[i][j];
		if ((etat[i][j])==0 || (etat[i][j])==6) {
	    		if(etat[i][j+c]==1) {
					if(etat[i][j+2*c]==2) {
						if(cpt ==0) {
							etat[i][j]=2;
						}
						else if(cpt ==6) {
							etat[i][j]=4;
						}
						
						etat[i][j+c]=0;
						etat[i][j+2*c]=1;
						return true;
					}
					else if(etat[i][j+2*c] ==4) {
						if(cpt ==0) {
							etat[i][j]=2;
						}
						else if(cpt ==6) {
							etat[i][j]=4;
						}
						 etat[i][j+c]=0;
						 etat[i][j+2*c]=5;
						 return true;
					}
	    		}
				else if(etat[i][j+c]==2) {
					if(cpt ==0) {
						etat[i][j]=2;
					}
					else if(cpt ==6) {
						etat[i][j]=4;
					}
					etat[i][j+c]=0;
					return false;
				}
				else if (etat[i][j+c]==4) {
					if(cpt ==0) {
						etat[i][j]=2;
					}
					else if(cpt ==6) {
						etat[i][j]=4;
					}
					etat[i][j+c]=6;
					return true;
				}
				else if (etat[i][j+c]==5) {
					if(etat[i][j+2*c]==2) {
						if(cpt ==0) {
							etat[i][j]=2;
						}
						else if(cpt ==6) {
							etat[i][j]=4;
						}
						etat[i][j+c]=6;
						etat[i][j+2*c]=1;
						return true;
					}
					else if(etat[i][j+2*c] ==4) {
						if(cpt ==0) {
							etat[i][j]=2;
						}
						else if(cpt ==6) {
							etat[i][j]=4;
						}
						 etat[i][j+c]=cpt;
						 etat[i][j+2*c]=5;
						 return true;
					}
				}
			}
			return false;
	    	
	}

	public boolean move_down_up(int i,int j, int c) {
		int cpt= etat[i][j];
		if ((etat[i][j])==0 || (etat[i][j])==6) {
	    		if(etat[i+c][j]==1) {
					if(etat[i+2*c][j]==2) {
						if(cpt ==0) {
							etat[i][j]=2;
						}
						else if(cpt ==6) {
							etat[i][j]=4;
						}
						
						etat[i+c][j]=0;
						etat[i+2*c][j]=1;
						return true;
					}
					else if(etat[i+2*c][j] ==4) {
						System.out.println("111111");
						if(cpt ==0) {
							etat[i][j]=2;
						}
						else if(cpt ==6) {
							etat[i][j]=4;
						}
						 etat[i+c][j]=0;
						 etat[i+2*c][j]=5;
						 return true;
					}
	    		}
				else if(etat[i+c][j]==2) {
					if(cpt ==0) {
						etat[i][j]=2;
					}
					else if(cpt ==6) {
						etat[i][j]=4;
					}
					etat[i+c][j]=0;
					return false;
				}
				else if (etat[i+c][j]==4) {
					if(cpt ==0) {
						etat[i][j]=2;
					}
					else if(cpt ==6) {
						etat[i][j]=4;
					}
					etat[i+c][j]=6;
					return false;
				}
				else if (etat[i+c][j]==5) {
					if(etat[i+2*c][j]==2) {
						if(cpt ==0) {
							etat[i][j]=2;
						}
						else if(cpt ==6) {
							etat[i][j]=4;
						}
						etat[i+c][j]=6;
						etat[i+2*c][j]=1;
						return true;
					}
					else if(etat[i+2*c][j] ==4) {
						if(cpt ==0) {
							etat[i][j]=2;
						}
						else if(cpt ==6) {
							etat[i][j]=4;
						}
						 etat[i+c][j]=cpt;
						 etat[i+2*c][j]=5;
						 return true;
					}
				}
		}
		return false;
	}

    @Override
    public void reset() {
        etat =etatIni;
    }
    
	@Override
	public int getX() {
		for(int i=0;i<=this.etat.length-1;i++){
			for(int j=0;j<=this.etat[i].length-1;j++){
				if(etat[i][j]==0 || etat[i][j]==6){
					return i;
				}
			}
		}
		return -1;
	}

	@Override
	public int getY() {
		for(int i=0;i<=this.etat.length-1;i++){
			for(int j=0;j<=this.etat[i].length-1;j++){
				if(etat[i][j]==0 || etat[i][j]==6){
					return j;
				}
			}
		}
		return -1;

	}

	public void setEtatIni(int[][] etatIni) {
		this.etatIni=etatIni;
		
	}

	@Override
	public ArrayList<Integer> getList() {
		return modele.getList();
	}

}
