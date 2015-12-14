package org.htl.chess.model;

public class Laeufer 
{
	public boolean spielZug(Spielfeld sp, Positions von, Position nach)
	{
			return spielZugMoeglich();
	}

	public boolean spielZugMoeglich(Spielfeld sp, Position von, Position nach) 
	{
		int bewegenX=nach.getX()-von.getX();
		int bewegenY=nach.getY()-von.getY();
		//abfragen ob die Figur die eigene ist oder wo die Figur hingesetzt wird
		if (sp.mat[von.getX()][von.getY()].farbeWeiss == sp.mat[nach.getX()][nach.getY()].farbeWeiss) 
		{
			return false;
		}
		else
		{
			//Abfragen ob die Figur ein Laeufer ist oder nicht
			if((Figur)sp.[von.getX()][von.getY()] instanceof Laeufer)
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
	}
}
