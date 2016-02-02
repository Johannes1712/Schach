package org.htl.chess.model;

public class Bauer extends Figur 
{
	public Bauer(boolean farbe, boolean bewegt) {
		super(farbe,bewegt);
	}

	// Spalten sind Buchstaben
	// Zeilen sind Zahlen
	// 0/0 ist links unten auf a1
	// somit die linkeste Spalte 0 und die unterste Zeile 0

	public boolean spielZug(Spielfeld sp, Position von, Position nach) 
	{
		return super.spielZug(sp, von, nach);
	}

	public boolean spielzugMoeglich(Spielfeld sp, Position von, Position nach) 
	{
		if (!super.spielzugMoeglich(sp, von, nach))return false;
	
		boolean farbeSchwarz;
		int bewegenY = nach.getX() - von.getX();
		int bewegenX = nach.getY() - von.getY();
		
		Figur figurVon = sp.getFigur(von.getX(), von.getY()); 
		Feld figurNach=sp.getFeld(nach.getX(), nach.getY());
		
		if(figurNach instanceof Figur)
		{
			if(!figurVon.dieselbeFigur((Figur)figurNach, figurVon)) return false;
		}
		
		//abfragen welche Farbe die Figur hat
		if(!figurVon.getFarbeW())farbeSchwarz= true;
		else farbeSchwarz= false;
		
		//Für Farbe weiß
		if(!farbeSchwarz)
		{ 
			// Abfrage ob erste Spielzug der Farbe weiß
			if(figurVon.getBewegt())
			{
				if(bewegenY==-1 && bewegenX==0 && !(figurNach instanceof Figur)) return true;
				if((bewegenX==1||bewegenX==-1) && bewegenY==-1 && figurNach instanceof Figur)return true;								
			}
			
			if(!figurVon.getBewegt())
			{
				figurVon.setBewegt(true);
				
				if(bewegenY==-2 && bewegenX==0 && figurNach instanceof Figur)return true;
				if(bewegenY==-1 && bewegenX==0 && !(figurNach instanceof Figur)) return true;
				if((bewegenX==1||bewegenX==-1) && bewegenY==-1 && figurNach instanceof Figur)return true;
				else return false;
			}
		
		
		}
		
		//Für Farbe schwarz 
		if(farbeSchwarz)
		{ 
			// Abfrage ob erste Spielzug der Farbe schwarz
			if(figurVon.getBewegt())
			{
				if(bewegenY==1 && bewegenX==0 && !(figurNach instanceof Figur)) return true;
				if((bewegenX==1||bewegenX==-1) && bewegenY==1 && figurNach instanceof Figur)return true;								
			}
			
			if(!figurVon.getBewegt())
			{	
				figurVon.setBewegt(true);
				
				if(bewegenY==2&& bewegenX==0 && figurNach instanceof Figur)return true;
				if(bewegenY==1 && bewegenX==0 && !(figurNach instanceof Figur)) return true;
				if((bewegenX==1||bewegenX==-1) && bewegenY==1 && figurNach instanceof Figur)return true;
				else return false;
			}
		}
		return false;
		
	}	
}
