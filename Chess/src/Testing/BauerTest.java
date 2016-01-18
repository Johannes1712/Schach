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
	

	
	
	@Test
	public void testSpielZug() throws FileNotFoundException 
	{			
		boolean ausfuehren;
		Bauer figur=new Bauer(true);	
		SpielFeldIO.leseFeld("BW");
		Spielfeld spf= SpielFeldIO.einlesen("Spielfeld-Startposition.txt");
		Position von=new Position(1,1);
		Position nach=new Position(1,2);
		ausfuehren=figur.spielZug(spf, von, nach);	
		assertEquals(ausfuehren,false);	
	}

	@Test
	public void testSpielZugMoeglich() throws FileNotFoundException 
	{
		boolean ausfuehren;
		Bauer figur=new Bauer(true);
		SpielFeldIO.leseFeld("LW");
		Spielfeld spf= SpielFeldIO.einlesen("Spielfeld-Startposition.txt");
		Position von=new Position(1,2);
		Position nach=new Position(3,2);
		spf.figurenSetzen(von, figur);		
		ausfuehren=figur.spielZug(spf, von, nach);	
		assertEquals(ausfuehren,false);
	}
}
