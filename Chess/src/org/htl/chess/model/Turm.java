package org.htl.chess.model;

public class Turm extends Figur
{
	public Turm(boolean farbe, boolean bewegt) {
		super(farbe,bewegt);
	}
	public boolean spielzug(Spielfeld sp, Position von, Position nach)
	{
		return super.spielZug(sp, von, nach);
	}
	@SuppressWarnings("unused")
	public boolean spielzugMoeglich(Spielfeld sp, Position von, Position nach)
	{	
		int bewegenX = nach.getY() - von.getY();
		int bewegenY = nach.getX() - von.getX();
		int zaehler=1;
		Position pos=new Position(0,0);
		
		Figur figurVon = sp.getFigur(von.getX(), von.getY()); 
		Feld figurNach=sp.getFeld(nach.getX(), nach.getY());
		
		if(figurVon instanceof Figur && figurNach instanceof Figur)
		{
			if(!figurVon.dieselbeFigur((Figur)figurNach, figurVon)) return false;
		}
		
		//Bei links unten fuer hinauf fahren und für Rechts oben zum hinunter fahren?
		if(von.getY()==nach.getY())
		{
			for(zaehler=0;zaehler<8;zaehler++)
			{				
				Feld figur1=sp.getFeld(von.getY()+zaehler,von.getX());
				if(!figurVon.dieselbeFigur((Figur)figur1, figurVon))
				{
					return false;
				}
				else
				{
					if(figur1 instanceof Figur)
					{						
						return true;
					}
				}
			}		
		}
		
		//geht nicht ??
		if(von.getY()==nach.getY())
		{
			for(zaehler=7;zaehler>0;zaehler--)
			{
				Feld figur1=sp.getFeld(von.getY()+zaehler, von.getX());
				if(!figurVon.dieselbeFigur((Figur)figur1, figurVon))
				{
					return false;
				}
				else
				{
					if(figur1 instanceof Figur)
					{						
						return true;
					}
				}
			}
		}
		
		//fuer links unten nach rechts fahren
		if(von.getX()==nach.getX())
		{
			for(zaehler=0;zaehler<8;zaehler++)
			{				
				Feld figur1=sp.getFeld(von.getY(),von.getX()+zaehler);
				if(!figurVon.dieselbeFigur((Figur)figur1, figurVon))
				{
					
					return false;
				}
				else
				{
					if(figur1 instanceof Figur)
					{						
						return true;
					}					
				}
			}		
		}
		
		//für rechst oben nach links fahren warum nicht rechts unten auch??
		if(von.getX()==nach.getX())
		{
			for(zaehler=7;zaehler>0;zaehler--)
			{
				Feld figur1=sp.getFeld(von.getY(), von.getX()+zaehler);
				if(!figurVon.dieselbeFigur((Figur)figur1, figurVon))
				{
					return false;
				}
				else
				{
					if(figur1 instanceof Figur)
					{						
						return true;
					}
				}
			}
		}
		return false;
	}
}
