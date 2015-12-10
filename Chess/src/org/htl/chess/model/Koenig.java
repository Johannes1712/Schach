package org.htl.chess.model;
import Figur;
import Position;
import SpielFeld;

public class Koenig extends Figur
{

	public boolean spielzug(SpielFeld sp,Position von,Position nach)
	{
		//Spielzug wird durchgef�hrt (return true) wenn der Spielzug m�glich ist (spielzugMoeglich = true)
		
		return (spielzugMoeglich(sp,von,nach));
		
	}
	
	public boolean spielzugMoeglich(SpielFeld sp,Position von,Position nach)
	{
		
		boolean rw = true;									//R�ckgabewert
		
															
		if  ((von.x() > nach.x() +1)						//K�nig darf nicht mehr als 1 Feld in x-Richtung gehen						
				|| (von.x() < nach.x() - 1))						
		{
			rw = false;
		}
		
		if ((von.y() > nach.y() + 1) 						//K�nig kann immer nur 1 oder 0 Felder vor oder zur�ck gehen
				|| (von.y() < nach.y() - 1))		
		{
			rw = false;
		}
		
		
		//Rochaden Wei�:
		
															//gro�e Rochade Wei�
		if ((farbeWeiss() == true) && ((nach.x() == 2) && nach.y() == 0) 
				&& (bewegt() == false) 						//K�nig darf zuvor nicht bewegt worden sein
				&& (sp.schach() == false)					//Rochade ist im Schach nicht erlaubt
				&& (((sp.mat[0][0] instanceof Turm)			//Turm muss in der Ecke stehen
				&& !(sp.mat[1][0] instanceof Figur)  		//auf den Feldern zwischen K�nig und Turm darf keine Figur stehen
				&& !(sp.mat[2][0] instanceof Figur) 
				&& !(sp.mat[3][0] instanceof Figur)))) 
		{ 
			rw = true;
		}
		
															//kleine Rochade Wei�
		if ((farbeWeiss() == true) && ((nach.x() == 6) && nach.y() == 0) 
				&& (bewegt() == false) 
				&& (sp.schach() == false)
				&& (((sp.mat[7][0] instanceof Turm)
				&& !(sp.mat[5][0] instanceof Figur) 
				&& !(sp.mat[6][0] instanceof Figur)))) 
		{ 
			rw = true;
		}
		
		
		//Rochaden Schwarz:
		
															//gro�e Rochade Schwarz
		if ((farbeWeiss() == false) && ((nach.x() == 1) && nach.y() == 7) 
				&& (bewegt() == false) 
				&& (sp.schach() == false)
				&& (((sp.mat[0][7] instanceof Turm)
				&& !(sp.mat[1][7] instanceof Figur) 
				&& !(sp.mat[2][7] instanceof Figur) 
				&& !(sp.mat[3][7] instanceof Figur)))) 
		{ 
			rw = true;
		}
		
															//kleine Rochade Schwarz
		if ((farbeWeiss() == false) && ((nach.x() == 6) && nach.y() == 7) 
				&& (bewegt() == false)
				&& (sp.schach() == false)
				&& (((sp.mat[7][7] instanceof Turm)
				&& !(sp.mat[5][7] instanceof Figur) 
				&& !(sp.mat[6][7] instanceof Figur)))) 
		{ 
			rw = true;
		}
		
		return rw;
			
	}
}
