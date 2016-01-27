package org.htl.chess.model;

public class Springer extends Figur
{
	

	public Springer(boolean farbeW) {
		super(farbeW);
	}

	public boolean spielZug(Spielfeld sp, Position von, Position nach)
	{
		return super.spielZug(sp, von, nach);
	}
	
	public boolean spielzugMoeglich(Spielfeld sp, Position von, Position nach)
	{
		
		if(!super.spielzugMoeglich(sp, von, nach))return false;
		
		Feld figur= sp.getFeld(nach.getX(),nach.getY());	
		if(figur instanceof Figur)
		{			
			boolean istGleichesTeam = ((Figur) figur).getFarbeW();
			if(istGleichesTeam == this.getFarbeW())return false;
		}
		
		if((nach.getX()== von.getX()+2)||(nach.getX()== von.getX()-2))
		{
			
			if((nach.getY()== von.getY()+1)||(nach.getY()== von.getY()-1))
			{
				return true;
			}
		}
		if((nach.getY()== von.getY()+2)||(nach.getY()== von.getY()-2))
		{
			
			if((nach.getX()== von.getX()+1)||(nach.getX()== von.getX()-1))
			{
				return true;
			}
		}		
		return false;
	}
}
