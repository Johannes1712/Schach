package org.htl.chess.model;

public class Koenig extends Figur
{

	public Koenig(boolean farbe) {
		super(farbe);
		// TODO Auto-generated constructor stub
	}

	public boolean spielzug(Spielfeld sp,Position von,Position nach)
	{
		return super.spielZug(sp, von, nach);
	}
	
	public boolean spielzugMoeglich(Spielfeld sp,Position von,Position nach)
	{
		
		boolean rw = true;										//Rueckgabewert
		
		if(!super.spielzugMoeglich(sp, von, nach))rw = false;
		
		if  ((von.getX() > nach.getX() +1)						//Koenig darf nicht mehr als 1 Feld in X-Richtung gehen						
				|| (von.getX() < nach.getX() - 1))						
		{
			return false;
		}
		
		if ((von.getY() > nach.getY() + 1) 						//Koenig kann immer nur 1 oder 0 Felder vor oder zur�ck gehen
				|| (von.getY() < nach.getY() - 1))		
		{
			return false;
		}
		
		Feld figur = sp.getFeld(nach.getX(), nach.getY());
		
		if(figur instanceof Figur)
		{
			boolean istGleichesTeam = ((Figur) figur).getFarbeW();
			if(istGleichesTeam)return false;
		}
		
		//Rochaden Wei�:
		
																//gro�e Rochade Wei�
		if (getFarbeW() && ((nach.getX() == 2) && nach.getY() == 0)

				&& (getBewegt() == false) 						//Koenig darf zuvor nicht bewegt worden sein
				&& (sp.schach() == false)						//Rochade ist im Schach nicht erlaubt
				&& (((spielfeld [0][0] instanceof Turm)			//Turm muss in der Ecke stehen (bei gegnerischen Turm st�nde der K�nig im Schach
				&& !(spielfeld [1][0] instanceof Figur)  		// => Farbe muss nicht beachtet werden)
				&& !(spielfeld [2][0] instanceof Figur) 		//auf den Feldern zwischen Koenig und Turm darf keine Figur stehen
				&& !(spielfeld [3][0] instanceof Figur)))) 
		{ 
			return true;
		}
		
																//kleine Rochade Wei�
		if (getFarbeW() && ((nach.getX() == 6) && nach.getY() == 0) 

				&& (getBewegt() == false) 
				&& (sp.schach() == false)
				&& (((spielfeld [7][0] instanceof Turm)
				&& !(spielfeld [5][0] instanceof Figur) 
				&& !(spielfeld [6][0] instanceof Figur)))) 
		{ 
			return true;
		}
		
		
		//Rochaden Schwarz:
		
																//gro�e Rochade Schwarz
		if ((getFarbeW() == false) && ((nach.getX() == 1) && nach.getY() == 7) 
				&& (getBewegt() == false) 
				&& (sp.schach() == false)
				&& (((spielfeld [0][7] instanceof Turm)
				&& !(spielfeld [1][7] instanceof Figur) 
				&& !(spielfeld [2][7] instanceof Figur) 
				&& !(spielfeld [3][7] instanceof Figur)))) 
		{ 
			return true;
		}
		
																//kleine Rochade Schwarz
		if ((getFarbeW() == false) && ((nach.getX() == 6) && nach.getY() == 7) 
				&& (getBewegt() == false)
				&& (sp.schach() == false)
				&& (((spielfeld [7][7] instanceof Turm)			
				&& !(spielfeld [5][7] instanceof Figur) 
				&& !(spielfeld [6][7] instanceof Figur)))) 
		{
			return true;
		}
		
		//Verhindern, dass sich Koenig selbst ins Schach setzt:
		
		sp.spielzugAusfuehren(von, nach, this);
		Feld spFigur =  sp.getFeld(nach.getX(),nach.getY());
		
		if (spFigur instanceof Figur)
		{
			spFigur = (Figur)spFigur;
		}
		
		/*if (sp.schach())
		{
			rw = false;
			sp.figurenSetzen(new Position(nach.getX(), nach.getY()), spFigur);
			//spFigur=sp.getFeld(nach.getX(), nach.getY());
			//spielfeld [nach.getX()][nach.getY()] = spFigur;
		}*/
		
		return rw;		
	}
}
