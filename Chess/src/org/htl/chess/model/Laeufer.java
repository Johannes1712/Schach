
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

	public boolean spielZugMoeglich(Spielfeld sp, Position von, Position nach)
	{
		int bewegenX = nach.getX() - von.getX();
		int bewegenY = nach.getY() - von.getY();
		int zaehler;
		
		if (!super.spielzugMoeglich(sp, von, nach))	return false;
		Position pos;
		pos=new Position();

		if(bewegenX==0||bewegenY==0)
		{
			return false;
		}				
		
		if(!(bewegenY==bewegenX||bewegenY==0-bewegenX||0-bewegenY==bewegenX))
		{
			return false;
		}
		
		if(bewegenY>0)
		{
			for(zaehler=0;zaehler<bewegenY;zaehler++)
			{
				Figur figurNach=null;
				if(spielfeld[von.getX()][von.getY()] instanceof Figur)
				{
					figurNach = (Figur) spielfeld[nach.getX()][nach.getY()];
				}
				pos.setX(von.getX()+zaehler);
				pos.setY(von.getY()+zaehler);
				
				if (super.spielzugMoeglich(sp, von ,pos))
				{
					continue;
				}
				else
				{
					if(figurNach instanceof Figur)
					{
						return false;
					}
				}
			}
			
			if(zaehler==bewegenY)
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
			for(zaehler=0;zaehler>bewegenY;zaehler--)
			{	
				Figur figurNach = (Figur) spielfeld[nach.getX()][nach.getY()];
				pos.setX(von.getX()+zaehler);
				pos.setY(von.getY()+zaehler);
				
				if (super.spielzugMoeglich(sp, von ,pos))
				{
					continue;
				}
				else
				{
					if(figurNach instanceof Figur)
					{
						return false;
					}
				}
			}
			
			if(zaehler==bewegenY)
			{
				return true;
			}
			else
			{
				return false;
			}
		}
	}
}

