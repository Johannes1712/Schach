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
		int bewegenl = 7-von.getY();
		int bewegenr = 0+von.getY();
		int bewegenu = 0+von.getX();
		int bewegeno = 7-von.getX();
		
		int bewegenX= nach.getY()-von.getY();
		int bewegenY= nach.getX()-von.getX();
		
		int zaehler;
		if (!super.spielzugMoeglich(sp, von, nach))	return false;
		Position pos=new Position(0,0);
		
		Figur figurVon = sp.getFigur(von.getX(),von.getY());
		Feld figurNach = sp.getFeld(nach.getX(),nach.getY());
		if(figurNach instanceof Figur)
		{
			if(!((Figur) figurNach).dieselbeFigur(figurVon,(Figur) figurNach))
			{
				return false;
			}	
		}
		if(bewegenX==bewegenY)
		{
			if(bewegeno!=0 && bewegenr!=0)
			{
				int i=0;
				i++;	
				Feld figur=sp.getFeld(von.getX(),von.getY()+1);
				if(figur instanceof Figur)
				{					
					if(figur.equals(figurVon))
					{
						return false;
					}
					else
					{
						return true;
					}
				}
				else
				{
					return true;
				}
			}
			
			if(bewegenl!=0 && bewegeno!=0)
			{
				int zaehlerWerte=(bewegeno/bewegenl)%2;
				int i=0;
				i++;
				Feld figur=sp.getFeld(von.getX(),von.getY()+bewegenl);
				if(figur instanceof Figur)
				{					
					if(figur.equals(figurVon))
					{
						return false;
					}
					else
					{
						return true;
					}
				}
				else
				{
					return true;
				}
			}
		}

		return false;
	}		
}