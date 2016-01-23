package Testing;

import java.io.*;
import java.util.Scanner;
import org.htl.chess.model.*;

public class SpielFeldIO
{
	/**
	 * @param f z.B. BW oder __
	 * @return ein Objekt vom Typ Feld, wenn es ein leeres Feld ist,
	 * eine konkrete Figur, wenn es eine Spielfigur ist
	 * Factory
	 */	
	static Feld leseFeld(String f)
	{
		char typ = f.charAt(0); //z.B Bauer
		char farbe = f.charAt(1); //z.B. W für Weiss
		boolean farbeW = (farbe == 'W');
		
		switch(typ)
		{
			case 'T' : return new Turm(farbeW);
			case 'S' : return new Springer(farbeW);
			case 'L' : return new Laeufer(farbeW);
			case 'K' : return new Koenig(farbeW);
			case 'D' : return new Dame(farbeW);
			case 'B' : return new Bauer(farbeW);
			default: return new Feld();
		}
	}
	
	static public Spielfeld einlesen(String fName) throws FileNotFoundException
	{
		Position position= new Position(0,0);
		Spielfeld feld = new Spielfeld();
		Scanner s = new Scanner (new File(fName));
		int zeile = 0;
		while (s.hasNextLine())
		{
			String line = s.nextLine(); //z.B. TW|SW|LW|DW|KW|LW|SW|TW
			String[] figs = line.split("\\|");	//z.B. figs = {"TW", "SW" ,... }	
			for (int spalte = 0; spalte < figs.length;spalte++)
			{
				Feld f = leseFeld(figs[spalte]); 
				position.setX(zeile);
				position.setY(spalte);
				feld.figurenSetzen(position,  f); //setze die aktuelle Figur auf das Spielfeld
			}
			zeile++;
		}
		return feld;
	}

}
