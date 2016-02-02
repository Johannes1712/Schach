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
		Feld figur= sp.getFeld(nach.getX(),nach.getY());
		if(figur instanceof Figur)
		{			
			boolean istGleichesTeam = ((Figur) figur).getFarbeW();
			if(istGleichesTeam)return false;
		}
		if((nach.getY()>von.getY())||(nach.getY()<von.getY()))
		{
			for(int i=1;i<=8;i++)
			{
				System.out.println(i);
				if((nach.getY()== von.getY()+i)||(nach.getY()==von.getY()-i))
				{
					return true;
				}
				else
				{
					System.out.println("hallo");
					Figur figurVon = sp.getFigur(von.getX(),von.getY()+i);
					Figur figurNach = null;
					
					if(sp.getFeld(von.getX(),von.getY()) instanceof Figur && sp.getFeld(nach.getX(),nach.getY()) instanceof Figur)
					{			
						System.out.println("hallo");
						figurNach = sp.getFigur(nach.getX(),nach.getY());
					}
					System.out.println("hallo");
					if(!this.dieselbeFigur(figurVon,figurNach))return false;
					return true;
					
					//if(!super.spielzugMoeglich(sp, von, nach))return false;
					
				}
			}
			
		}
		
//		if(figur instanceof Figur)
//		{			
//			boolean istGleichesTeam = ((Figur) figur).getFarbeW();
//			if(istGleichesTeam)return false;
//		}
		
		if(nach.getX()>von.getX()||nach.getX()<von.getX())
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
		}
		
		return false;
		
	}
}
/*Feld figurVon=null;
if(sp.getFeld(von.getX(),von.getY()) instanceof Figur)
{
	figurVon = sp.getFigur(von.getX(),von.getY()+i);
	
	if(!((Figur) figur).dieselbeFigur((Figur)figurVon,(Figur) figur))
	{
		return false;
	}
	
	
}
else
{
	return false;
}*/