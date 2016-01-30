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
			Bauer b = (Bauer) sf.getFigur(1,1);
			boolean beobachtet;
			
			beobachtet = b.spielZug(sf, new Position(2,1),new Position(3,2));
			Assert.assertTrue(beobachtet);

			beobachtet = b.spielZug(sf, new Position(1,1),new Position(0,3));
			Assert.assertFalse(beobachtet);

			
			beobachtet = b.spielZug(sf, new Position(6,6),new Position(3,7));
			Assert.assertFalse(beobachtet);
		} catch (FileNotFoundException e)
		{
			e.printStackTrace();
			Assert.fail();
		}
	}

	@Test
	public void testSpielzugMoeglich()  
	{
		try
		{
			boolean beobachtet;
			Spielfeld sf = SpielFeldIO.einlesen("Spielfeld-Startposition.txt");
			Bauer b = (Bauer) sf.getFigur(1,1);
			
			beobachtet = b.spielzugMoeglich(sf, new Position(1,1),new Position(1, 4));
			Assert.assertFalse(beobachtet);
			
			beobachtet = b.spielzugMoeglich(sf, new Position(1,1),new Position(2, 5));
			Assert.assertFalse(beobachtet);	

			b = (Bauer) sf.getFigur(1,6);
			
			beobachtet = b.spielzugMoeglich(sf, new Position(1,6),new Position(1, 5));
			Assert.assertFalse(beobachtet);
			
			beobachtet = b.spielzugMoeglich(sf, new Position(7,6),new Position(6, 5));
			Assert.assertTrue(beobachtet);

		} catch (FileNotFoundException e)
		{
			e.printStackTrace();
			Assert.fail();
		}
	}
	
}
