
package org.htl.chess.model;
	
public class Dame extends Figur {
	boolean rueckgabewert;
	private Feld[ ] [ ] spielfeld;
	
	public boolean spielZug(Spielfeld sp, Position von, Position nach)
	{
		return super.spielZug(sp, von, nach);
	}
	
	protected boolean spielzugmoeglich(Spielfeld sp, Position von, Position nach)
	{
		
		Feld figur=spielfeld[nach.getX()][nach.getY()];
		
		if(super.spielzugMoeglich(sp, von, nach)==false)return false;
		
		if((nach.getX()<=7)&&(nach.getY()<=7))
		{
			rueckgabewert=true;
		}
		else return false;
		
		if(spielfeld[nach.getX()][nach.getY()]!=spielfeld[von.getX()][von.getY()])
		{
			rueckgabewert= true;
		}
		else return false;
		
		if(spielfeld[nach.getX()][nach.getY()] instanceof Figur)
		{
			boolean istGleichesTeam = ((Figur) figur).getFarbeWeiss();
			if(istGleichesTeam)return false;
		}
		
		return rueckgabewert;
	}
}
