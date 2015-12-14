package org.htl.chess.model;

public class Dame extends Figur{
	
	boolean rueckgabewert;
	private Feld[ ] [ ] spielfeld;
	public boolean spielzug(Spielfeld sp, Position von, Position nach)
	{
		spielfeld= sp.getMat();
		if(spielzugmoeglich(sp,von,nach))
		{
			//sp.spielzugAusführen(Paramter);
		}
		return rueckgabewert;
	}
	protected boolean spielzugmoeglich(Spielfeld sp, Position von, Position nach)
	{
		Feld figur= spielfeld [nach.getX()][nach.getY()];
		if((nach.getX()<=8)&&(nach.getY()<=8))
		{
			rueckgabewert=true;
		}
		else rueckgabewert=false;
		
		if(spielfeld[nach.getX()][nach.getY()]!=spielfeld[von.getX()][von.getY()])
		{
			return true;
		}
		else rueckgabewert=false;

		if(spielfeld[nach.getX()][nach.getY()] instanceof Figur)
		{
			boolean istGleichesTeam = ((Figur) figur).getFarbeWeiss();
			if(istGleichesTeam)
			{
				rueckgabewert=false;
			}
		}		
		/*for(int i=0;i<=7;i++)
		{
			if((nach.getX()== von.getX()+i)||(nach.getX()== von.getX()-i))
			{
				rueckgabewert=true;
			}	
			
		}
		//if(spielfeld[(nach.getX()+i][nach.getY()]== spielfeld[von.getX()][von.getY()])
		for(int i=0;i<=7;i++)
		{
			if((nach.getY()== von.getY()+i)||(nach.getY()== von.getY()-i))
			{
				rueckgabewert=true;
			}	
			
		}*/
			
		
	
		return rueckgabewert;
	}
}
