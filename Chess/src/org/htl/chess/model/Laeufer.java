
package org.htl.chess.model;

public class Laeufer extends Figur {
	private Feld[][] spielfeld;

	public boolean spielZug(Spielfeld sp, Position von, Position nach) {

		return super.spielZug(sp, von, nach);
	}

	public boolean spielZugMoeglich(Spielfeld sp, Position von, Position nach) {
		Feld figur = spielfeld[nach.getX()][nach.getY()];
		boolean rueckgabewert;
		int bewegenX = nach.getX() - von.getX();
		int bewegenY = nach.getY() - von.getY();
		
		
		if((nach.getX()<=7)&&(nach.getY()<=7))
		{
			rueckgabewert=true;
		}
		else return false;
		
		if(!super.spielzugMoeglich(sp, von, nach))return false;
		
		// abfragen ob die Figur die eigene ist 
		if (figur instanceof Figur) {
			boolean istGleichesTeam = ((Figur) figur).getFarbeWeiss();
			if (istGleichesTeam)
				return false;
		}

		// Abfragen ob die Figur ein Laeufer ist oder nicht
		if (bewegenX > 0 && bewegenY > 0) {
			// fuer vorwerts bewegen
			if ((von.getX() + bewegenX) == nach.getX() && (von.getY() + bewegenY == nach.getY())) {
				rueckgabewert= true;
			}
		} else {
			// fuer rueckwerts bewegen
			if ((von.getX() - bewegenX) == nach.getX() && (von.getY() - bewegenY == nach.getY())) {
				rueckgabewert= true;
			}

		}
		return rueckgabewert;
	}
}
