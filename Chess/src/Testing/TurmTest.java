package Testing;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.htl.chess.model.Bauer;
import org.htl.chess.model.Laeufer;
import org.htl.chess.model.Position;
import org.htl.chess.model.Spielfeld;
import org.htl.chess.model.Turm;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class TurmTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}


	@Test
	public void testSpielzugMoeglich() 
	{
		try
		{
			Spielfeld sf = SpielFeldIO.einlesen("Turm");
			Turm t = (Turm) sf.getFigur(0,0);
			boolean beobachtet;
			
			beobachtet=t.spielzugMoeglich(sf,new Position(0,0),new Position(6,0));
			Assert.assertFalse(beobachtet);				
			
			beobachtet=t.spielzugMoeglich(sf,new Position(0,0),new Position(9,9));
			Assert.assertFalse(beobachtet);
				

			/*beobachtet=t.spielzugMoeglich(sf, new Position(0,0), new Position(0,3));
			Assert.assertTrue(beobachtet);*/
			
			/*beobachtet=t.spielzugMoeglich(sf, new Position(0,0), new Position(3,0));
			Assert.assertTrue(beobachtet);*/
			
			beobachtet=t.spielzugMoeglich(sf, new Position(0,0), new Position(0,2));
			Assert.assertFalse(beobachtet);
			
			
			
			
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
			Assert.fail();
		}
	}

}
