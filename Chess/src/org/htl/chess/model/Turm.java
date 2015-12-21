package org.htl.chess.model;

public class Turm extends Figur{
	boolean rueckgabewert;
	private Feld[ ] [ ] spielfeld;
	private Feld figur;
	
	public boolean spielzug(Spielfeld sp, Position von, Position nach)
	{
		return super.spielZug(sp, von, nach);
	}
	protected boolean spielzugmoeglich(Spielfeld sp, Position von, Position nach)
	{	
		if(!super.spielzugMoeglich(sp, von, nach))return false;
		
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
