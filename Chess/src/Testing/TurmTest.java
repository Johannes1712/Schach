package Testing;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.htl.chess.model.*;
import org.junit.*;


public class TurmTest 
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
	public void testSpielzugMoeglich() 
	{
		try
		{
			Spielfeld sf = SpielFeldIO.einlesen("Turm");
			Turm t = (Turm) sf.getFigur(0,7);
			boolean beobachtet;				
			
			beobachtet=t.spielzugMoeglich(sf,new Position(0,7),new Position(9,9));
			Assert.assertFalse(beobachtet);
			
			beobachtet=t.spielzugMoeglich(sf, new Position(0,7), new Position(0,4));
			Assert.assertTrue(beobachtet);
			
			beobachtet=t.spielzugMoeglich(sf, new Position(0,0), new Position(0,2));
			Assert.assertTrue(beobachtet);			
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
			Assert.fail();
		}
	}
}
