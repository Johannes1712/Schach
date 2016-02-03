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
		if (!super.spielzugMoeglich(sp, von, nach))	return false;
		
		Figur figurVon = sp.getFigur(von.getX(), von.getY());
		
		
		int zaehler=1;
		
		boolean beobachtet=true;;
		
		//runterfahren
		for(int i=1;i<=8;i++)
		{	
			if((nach.getX()== von.getX()+i))
			{
				if(nach.getY()==von.getY())
				{
					return true;
				}
				
			}
		}
		
		//rauffahren
		for(int i=1;i<=8;i++)
		{
			if((nach.getX()== von.getX()-i))
			{
				
				//Feld figur1=sp.getFeld(von.getY(),von.getX()-i);
				if((nach.getY()== von.getY()))
				{
					return true;
				}
			}
		}
		//nach rechts fahren
		for(int i=1;i<=8;i++)
		{
			if((nach.getX()== von.getX()))
			{
				//Feld figur1=sp.getFeld(von.getY()+i,von.getX());
				if((nach.getY()== von.getY()+i))
				{
					return true;
				}
				
			}
		}
		//nach links fahren
		for(int i=1;i<=8;i++)
		{
			if((nach.getX()== von.getX()))
			{
				if((nach.getY()== von.getY()-i))
				{
					return true;
				}
			}
		}
		//rechts unten fahren
		for(int i=1;i<=8;i++)
		{
			if((nach.getX()== von.getX()+i))
			{
				if((nach.getY()== von.getY()+i))
				{
					return true;
				}	
				
			}
		}
		//rechts oben fahren
		for(int i=1;i<=8;i++)
		{
			if((nach.getX()== von.getX()-i))
			{
				
				if((nach.getY()== von.getY()+i))
				{
					return true;
				}
			}
		}
		//links oben fahren
		for(int i=1;i<=8;i++)
		{
			if((nach.getX()== von.getX()-i))
			{
				
				if((nach.getY()== von.getY()-i))
				{
					return true;
				}
			}
		}
		//links unten fahren
		for(int i=1;i<=8;i++)
		{
			if((nach.getX()== von.getX()+i))
			{
				
				if((nach.getY()== von.getY()-i))
				{
					return true;
				}
			}
		}
		/*for(int i=-1;i>=(von.getY()-nach.getY());i--)
		{
			if((nach.getX()== von.getX()+i)||(nach.getX()== von.getX()-i))
			{
				
				if((nach.getY()== von.getY()+i)||(nach.getY()== von.getY()-i))
				{
					return true;
				}
			}
		}
		*/
		
		/*if(von.getY()==nach.getY())
		{
			for(zaehler=0;zaehler<7;zaehler++)
			{				
				System.out.println("hallo");
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
		if(nach.getY()==von.getY())
		{
			for(zaehler=8;zaehler>=1;zaehler--)
			{
				Feld figur1=sp.getFeld(von.getY()-zaehler, von.getX());
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
		}*/
		//geht nicht ??
		
		
		//fuer links unten nach rechts fahren
		/*if(nach.getX()==von.getX())
		{
			for(int i=1;i<=8;i++)
			{
				Feld figur1=sp.getFeld(von.getY(),von.getX()+i);
				if(!figurVon.dieselbeFigur((Figur)figur1, figurVon))
				{
					return true;
				}
				else
				{
					if(figur1 instanceof Figur)
					{						
						return true;
					}
				}
			}
		}*/
		
		/*if((nach.getY()<von.getY()))
		{	
			for(zaehler=-1;zaehler>(nach.getY()-von.getY());zaehler--)
			{	
				Feld figur1=sp.getFeld(von.getX(), von.getY()+zaehler);
			
				if(figur1 instanceof Figur)
			for(zaehler=0;zaehler<8;zaehler++)
			{				
				Feld figur2=sp.getFeld(von.getY(),von.getX()+zaehler);
				if(!figurVon.dieselbeFigur((Figur)figur2, figurVon))
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
		}*/
		
		//für rechst oben nach links fahren warum nicht rechts unten auch??
		/*if(von.getX()==nach.getX())
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
		}*/
		return false;

	
	}
}
