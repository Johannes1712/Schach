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
		
		
		boolean rueckgabewert=true;
		if(nach.getX()>von.getX()||nach.getX()<von.getX())
		{
			for(int i=1;i<=8;i++)
			{
				if((nach.getX()== von.getX()+i)||(nach.getX()== von.getX()-i))
				{
					if(!super.spielzugMoeglich(sp, von, nach))
					{
						return false;
					}
					else rueckgabewert=true;
				}
			}
			//if(rueckgabewert==true)return true;
		}
		else
		{
			for(int i=1;i<=8;i++)
			{
				if((nach.getY()== von.getY()+i)||(nach.getY()== von.getY()-i))
				{
					if(!super.spielzugMoeglich(sp, von, nach))
					{
						return false;
					}
					else rueckgabewert=true;
				}
			}
			//if(rueckgabewert==true)return true;
		}
		/*if(rueckgabewert==true)
		{
			return true;
		}*/
		
		
		/*if(nach.getX()>von.getX()||nach.getY()>von.getY())
		{
			
			int xkoord;
			int ykoord;
			System.out.println("hallo");
			for(xkoord=von.getX();xkoord<nach.getX();xkoord++)
			{
				for(ykoord=von.getY();ykoord<nach.getY();ykoord++)
				{
					if(spielfeld[xkoord][ykoord]==spielfeld[von.getX()][von.getY()])
					{
						return false;
					}
				}
			}
		}
		else
		{
			int xkoord;
			int ykoord;
			
			for(xkoord=nach.getX();xkoord<von.getX();xkoord++)
			{
				for(ykoord=nach.getY();ykoord<von.getY();ykoord++)
				{
					if(spielfeld[xkoord][ykoord]==spielfeld[von.getX()][von.getY()])
					{
						return false;
					}
				}
			}
		}*/
		
		return false;
		
	}

}
