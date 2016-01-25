
package org.htl.chess.model;

public class Laeufer extends Figur
{
	public Laeufer(boolean farbe) {
		super(farbe);
	}

	private Feld[][] spielfeld;

	public boolean spielZug(Spielfeld sp, Position von, Position nach)
	{
		return super.spielZug(sp, von, nach);
	}

	public boolean spielzugMoeglich(Spielfeld sp, Position von, Position nach)
	{
		int bewegenX = nach.getX() - von.getX();
		int bewegenY = nach.getY() - von.getY();
		int zaehler;
		if (!super.spielzugMoeglich(sp, von, nach))	return false;
		Position pos;
		pos=new Position(0,0);
		
		Figur figurVon = sp.getFigur(von.getX(),von.getY());
		
		if(bewegenX==0||bewegenY==0)
		{
			return false;
		}				
		
		
		if(bewegenY>0)
		{
			for(zaehler=0;zaehler<bewegenY;zaehler++)
			{
				Feld figurNach=sp.getFeld(nach.getX(),nach.getY());
				pos.setX(von.getX()+zaehler);
				pos.setY(von.getY()+zaehler);

				if(figurNach instanceof Figur)
				{
					if(!((Figur) figurNach).dieselbeFigur(figurVon,(Figur) figurNach))
					{
						return false;
					}
				}
			}
			if(zaehler==bewegenY)
			{
				return true;
			}
		}
		else
		{
			for(zaehler=0;zaehler>bewegenY;zaehler--)
			{	
				Feld figurNach = sp.getFeld(nach.getX(), nach.getY());
				pos.setX(von.getX()+zaehler);
				pos.setY(von.getY()+zaehler);
				
				if(figurNach instanceof Figur)
				{
					if(((Figur) figurNach).dieselbeFigur(figurVon,(Figur) figurNach))
					{
						return false;
					}
					else
					{
						return true;
					}
				}
			}
			
			if(zaehler==bewegenY)
			{
				return true;
			}
		}
		return false;
	}
}

