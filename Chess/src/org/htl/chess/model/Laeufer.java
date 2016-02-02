package org.htl.chess.model;

public class Laeufer extends Figur
{
	public Laeufer(boolean farbe, boolean bewegt) {
		super(farbe,bewegt);
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
		Feld figurNach=sp.getFeld(nach.getX(),nach.getY());
		
		if(bewegenX==0||bewegenY==0)
		{
			return false;
		}				
		
		if(figurNach instanceof Figur)
		{
			if(!((Figur) figurNach).dieselbeFigur(figurVon,(Figur) figurNach))
			{
				return false;
			}	
		}

		if(bewegenY>0)
		{
			
			for(zaehler=1;zaehler<bewegenY;zaehler++)
			{
				pos.setX(von.getX()+zaehler);
				pos.setY(von.getY()+zaehler);
				Feld figur=sp.getFeld(pos.getX(), pos.getY());
				
				if(figur instanceof Figur)
				{

					if(pos.getY()==nach.getY()&&pos.getX()==nach.getX())
					{
						if((Figur)figur instanceof Figur)
						{
							if(((Figur) figur).dieselbeFigur((Figur)figur,(Figur) figurNach))
							{
								return true;
							}
						}
						else
						{
							return true;
						}

					}					
					else
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
			for(zaehler=-1;zaehler>bewegenY;zaehler--)
			{					
				pos.setX(von.getX()+zaehler);
				pos.setY(von.getY()+zaehler);
				Feld figur=sp.getFeld(pos.getX(), pos.getY());
				if(figur instanceof Figur)
				{

					if(pos.getY()==nach.getY()&&pos.getX()==nach.getX())
					{
						if(((Figur) figur).dieselbeFigur((Figur)figur,(Figur) figurNach))
						{
							return true;
						}
					}					
					else
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
		return false;
	}
}

