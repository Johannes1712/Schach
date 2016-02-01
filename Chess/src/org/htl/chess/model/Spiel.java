package org.htl.chess.model;

import view.Frame;
import java.io.FileNotFoundException;
import Testing.SpielFeldIO;

public class Spiel {
	
	public static void main(String[] args) throws FileNotFoundException
	{
		Spielfeld sf = SpielFeldIO.einlesen("Spielfeld-Startposition.txt");
		sf.ausgabe();
		
		// System.out.println(sf.getFigur(1, 1).getFarbeW());
		Frame frame=new Frame(sf);
		frame.initialize();
	}
}
