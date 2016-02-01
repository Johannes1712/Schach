
package org.htl.chess.model;
	
public class Dame extends Figur
{
	public Dame(boolean farbe) {
		super(farbe);
	}

	
	public boolean spielZug(Spielfeld sp, Position von, Position nach)
	{
		return super.spielZug(sp, von, nach);
	}
	
	public boolean spielzugMoeglich(Spielfeld sp, Position von, Position nach)
	{	
		
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
		if(nach.getX()>von.getX()||nach.getX()<von.getX())
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
					return true;
				}
			}
		}
		
		return false;
	}
}
