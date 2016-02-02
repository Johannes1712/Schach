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
	public boolean spielzugMoeglich(Spielfeld sp, Position von, Position nach)
	{	
		int bewegenX = nach.getY() - von.getY();
		int bewegenY = nach.getY() - von.getY();
		int zaehler;
		if(!super.spielzugMoeglich(sp, von, nach))return false;
		
		Feld figur= sp.getFeld(nach.getX(),nach.getY());	
		if(figur instanceof Figur)
		{			
			boolean istGleichesTeam = ((Figur) figur).getFarbeW();
			if(istGleichesTeam == this.getFarbeW())return false;
		}
		
		if((nach.getY()>von.getY()))
		{
			for(zaehler=1;zaehler<=bewegenY;zaehler++)
			{
				Feld figur1=sp.getFeld(von.getX(), von.getY()+zaehler);
			
				if(figur1 instanceof Figur)
				{
					
					if((nach.getY()== von.getY()+zaehler))
					{
						if((Figur)figur1 instanceof Figur)
						{
							if(((Figur) figur1).dieselbeFigur((Figur)figur1,(Figur) figur))
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
		
//		if(figur instanceof Figur)
//		{			
//			boolean istGleichesTeam = ((Figur) figur).getFarbeW();
//			if(istGleichesTeam)return false;
//		}
		
		/*if(nach.getX()>von.getX()||nach.getX()<von.getX())
		{
			for(int i=1;i<=8;i++)
			{
				if((nach.getX()== von.getX()+i)||(nach.getX()== von.getX()-i))
				{
					return true;
				}
				else
				{
					if(!super.spielzugMoeglich(sp, von, nach))return false;
				}
			}
		}*/
		
		if((nach.getY()<von.getY()))
		{	
			for(zaehler=-1;zaehler>(nach.getY()-von.getY());zaehler--)
			{	
				Feld figur1=sp.getFeld(von.getX(), von.getY()+zaehler);
			
				if(figur1 instanceof Figur)
				{
					
					if((nach.getY()== von.getY()+zaehler))
					{
						if((Figur)figur1 instanceof Figur)
						{
							if(((Figur) figur1).dieselbeFigur((Figur)figur1,(Figur) figur))
							{
								return true;
							}
						}
						
					}
					else
					{
						return false;
					}
				}
				
				
			}
			if(zaehler==(nach.getY()-von.getY()))
			{
				return true;
			}
		}
		return false;
		
	}
}
