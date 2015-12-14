
package org.htl.chess.model;

public class Dame extends Figur {
	boolean rueckgabewert;
	private Feld[ ] [ ] spielfeld;
	
	public boolean spielZug(Spielfeld sp, Position von, Position nach)
	{
		return super.spielZug(sp, von, nach);
	}
	protected boolean spielzugmoeglich(Spielfeld sp, Position von, Position nach)
	{
		
		Feld figur=spielfeld[nach.getX()][nach.getY()];
		
		if(super.spielzugMoeglich(sp, von, nach)==false)rueckgabewert=false;
		
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
			if(istGleichesTeam)return false;
		}
		
		
		/*for(int i=0;i<=7;i++)
		{
			if(sp.mat[von.getX()+i][von.getY()]==sp.mat[nach.getX()][von.getY()])
			{
				rueckgabewert=true;
			}
			else rueckgabewert=false;
		}
		for(int i=0;i<=7;i++)
		{
			if(sp.mat[von.getX()][von.getY()+1]==sp.mat[nach.getX()][von.getY()])
			{
				rueckgabewert=true;
			}
			else rueckgabewert=false;
		}*/
		
		return rueckgabewert;
		
	}


}
