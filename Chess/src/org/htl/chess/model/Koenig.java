package org.htl.chess.model;

public class Koenig extends Figur
{
	private Feld [ ] [ ] spielfeld;

	public boolean spielzug(Spielfeld sp,Position von,Position nach)
	{
		spielfeld= sp.getMat();
		
		if(this.spielzugMoeglich(sp,von,nach)){
			
			sp.spielzugAusführen(von, nach, this );
			return true;
		}
		
		return false;
	}
	
	public boolean spielzugMoeglich(Spielfeld sp,Position von,Position nach)
	{
		
		boolean rw = true;										//Rueckgabewert
		
		spielfeld = sp.getMat();
		
		
		
		if  ((von.getX() > nach.getX() +1)						//Koenig darf nicht mehr als 1 Feld in X-Richtung gehen						
				|| (von.getX() < nach.getX() - 1))						
		{
			rw = false;
		}
		
		if ((von.getY() > nach.getY() + 1) 						//Koenig kann immer nur 1 oder 0 Felder vor oder zurück gehen
				|| (von.getY() < nach.getY() - 1))		
		{
			rw = false;
		}
		
		Feld figur = spielfeld [nach.getX()][nach.getY()];
		
		if(figur instanceof Figur)
		{
			boolean istGleichesTeam = ((Figur) figur).getFarbeWeiss();
			if(istGleichesTeam)rw = false;
		}
		
		//Rochaden Weiß:
		
																//große Rochade Weiß
		if ((getFarbeWeiss() == true) && ((nach.getX() == 2) && nach.getY() == 0) 
				&& (getBewegt() == false) 						//Koenig darf zuvor nicht bewegt worden sein
				&& (sp.schach() == false)						//Rochade ist im Schach nicht erlaubt
				&& (((spielfeld [0][0] instanceof Turm)			//Turm muss in der Ecke stehen
				&& !(spielfeld [1][0] instanceof Figur)  		//auf den Feldern zwischen Koenig und Turm darf keine Figur stehen
				&& !(spielfeld [2][0] instanceof Figur) 
				&& !(spielfeld [3][0] instanceof Figur)))) 
		{ 
			rw = true;
		}
		
																//kleine Rochade Weiß
		if ((getFarbeWeiss() == true) && ((nach.getX() == 6) && nach.getY() == 0) 
				&& (getBewegt() == false) 
				&& (sp.schach() == false)
				&& (((spielfeld [7][0] instanceof Turm)
				&& !(spielfeld [5][0] instanceof Figur) 
				&& !(spielfeld [6][0] instanceof Figur)))) 
		{ 
			rw = true;
		}
		
		
		//Rochaden Schwarz:
		
																//große Rochade Schwarz
		if ((getFarbeWeiss() == false) && ((nach.getX() == 1) && nach.getY() == 7) 
				&& (getBewegt() == false) 
				&& (sp.schach() == false)
				&& (((spielfeld [0][7] instanceof Turm)
				&& !(spielfeld [1][7] instanceof Figur) 
				&& !(spielfeld [2][7] instanceof Figur) 
				&& !(spielfeld [3][7] instanceof Figur)))) 
		{ 
			rw = true;
		}
		
																//kleine Rochade Schwarz
		if ((getFarbeWeiss() == false) && ((nach.getX() == 6) && nach.getY() == 7) 
				&& (getBewegt() == false)
				&& (sp.schach() == false)
				&& (((spielfeld [7][7] instanceof Turm)
				&& !(spielfeld [5][7] instanceof Figur) 
				&& !(spielfeld [6][7] instanceof Figur)))) 
		{ 
			rw = true;
		}
		
		
		//Verhindern, dass sich Koenig selbst ins Schach setzt:
		
		sp.spielzugAusführen(von, nach, this );
		if(sp.schach())
		{
			rw = false;
			sp.spielzugAusführen(nach, von, this );
		}
		
		return rw;		
	}
}
