package Testing;


import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.htl.chess.model.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
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
	public void testSpielZug() 
	{	
		
		try
		{
			Spielfeld sf = SpielFeldIO.einlesen("Spielfeld-Startposition.txt");
			Bauer sp = (Bauer) sf.getFigur(1,1);

			// rechts nach vorn
			boolean beobachtet = sp.spielzugMoeglich(sf, new Position(1,1),new Position(1, 2));
			Assert.assertTrue(beobachtet);
			System.out.println(beobachtet);

			beobachtet = sp.spielzugMoeglich(sf, new Position(1,1),new Position(3, 4));
			Assert.assertFalse(beobachtet);

		} catch (FileNotFoundException e)
		{
			e.printStackTrace();
			Assert.fail();
		}
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
