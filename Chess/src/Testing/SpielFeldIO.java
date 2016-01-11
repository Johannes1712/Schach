package Testing;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.htl.chess.model.Feld;
import org.htl.chess.model.Spielfeld;
import org.htl.chess.model.Springer;
import org.htl.chess.model.Turm;


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
		char farbe = f.charAt(1); //z.B. W f�r Weiss
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
				feld.setFeld(spalte, zeile,  f); //setze die aktuelle Figur auf das Spielfeld
			}
			zeile++;
		}
		return feld;
	}

	public static void main(String[] args) throws FileNotFoundException
	{
		Spielfeld sf = SpielFeldIO.einlesen("c:\\Temp\\feld1.txt");
		sf.ausgabe();

	}

}
