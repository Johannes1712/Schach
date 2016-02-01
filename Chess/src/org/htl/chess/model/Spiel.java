package org.htl.chess.model;

import view.Frame;
import java.io.FileNotFoundException;
import Testing.SpielFeldIO;

public class Spiel {
	
	public static void main(String[] args) throws FileNotFoundException
	{
		Spielfeld sf = SpielFeldIO.einlesen("SchachRNM.txt");
		//sf.ausgabe();
		
		Frame frame=new Frame(sf);
		frame.initialize();
	}
}
