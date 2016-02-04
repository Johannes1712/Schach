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
		boolean spielzug=true;
		
		if (!super.spielzugMoeglich(sp, von, nach))	return false;

		Figur figurVon = sp.getFigur(von.getX(),von.getY());
		Feld figurNach = sp.getFeld(nach.getX(),nach.getY());
		if(figurNach instanceof Figur)
		{
			if(!((Figur) figurNach).dieselbeFigur(figurVon,(Figur) figurNach))
			{
				return false;
			}	
		}
		

		//rechts unten fahren
		for(int i=1;i<=8;i++)
		{
		
			if(von.getX()+i>=8||von.getY()+i>=8 || von.getX()+i<0 || von.getY()+i<0)
			{
				continue;
			}
			else
			{
				Feld figur=sp.getFeld(von.getX()+i,von.getY()+i);
				if(figur instanceof Figur)
				{
					if(!figur.equals(figurNach))
					{
						break;
					}
					return true;
				}				
			}
			
			if((nach.getX()== von.getX()+i)&&(nach.getY()== von.getY()+i))
			{	
				return true;
			}
		}		
				
		//rechts oben fahren
		for(int i=1;i<=8;i++)
		{
			if(von.getX()-i>=8||von.getY()+i>=8 || von.getX()-i<0 || von.getY()+i<0)
			{
				continue;
			}
			else
			{
				Feld figur=sp.getFeld(von.getX()-i,von.getY()+i);
				if(figur instanceof Figur)
				{
					if(!figur.equals(figurNach))
					{
						break;
					}
					return true;
				}	
			}			
			
			if((nach.getX()== von.getX()-i)&&(nach.getY()== von.getY()+i))
			{					
				return true;
			}
		}
		
		//links oben fahren	
		for(int i=1;i<=8;i++)
		{
			if(von.getX()-i>=8||von.getY()+i>=8 || von.getX()-i<0 || von.getY()-i<0)
			{
				continue;
			}
			else
			{
				Feld figur=sp.getFeld(von.getX()-i,von.getY()-i);
				if(figur instanceof Figur)
				{
					if(!figur.equals(figurNach))
					{
						break;
					}
					return true;
				}	
			}	
			
			if((nach.getX()== von.getX()-i)&&(nach.getY()== von.getY()-i))
			{						
				return true;
			}
		}

		
		//links unten fahren
		for(int i=1;i<=8;i++)
		{
			if(von.getX()+i>=8||von.getY()-i>=8 || von.getX()+i<0 || von.getY()-i<0)
			{
				continue;
			}
			else
			{
				Feld figur=sp.getFeld(von.getX()+i,von.getY()-i);
				if(figur instanceof Figur)
				{
					if(!figur.equals(figurNach))
					{
						break;
					}
					return true;
				}				
			}			
			if((nach.getX()== von.getX()+i)&&(nach.getY()== von.getY()-i))
			{
				return true;
			}
		}	
		

		return false;
	}		
}
