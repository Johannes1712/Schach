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
		if(!super.spielzugMoeglich(sp, von, nach))return false;
		
		Figur figurVon = sp.getFigur(von.getX(), von.getY());
		Feld figurNach = sp.getFeld(nach.getX(),nach.getY());
		if(figurNach instanceof Figur)
		{
			if(!((Figur) figurNach).dieselbeFigur(figurVon,(Figur) figurNach))
			{
				return false;
			}	
		}
		//runterfahren
		if(von.getX()<7)
		{
			for(int i=1;i<=8;i++)
			{
				if(von.getX()+i>=8||von.getX()+i<0)
				{
					continue;
				}
				else
				{
					Feld figur=sp.getFeld(von.getX()+i,von.getY());
					if(figur instanceof Figur)
					{
						if(!figur.equals(figurNach))
						{
							break;
						}
						return true;
					}				
				}	
				
				if((nach.getX()== von.getX()+i))
				{
					if(nach.getY()==von.getY())
					{
						return true;
					}	
				}			
			}
		}
		
		
		//rauffahren
		if(von.getX()>0)
		{
			for(int i=1;i<=8;i++)
			{
				if(von.getX()-i>=8||von.getX()-i<0)
				{
					continue;
				}
				else
				{
					Feld figur=sp.getFeld(von.getX()-i,von.getY());
					if(figur instanceof Figur)
					{
						if(!figur.equals(figurNach))
						{
							break;
						}
						return true;
					}				
				}	
				if((nach.getX()== von.getX()-i))
				{
					if((nach.getY()== von.getY()))
					{
						return true;
					}
				}
			}
		}
		//nach rechts fahren
		if(von.getY()<7)
		{
			for(int i=1;i<=8;i++)
			{
				if(von.getY()+i>=8||von.getY()+i<0)
				{
					continue;
				}
				else
				{
					Feld figur=sp.getFeld(von.getX(),von.getY()+i);
					if(figur instanceof Figur)
					{
						if(!figur.equals(figurNach))
						{
							break;
						}
						return true;
					}				
				}	
				if((nach.getX()== von.getX()))
				{
					if((nach.getY()== von.getY()+i))
					{
						return true;
					}
					
				}
			}
		}
		
		//nach links fahren
		if(von.getY()>0)
		{
			for(int i=1;i<=8;i++)
			{
				if(von.getY()-i>=8||von.getY()-i<0)
				{
					continue;
				}
				else
				{
					Feld figur=sp.getFeld(von.getX(),von.getY()-i);
					if(figur instanceof Figur)
					{
						if(!figur.equals(figurNach))
						{
							break;
						}
						return true;
					}				
				}	
				if((nach.getX()== von.getX()))
				{
					if((nach.getY()== von.getY()-i))
					{
						return true;
					}
				}
			}
		}
		return false;	
	}
}
