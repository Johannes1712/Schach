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
		boolean farbeSchwarz=false;
		
		int bewegenX = nach.getX() - von.getX();
		int bewegenY = nach.getY() - von.getY();
		
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
		
	
		
		//abfragen welche Farbe die Figur hat
		if(((Figur) figurVon).getFarbeWeiss())
		{
			farbeSchwarz	= false;
		}
		else
		{
			farbeSchwarz	= true;
		}
		
		//Für Farbe weiß
		if(!farbeSchwarz)
		{ 
			// Abfrage ob erste Spielzug der Farbe weiß
			if(((Figur) figurVon).getBewegt())
			{
				if((bewegenX==1||bewegenX==-1||bewegenX==0) && bewegenY==1)
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
				if(bewegenX==0||bewegenX==1||bewegenX==-1)
				{
					if(bewegenY==2||bewegenY==1)
					{
						((Figur) figurVon).setBewegt(true);
						return true;
					}
				}				
			}
		}
		
		//Für Farbe schwarz 
		if(farbeSchwarz)
		{
			// Abfrage ob erste Spielzug der Farbe schwarz
			if(((Figur) figurVon).getBewegt())
			{			
				if((bewegenX==1||bewegenX==-1||bewegenX==0) && bewegenY==-1)
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
				if(bewegenX==0||bewegenX==1||bewegenX==-1)
				{
					if(bewegenY==-2||bewegenY==-1)
					{
						((Figur) figurVon).setBewegt(true);
						return true;
					}
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
