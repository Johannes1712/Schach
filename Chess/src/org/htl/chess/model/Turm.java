package org.htl.chess.model;

public class Turm extends Figur
{
	public Turm(boolean farbe, boolean bewegt) {
		super(farbe,bewegt);
	}
	public boolean spielzug(Spielfeld sp, Position von, Position nach)
	{
		return super.spielZug(sp, von, nach);
	}
	@SuppressWarnings("unused")
	public boolean spielzugMoeglich(Spielfeld sp, Position von, Position nach)
	{	
		if (!super.spielzugMoeglich(sp, von, nach))	return false;
		
		Figur figurVon = sp.getFigur(von.getX(), von.getY());
		
		/*Feld figur= sp.getFeld(nach.getX(),nach.getY());	
		if(figur instanceof Figur)
		{			
			boolean istGleichesTeam = ((Figur) figur).getFarbeW();
			if(istGleichesTeam == this.getFarbeW())return false;
		}*/
		boolean beobachtet=true;
		
		for(int i=1;i<=8;i++)
		{
			Feld figur= sp.getFeld(von.getY(),von.getX()+i);
			if(figur instanceof Figur)
			{
				if(!figurVon.dieselbeFigur((Figur)figurVon, (Figur)figur))
				{
					break;
				}
				
			}
			if((nach.getX()== von.getX()-i))
			{
				if((nach.getY()== von.getY()))
				{
					return true;
				}
			}
		}
		//runterfahren
		for(int i=1;i<=8;i++)
		{	
			Feld figur= sp.getFeld(von.getY(),von.getX()+i);
			if(figur instanceof Figur)
			{
				if(!figurVon.dieselbeFigur((Figur)figurVon, (Figur)figur))
				{
					break;
				}
			}
			if((nach.getX()== von.getX()+i))
			{
				if(nach.getY()==von.getY())
				{
					return true;
				}
				
			}
			
		}
		
		//rauffahren
		
		//nach rechts fahren
		for(int i=1;i<=8;i++)
		{
			Feld figur= sp.getFeld(von.getY()+1,von.getX());
			if(figur instanceof Figur)
			{			
				boolean istGleichesTeam = ((Figur) figur).getFarbeW();
				if(istGleichesTeam == this.getFarbeW())break;
			}
			if((nach.getX()== von.getX()))
			{
				if((nach.getY()== von.getY()+i))
				{
					return true;
				}
				
			}
		}
		//nach links fahren
		for(int i=1;i<=8;i++)
		{
			Feld figur= sp.getFeld(von.getY()-1,von.getX());
			if(figur instanceof Figur)
			{			
				boolean istGleichesTeam = ((Figur) figur).getFarbeW();
				if(istGleichesTeam == this.getFarbeW())break;
			}
			if((nach.getX()== von.getX()))
			{
				if((nach.getY()== von.getY()-i))
				{
					return true;
				}
			}
		}
		return false;

	
	}
}
