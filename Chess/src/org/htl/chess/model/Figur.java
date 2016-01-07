package org.htl.chess.model;

public class Figur extends Feld
{
	
	private boolean farbeWeiss;
	private boolean bewegt;
	
	protected Feld[ ] [ ] spielfeld;
	
	public boolean spielZug(Spielfeld sp, Position von, Position nach)
	{
		spielfeld= sp.getMat();	
		if(this.spielzugMoeglich(sp,von,nach))
		{			
			sp.spielzugAusfuehren(von, nach, this );
			return true;
		}
		
		return false;
	}
	
	public boolean spielzugMoeglich(Spielfeld sp, Position von, Position nach)
	{
		if(nach.getX()>8 || nach.getY()>8)return false;
		Figur figurVon = (Figur) spielfeld[von.getX()][von.getY()];
		Figur figurNach = (Figur) spielfeld[nach.getX()][nach.getY()];
		
		if(!this.dieselbeFigur(figurVon,figurNach))return false;
		return true;
	}
	
	public boolean dieselbeFigur(Figur figurVon,Figur figurNach){
		
		if (figurVon instanceof Figur) 
		{
			boolean istGleichesTeamVon = ((Figur) figurVon).getFarbeWeiss();
			boolean istGleichesTeamNach = ((Figur) figurNach).getFarbeWeiss();
			if (istGleichesTeamVon==istGleichesTeamNach)return false;
		}
		return true;
	}
	
	public void setFarbeWeiss(boolean farbeWeiss)
	{
		this.farbeWeiss=farbeWeiss;
	}
	
	public boolean getFarbeWeiss()
	{
		return farbeWeiss;
	}
	
	public void setBewegt(boolean bewegt)
	{
		this.bewegt=bewegt;
	}
	
	public boolean getBewegt()
	{
		return bewegt;
	}

}
