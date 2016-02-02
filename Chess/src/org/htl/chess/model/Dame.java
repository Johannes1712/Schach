
package org.htl.chess.model;
	
public class Dame extends Figur
{
	public Dame(boolean farbe, boolean bewegt) {
		super(farbe,bewegt);
	}
	
	public boolean spielZug(Spielfeld sp, Position von, Position nach)
	{
		return super.spielZug(sp, von, nach);
	}
	
	public boolean spielzugMoeglich(Spielfeld sp, Position von, Position nach)
	{	
		
		System.out.println("hallo");		
		if(!super.spielzugMoeglich(sp, von, nach))return false;
		
		Feld figur= sp.getFeld(nach.getX(),nach.getY());	
		
		
		for(int i=1;i<=8;i++)
		{
			if((nach.getX()== von.getX()+i)||(nach.getX()== von.getX()-i))
			{
				
				if((nach.getY()== von.getY()+i)||(nach.getY()== von.getY()-i))
				{
					return true;
				}
			}
		}
		/*if(nach.getX()>von.getX()||nach.getX()<von.getX())
		{
			for(int i=1;i<=8;i++)
			{
				if((nach.getX()== von.getX()+i)||(nach.getX()== von.getX()-i))
				{
					return true;
				}
			}
		}
		if(nach.getY()>von.getY()||nach.getY()<von.getY())
		{
			for(int i=1;i<=8;i++)
			{
				if((nach.getY()== von.getY()+i)||(nach.getY()== von.getY()-i))
				{
					Feld figurVon=sp.getFeld(von.getX(), von.getY()+i);
					if((Figur)figur instanceof Figur)
					{
						if(((Figur) figur).dieselbeFigur((Figur)figurVon,(Figur) figur))
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
					System.out.println("hallo");
					return false;
				}
			}
		}*/
		if((nach.getY()>von.getY())||(nach.getY()<von.getY()))
		{
			System.out.println("hallo");
			for(int i=1;i<=8;i++)
			{
				if((nach.getY()== von.getY()+i)||(nach.getY()==von.getY()-i))
				{
					return true;
				}
				else
				{
					
					if(!super.spielzugMoeglich(sp, von, nach))return false;
					
				}
			}
			
		}
		if(nach.getX()>von.getX()||nach.getX()<von.getX())
		{
			System.out.println("hallo");
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
		}
		
		return false;
	}
}
