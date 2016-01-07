
package org.htl.chess.model;

public class Laeufer extends Figur
{
	private Feld[][] spielfeld;

	public boolean spielZug(Spielfeld sp, Position von, Position nach)
	{

		return super.spielZug(sp, von, nach);
	}

	public boolean spielZugMoeglich(Spielfeld sp, Position von, Position nach)
	{
		int bewegenX = nach.getX() - von.getX();
		int bewegenY = nach.getY() - von.getY();
		
		if (!super.spielzugMoeglich(sp, von, nach))	return false;

		if (bewegenX !=von.getX()  && bewegenY != von.getY()) 
		{
			//fuer bewegen
			if(bewegenX==0||bewegenY==0)
			{
				return false;
			}
			else
			if ((von.getX() + bewegenX) == nach.getX() && (von.getY() + bewegenY == nach.getY())) 
			{
				return true;
			}
		}
		return false;
	}
}
