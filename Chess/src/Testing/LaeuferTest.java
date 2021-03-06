package Testing;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.htl.chess.model.Bauer;
import org.htl.chess.model.Laeufer;
import org.htl.chess.model.Position;
import org.htl.chess.model.Spielfeld;
import org.htl.chess.model.Springer;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class LaeuferTest
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
		try
		{
			
			Spielfeld sf = SpielFeldIO.einlesen("SchachLaeufer");
			Laeufer lf = (Laeufer) sf.getFigur(7,2);
			boolean beobachtet;
				//l�ufer bewegen
			//beobachtet = lf.spielzugMoeglich(sf, new Position(2,0),new Position(0,1));
			//Assert.assertFalse(beobachtet);

			
		} catch (FileNotFoundException e)
		{

			e.printStackTrace();
			Assert.fail();
		}
	}

	@Test
	public void testSpielZugMoeglich() throws FileNotFoundException 
	{
		Spielfeld sf = SpielFeldIO.einlesen("SchachLaeufer");
		Laeufer lf = (Laeufer) sf.getFigur(7,2);	
		boolean beobachtet = lf.spielzugMoeglich(sf, new Position(7,2),new Position(4,5));
		Assert.assertTrue(beobachtet);
		beobachtet = lf.spielzugMoeglich(sf, new Position(7,2),new Position(3,6));
		Assert.assertFalse(beobachtet);
	}
}
