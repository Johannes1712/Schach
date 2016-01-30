package org.htl.chess.model;

import Testing.SpielFeldIO;

public class Bauer extends Figur 
{
	public Bauer(boolean farbe) {
		super(farbe);
	}

	// Spalten sind Buchstaben
	// Zeilen sind Zahlen
	// 0/0 ist links unten auf a1
	// somit die linkeste Spalte 0 und die unterste Zeile 0
	private Feld[][] spielfeld;

	public boolean spielZug(Spielfeld sp, Position von, Position nach) 
	{
		return super.spielZug(sp, von, nach);
	}

	public boolean spielzugMoeglich(Spielfeld sp, Position von, Position nach) 
	{
		if (!super.spielzugMoeglich(sp, von, nach))return false;
	
		boolean farbeSchwarz=false;
		int bewegenX = nach.getX() - von.getX();
		int bewegenY = nach.getY() - von.getY();
		
		Figur figurVon = sp.getFigur(von.getX(),von.getY()); 
		Feld figurNach=sp.getFeld(nach.getX(),nach.getY());
		
		if(figurVon instanceof Figur && figurNach instanceof Figur)
		{
			if(figurVon.dieselbeFigur((Figur)figurNach, figurVon)) return false;
		}
		
		//abfragen welche Farbe die Figur hat
		if(((Figur) figurVon).getFarbeW()==false)
		{
			farbeSchwarz	= true;
		}
		else
		{
			farbeSchwarz	= false;
		}
		
		//Für Farbe weiß
		if(farbeSchwarz)
		{ 
			// Abfrage ob erste Spielzug der Farbe weiß
			if(((Figur) figurVon).getBewegt())
			{
				if((bewegenX==1||bewegenX==-1||bewegenX==0) && bewegenY==1)
				{
					if(figurNach instanceof Figur)
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
					if(bewegenX==0 && bewegenY==1)
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
				if(bewegenX==1||bewegenX==-1)
				{
					if(bewegenY==2||bewegenY==1)
					{
						if(figurNach instanceof Figur)
						{
							((Figur) figurVon).setBewegt(true);
							return true;
						}
					
					}
				}
				else
				{
					if(bewegenX==0)
					{
						if(bewegenY==2||bewegenY==1)
						{
							((Figur) figurVon).setBewegt(true);
							return true;
						}
					}
				}
			}
		}
		
		//Für Farbe schwarz 
		if(!farbeSchwarz)
		{
			// Abfrage ob erste Spielzug der Farbe schwarz
			if(((Figur) figurVon).getBewegt())
			{			
				if((bewegenX==1||bewegenX==-1) && bewegenY==-1)
				{
					if(figurNach instanceof Figur)
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
					if(bewegenX==0 && bewegenY==-1)
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
				if(bewegenX==1||bewegenX==-1)
				{
					if(bewegenY==-2||bewegenY==-1)
					{
						if(figurNach instanceof Figur)
						{
							((Figur) figurVon).setBewegt(true);
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
					if(bewegenX==0)
					{
						if(bewegenY==-2||bewegenY==-1)
						{
							((Figur) figurVon).setBewegt(true);
							return true;
						}
					}
					return false;
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
