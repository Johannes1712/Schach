
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
		
		for(int i=0;)
		{
			
		}
		
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
