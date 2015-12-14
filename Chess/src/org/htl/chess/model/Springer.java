package org.htl.chess.model;

public class Springer extends Figur{
	
	private Feld[ ] [ ] spielfeld;
	
	public boolean spielZug(Spielfeld sp, Position von, Position nach){
		
		spielfeld= sp.getMat();
		
		if(this.spielzugMoeglich(sp,von,nach)){
			
			sp.spielzugAusführen(von, nach, this );
			return true;
		}
		
		return false;
	}
	
	public boolean spielzugMoeglich(Spielfeld sp, Position von, Position nach){
		
		Feld figur= spielfeld [nach.getX()][nach.getY()];
		if(figur instanceof Figur){
			
			boolean istGleichesTeam = ((Figur) figur).getFarbeWeiss();
			if(istGleichesTeam)return false;
		}
		
		if((nach.getX()== von.getX()+2)||(nach.getX()== von.getX()-2)){
			
			if((nach.getY()== von.getY()+1)||(nach.getY()== von.getY()-1)){
				return true;
			}
		}
		if((nach.getY()== von.getY()+2)||(nach.getY()== von.getY()-2)){
			
			if((nach.getX()== von.getX()+1)||(nach.getX()== von.getX()-1)){
				return true;
			}
		}
		
		return false;
		
	}

}
