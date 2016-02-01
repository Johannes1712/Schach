package org.htl.chess.model;

public class Turm extends Figur
{
	public Turm(boolean farbe) {
		super(farbe);
		// TODO Auto-generated constructor stub
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
		
		if(nach.getX()>von.getX()||nach.getX()<von.getX())
		{
			for(int i=1;i<=8;i++)
			{
				if((nach.getX()== von.getX()+i)||(nach.getX()== von.getX()-i))
				{
					if(super.spielzugMoeglich(sp, von, nach))return false;
				}
			}
		}
		if(nach.getY()>von.getY()||nach.getY()<von.getY())
		{
			for(int i=1;i<=8;i++)
			{
				if((nach.getY()== von.getY()+i)||(nach.getY()== von.getY()-i))
				{
					if(super.spielzugMoeglich(sp, von, nach))return true;
				}
			}
		}
		
		return false;
		
	}
}
