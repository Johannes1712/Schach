package Testing;


import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.htl.chess.model.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class BauerTest 
{

	@BeforeClass
	public static void setUpBeforeClass() throws Exception 
	{
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception 
	{
	}

	@Before
	public void setUp() throws Exception 
	{
	}

	@After
	public void tearDown() throws Exception 
	{
	}
	
	boolean ausfuehren;
	Bauer figur2=new Bauer(true);	
	
	
	@Test
	public void testSpielZug() throws FileNotFoundException 
	{
		SpielFeldIO.einlesen("C://Users//Andrea//Dropbox//4. Klasse//SWP//SchachspielJohnnyAlexKurt//feld.txt");
		Position von=new Position(1,1);
		Position nach=new Position(1,2);
		SpielFeldIO.leseFeld("BW");

		System.out.println(von.getX()+" h "+von.getY());
		System.out.println(nach.getX()+" h "+nach.getY());
		System.out.println(figur2+" h ");
		System.out.println(figur2.spielZug(SpielFeldIO.einlesen("C://Users//Andrea//Dropbox//4. Klasse//SWP//SchachspielJohnnyAlexKurt//feld.txt"), von, nach));
		ausfuehren=figur2.spielZug(SpielFeldIO.einlesen("C://Users//Andrea//Dropbox//4. Klasse//SWP//SchachspielJohnnyAlexKurt//feld.txt"), von, nach);	
		
		assertEquals(ausfuehren,false);	
	}

	@Test
	public void testSpielZugMoeglich() throws FileNotFoundException 
	{
		SpielFeldIO.einlesen("C://Users//Andrea//Dropbox//4. Klasse//SWP//SchachspielJohnnyAlexKurt//feld.txt");
		Position von=new Position(1,2);
		Position nach=new Position(3,2);
		System.out.println(von.getX()+" h "+von.getY());
		System.out.println(nach.getX()+" h "+nach.getY());
		System.out.println(figur2+" h ");
		System.out.println(figur2.spielZugMoeglich(SpielFeldIO.einlesen("C://Users//Andrea//Dropbox//4. Klasse//SWP//SchachspielJohnnyAlexKurt//feld.txt"), von, nach));
		SpielFeldIO.einlesen("C://Users//Andrea//Dropbox//4. Klasse//SWP//SchachspielJohnnyAlexKurt//feld.txt").figurenSetzen(von, figur2);
		ausfuehren=figur2.spielZug(SpielFeldIO.einlesen("C://Users//Andrea//Dropbox//4. Klasse//SWP//SchachspielJohnnyAlexKurt//feld.txt"), von, nach);	
		assertEquals(ausfuehren,false);
	}
}
