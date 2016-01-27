package org.htl.chess.model;

public class Figur extends Feld
{
	
	private boolean farbeW;
	private boolean bewegt;
	
	protected Feld[ ] [ ] spielfeld;
	
	public Figur(boolean farbe)
	{
		this.farbeW=farbe;
	}
	
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
		Figur figurVon = figurVon = sp.getFigur(von.getX(),von.getY());
		Figur figurNach = null;
		if(nach.getX()>8 || nach.getY()>8)return false;
		
		if(sp.getFeld(von.getX(),von.getY()) instanceof Figur && sp.getFeld(nach.getX(),nach.getY()) instanceof Figur)
		{			
			figurNach = sp.getFigur(nach.getX(),nach.getY());
		}
		
		if(!this.dieselbeFigur(figurVon,figurNach))return false;
		return true;
	}
	
	public boolean dieselbeFigur(Figur figurVon, Figur figurNach){
		
		if (figurNach instanceof Figur) 
		{
			boolean istGleichesTeamVon= ((Figur)figurVon).getFarbeW();
			boolean istGleichesTeamNach= ((Figur)figurNach).getFarbeW();
			if(istGleichesTeamVon==istGleichesTeamNach) return false;
		}
		return true;
	}
	
	
	public boolean getFarbeW()
	{
		return farbeW;
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