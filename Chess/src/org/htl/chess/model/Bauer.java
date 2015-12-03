package org.htl.chess.model;

public class Bauer extends Figur 
{
	// Spalten sind Buchstaben
	// Zeilen sind Zahlen
	// 0/0  ist links unten auf a1
	// somit die linkeste Spalte 0 und die unterste Zeile 0
	public boolean spielZug(Spielfeld sp, Positions von, Position nach) 
	{
		return (spielZugMoeglich(sp, von, nach));
	}

	public boolean spielZugMoeglich(Spielfeld sp, Position von, Position nach) 
	{
		boolean ersterSpielzug;
		boolean eigener;
		if((sp.mat[von.getX()][von.getY()].farbeWeiss != sp.mat[nach.getX()][nach.getY()].farbeWeiss)||sp.mat[von.getX()][von.getY()]==null)
		{
			if((Figur)sp.[von.getX()][von.getY()] instanceof Bauer)
			{
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
				else 
				{
					eigener = false;
				}

				// Fuer den 1.Spielzug
				if (ersterSpielzug && (von.getY() + 2 == nach.getY() || von.getY() + 1 == nach.getY())) 
				{
					// Fuer die anderen Spielzuege
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
			}
			else
			{
				return false;
			}
			
		}
		else
		{
			return false;
		}
	}
}
