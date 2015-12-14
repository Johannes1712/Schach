package org.htl.chess.model;

public class Laeufer extends Figur
{
	private Feld[ ] [ ] spielfeld;
	public boolean spielZug(Spielfeld sp, Position von, Position nach)
	{
			spielfeld=sp.getMat();
			
			if(this.spielZugMoeglich(sp, von, nach))
			{
				sp.spielZugAusfuehren(von, nach, this);
				return true;
			}
			
			return false;
	}

	public boolean spielZugMoeglich(Spielfeld sp, Position von, Position nach) 
	{
		Figur figur =(Figur) spielfeld [von.getX()][von.getY()];
		int bewegenX=nach.getX()-von.getX();
		int bewegenY=nach.getY()-von.getY();
		
		
		//abfragen ob die Figur die eigene ist oder wo die Figur hingesetzt wird
		if(figur instanceof Figur)
		{
			
			boolean istGleichesTeam = ((Figur) figur).getFarbeWeiss();
			if(istGleichesTeam)return false;
		}
		else
		{
			//Abfragen ob die Figur ein Laeufer ist oder nicht
			if(figur instanceof Laeufer)
			{
				if(bewegenX>0 && bewegenY>0)
				{
					//fuer vorwerts bewegen
					if((von.getX()+bewegenX) ==nach.getX() && (von.getY()+bewegenY==nach.getY()))
					{
						return true;
					}
					else
					{
						return false;
					}
				}
				else
				{
					//fuer rueckwerts bewegen
					if((von.getX()-bewegenX) ==nach.getX() && (von.getY()-bewegenY==nach.getY()))
					{
						return true;
					}
					else
					{
						return false;
					}
				}
			}
			else
			{
				return false;
			}
	
		}
		return false;
	}
}
