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
			rw = false;
		}
		
		if ((von.getY() > nach.getY() + 1) 						//Koenig kann immer nur 1 oder 0 Felder vor oder zur�ck gehen
				|| (von.getY() < nach.getY() - 1))		
		{
			rw = false;
		}
		
		Feld figur = sp.getFeld(nach.getX(), nach.getY());
		
		if(figur instanceof Figur)
		{
			boolean istGleichesTeam = ((Figur) figur).getFarbeW();
			if(istGleichesTeam)rw = false;
		}
		
		//Rochaden Wei�:
		
																//gro�e Rochade Wei�
		if (getFarbeW() && ((nach.getX() == 5) && nach.getY() == 7)

				&& (getBewegt() == false) 						//Koenig darf zuvor nicht bewegt worden sein
				&& (sp.schach() == false)						//Rochade ist im Schach nicht erlaubt
				&& (((spielfeld [7][7] instanceof Turm)			//Turm muss in der Ecke stehen (bei gegnerischen Turm st�nde der K�nig im Schach
				&& !(spielfeld [6][7] instanceof Figur)  		// => Farbe muss nicht beachtet werden)
				&& !(spielfeld [5][7] instanceof Figur) 		//auf den Feldern zwischen Koenig und Turm darf keine Figur stehen
				&& !(spielfeld [4][7] instanceof Figur)))) 
		{ 
			rw = true;
			
			Feld turm1 = sp.getFeld(7,7);
			sp.figurenSetzen(new Position(4,7), turm1);
		}
		
																//kleine Rochade Wei�
		if (getFarbeW() && ((nach.getX() == 1) && nach.getY() == 7) 

				&& (getBewegt() == false) 
				&& (sp.schach() == false)
				&& (((spielfeld [0][7] instanceof Turm)
				&& !(spielfeld [1][7] instanceof Figur) 
				&& !(spielfeld [2][7] instanceof Figur)))) 
		{ 
			rw = true;
			
			Feld turm2 = sp.getFeld(0,7);
			sp.figurenSetzen(new Position(2,7), turm2);
		}
		
		
		//Rochaden Schwarz:
		
																//gro�e Rochade Schwarz
		if ((getFarbeW() == false) && ((nach.getX() == 5) && nach.getY() == 0) 
				&& (getBewegt() == false) 
				&& (sp.schach() == false)
				&& (((spielfeld [7][0] instanceof Turm)
				&& !(spielfeld [6][0] instanceof Figur) 
				&& !(spielfeld [5][0] instanceof Figur) 
				&& !(spielfeld [4][0] instanceof Figur)))) 
		{ 
			rw = true;
			
			Feld turm3 = sp.getFeld(7,0);
			sp.figurenSetzen(new Position(4,0), turm3);
		}
		
																//kleine Rochade Schwarz
		if ((getFarbeW() == false) && ((nach.getX() == 1) && nach.getY() == 0) 
				&& (getBewegt() == false)
				&& (sp.schach() == false)
				&& (((spielfeld [0][0] instanceof Turm)			
				&& !(spielfeld [1][0] instanceof Figur) 
				&& !(spielfeld [2][0] instanceof Figur)))) 
		{
			rw = true;
			
			Feld turm4 = sp.getFeld(0,0);
			sp.figurenSetzen(new Position(2,0), turm4);
		}
		
		//Verhindern, dass sich Koenig selbst ins Schach setzt:
		/*
		Feld spFigur =  sp.getFeld(nach.getX(),nach.getY());
		sp.spielzugAusfuehren(von, nach, this);
		
		if (spFigur instanceof Figur)
		{
			spFigur = (Figur)spFigur;
		}
		
		if (sp.schach())
		{
			rw = false;
			sp.figurenSetzen(new Position(nach.getX(), nach.getY()), spFigur);
		}
		*/
		return rw;		
	}
}
