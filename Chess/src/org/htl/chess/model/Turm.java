package org.htl.chess.model;
public class Turm extends Figur{
	boolean rueckgabewert;
	public boolean spielzug(Spielfeld sp, Position von, Position nach)
	{
		if(rueckgabewert==true)
		{
			//sp.spielzug();
			rueckgabewert=true;
		}
		return rueckgabewert;
	}
	protected boolean spielzugmoeglich(Spielfeld sp, Position von, Position nach)
	{
		if((nach.getX()<=8)&&(nach.getY()<=8))
		{
			rueckgabewert=true;
		}
		else
		{
			rueckgabewert=false;
			System.out.println("falsch");
		}
		Feld figur=Spielfeld[nach.getX()][nach.getY()];
		if(sp[nach.getX()][nach.getY()] instanceof Turm)
		{
			if(sp[nach.getX()][nach.getY()].matt[nach.getX()][nach.getY()]!=sp.mat[von.getX()][von.getY()])
			{
				rueckgabewert=true;
			}
			
		}
		else rueckgabewert=false;
		
		
		for(int i=0;i<=7;i++)
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
		}
		
		return rueckgabewert;
		
	}

}
