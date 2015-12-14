package org.htl.chess.model;

public class Bauer extends Figur 
{
	// Spalten sind Buchstaben
	// Zeilen sind Zahlen
	// 0/0  ist links unten auf a1
	// somit die linkeste Spalte 0 und die unterste Zeile 0
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
		boolean ersterSpielzug=false;
		boolean eigener;
		Figur figur =(Figur) spielfeld [von.getX()][von.getY()];
		
		if(figur instanceof Figur)
		{
			
			boolean istGleichesTeam = ((Figur) figur).getFarbeWeiss();
			if(istGleichesTeam)return false;
		}
		//Abfrage ob erste Spielzug oder nicht
		if ((von.getY() + 1 == nach.getY()) || (von.getY() + 2 == nach.getY())) 
		{
			if (von.getY() == 1) 
			{
				ersterSpielzug = true;

			}
			else 
			{
				ersterSpielzug = false;
			}
		}

		// Figur den 1.Spielzug
		if (ersterSpielzug && (von.getY() + 2 == nach.getY() || von.getY() + 1 == nach.getY())) 
		{
			// Figur die anderen Spielzuege
			if (ersterSpielzug && (von.getY() + 2 == nach.getY())||(von.getY()+1==nach.getY())) 
			{
				return true;
			}
			else
			{
				if((von.getX()+1==nach.getX()||von.getX()-1==nach.getX())&&von.getY()+1==nach.getY())
				{
					return true;
				}
			}						
		}	
		return false;
	}
}
