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
			Bauer b = (Bauer) sf.getFigur(3,1);
			boolean beobachtet;
			
			System.out.println(b.getFarbeW());
			beobachtet = b.spielzugMoeglich(sf, new Position(3,1),new Position(3,2));
			Assert.assertFalse(beobachtet);

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
			Spielfeld sf = SpielFeldIO.einlesen("SchachRNM.txt");
			Bauer b = (Bauer) sf.getFigur(5,1);

			beobachtet = b.spielzugMoeglich(sf, new Position(5,1),new Position(5, 2));
			Assert.assertFalse(beobachtet);
			
			beobachtet = b.spielzugMoeglich(sf, new Position(1,6),new Position(2, 6));
			Assert.assertTrue(beobachtet);
			
			beobachtet = b.spielzugMoeglich(sf, new Position(1,6),new Position(1,2));
			Assert.assertFalse(beobachtet);
			
			beobachtet = b.spielzugMoeglich(sf, new Position(1,6),new Position(6, 5));
			Assert.assertFalse(beobachtet);

		} catch (FileNotFoundException e)
		{
			e.printStackTrace();
			Assert.fail();
		}
	}
	
}
