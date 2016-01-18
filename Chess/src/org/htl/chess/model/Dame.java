
package org.htl.chess.model;
	
public class Dame extends Figur
{
	public Dame(boolean farbe) {
		super(farbe);
	}

	boolean rueckgabewert=false;
	private Feld[ ] [ ] spielfeld;
	private Feld figur;
	
	public boolean spielZug(Spielfeld sp, Position von, Position nach)
	{
		return super.spielZug(sp, von, nach);
	}
	
	public boolean spielzugMoeglich(Spielfeld sp, Position von, Position nach)
	{	
		if(!super.spielzugMoeglich(sp, von, nach))return false;
		
		if(spielfeld[nach.getX()][nach.getY()]!=spielfeld[von.getX()][von.getY()])
		{
			rueckgabewert= true;
		}
		else return false;
		
		if(nach.getX()>von.getX()||nach.getY()>von.getY())
		{
			
			int xkoord;
			int ykoord;
			
			for(xkoord=von.getX();xkoord<=nach.getX();xkoord++)
			{
				for(ykoord=von.getY();ykoord<=nach.getY();ykoord++)
				{
					if(spielfeld[xkoord][ykoord]==spielfeld[von.getX()][von.getY()])
					{
						return false;
					}
				}
			}
		}
		else
		{
			int xkoord;
			int ykoord;
			
			for(xkoord=nach.getX();xkoord<=von.getX();xkoord++)
			{
				for(ykoord=nach.getY();ykoord<=von.getY();ykoord++)
				{
					if(spielfeld[xkoord][ykoord]==spielfeld[von.getX()][von.getY()])
					{
						return false;
					}
				}
			}
		}
		
		if(spielfeld[nach.getX()][nach.getY()] instanceof Figur)
		{
			boolean istGleichesTeam = ((Figur) figur).getFarbeW();
			if(istGleichesTeam)return false;
		}
		return rueckgabewert;
	}
}
