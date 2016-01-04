package org.htl.chess.model;

public class Bauer extends Figur 
{
	// Spalten sind Buchstaben
	// Zeilen sind Zahlen
	// 0/0 ist links unten auf a1
	// somit die linkeste Spalte 0 und die unterste Zeile 0
	private Feld[][] spielfeld;

	public boolean spielZug(Spielfeld sp, Position von, Position nach) 
	{
		return super.spielZug(sp, von, nach);
	}

	public boolean spielZugMoeglich(Spielfeld sp, Position von, Position nach) 
	{
		boolean ersterSpielzug = false;
		boolean farbeSchwarz=false;

		Figur figurVon = (Figur) spielfeld[von.getX()][von.getY()];
		Figur figurNach = (Figur) spielfeld[nach.getX()][nach.getY()];

		if (!super.spielzugMoeglich(sp, von, nach))	return false;

		// abfragen ob es dieselbe Figur ist
		if (figurVon instanceof Figur) 
		{
			boolean istGleichesTeamVon = ((Figur) figurVon).getFarbeWeiss();
			boolean istGleichesTeamNach = ((Figur) figurNach).getFarbeWeiss();
			if (istGleichesTeamVon==istGleichesTeamNach)return false;
		}
		if(((Figur) figurVon).getFarbeWeiss())
		{
			farbeSchwarz	= false;
		}
		else
		{
			farbeSchwarz	= true;
		}
	
		
		// Abfrage ob erste Spielzug der Farbe weiß
		if(!farbeSchwarz)
		{
			if(((Figur) figurVon).getBewegt())
			{
				if ((von.getX() + 1 == nach.getX() || von.getX() - 1 == nach.getX()) && von.getY() + 1 == nach.getY()) 
				{
					return true;
				}
			}
			else
			{
				if (ersterSpielzug && (von.getY() + 2 == nach.getY()) || (von.getY() + 1 == nach.getY())) 
				{
					return true;
				}
			}
		}
		
		//Für Farbe schwarz 
		if(farbeSchwarz)
		{
			if(((Figur) figurVon).getBewegt())
			{
				if ((von.getX() - 1 == nach.getX() || von.getX() +1 == nach.getX()) && von.getY() - 1 == nach.getY()) 
				{
					return true;
				}
			}
			else
			{
				if (ersterSpielzug && (von.getY()- 2 == nach.getY()) || (von.getY() - 1 == nach.getY())) 
				{
					return true;
				}
			}
		}
		
		
		/*
		 * if(nach.getY()==7){
		 * 
		 * }
		 */
		return false;
	}
}
