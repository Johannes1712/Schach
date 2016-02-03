
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
		return false;
	}
}
