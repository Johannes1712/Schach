package org.htl.chess.model;

public class Springer extends Figur{
	

	public boolean spielZug(Spielfeld sp, Position von, Position nach){
		
<<<<<<< HEAD
		spielfeld= sp.getMat();
		
		if(this.spielzugMoeglich(sp,von,nach)){
			
			
			sp.spielzugAusfuehren(von, nach, this );
			return true;
		}
		
		return false;
=======
		return super.spielZug(sp, von, nach);
>>>>>>> branch 'master' of https://github.com/Johannes1712/Schach.git
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
