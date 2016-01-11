
package org.htl.chess.model;
	
public class Dame extends Figur
{
	boolean rueckgabewert=false;
	private Feld[ ] [ ] spielfeld;
	private Feld figur;
	
	public boolean spielZug(Spielfeld sp, Position von, Position nach)
	{
		return super.spielZug(sp, von, nach, this);
	}
	
	protected boolean spielzugmoeglich(Spielfeld sp, Position von, Position nach)
	{	
		if(super.spielzugMoeglich(sp, von, nach)==false)return false;
		
		if(spielfeld[nach.getX()][nach.getY()]!=spielfeld[von.getX()][von.getY()])
		{
			rueckgabewert= true;
		}
		else return false;
		
		if(rueckgabewert) figur=spielfeld[nach.getX()][nach.getY()];
		
		if(spielfeld[nach.getX()][nach.getY()] instanceof Figur)
		{
			boolean istGleichesTeam = ((Figur) figur).getFarbeWeiss();
			if(istGleichesTeam)return false;
		}
		return rueckgabewert;
	}
}
