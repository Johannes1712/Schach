package org.htl.chess.model;

public class Dame extends Figur{
	
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
		if((nach.getx()<=8)&&(nach.gety()<=8))
		{
			rueckgabewert=true;
		}
		else
		{
			rueckgabewert=false;
			System.out.println("falsch");
		}
		
		//if(sp[nach.getx()][nach.gety()] instanceof Dame)
		if(sp.matt[nach.getx()][nach.gety()]!=sp.matt[von.getx()][von.gety()])
		{
			rueckgabewert=true;
		}
		else rueckgabewert=false;
		
		//farbe weiss
		if(sp.matt[nach.getx()][nach.gety()-1]==sp.matt[von.getx()][von.gety()])
		{
			//geschlagen
		}
		if(sp.matt[nach.getx()-1][nach.gety()]==sp.matt[von.getx()][von.gety()])
		{
			//geschlagen
		}
		if(sp.matt[nach.getx()-1][nach.gety()-1]==sp.matt[von.getx()][von.gety()])
		{
			//geschlagen
		}
		
		
		return rueckgabewert;
	}
}
