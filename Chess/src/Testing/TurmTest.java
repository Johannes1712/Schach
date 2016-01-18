package Testing;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.htl.chess.model.Bauer;
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
	public void testTurm() {
		fail("Not yet implemented");
	}

	@Test
	public void testSpielzug() {
		fail("Not yet implemented");
	}

	@Test
	public void testSpielzugMoeglich() 
	{

		try
		{
			Spielfeld sf = SpielFeldIO.einlesen("Spielfeld-Startposition.txt");
			Turm t=new Turm(true);
			t = (Turm) sf.getFigur(1,0);
				
			boolean beobachtet=t.spielzugMoeglich(sf,new Position(0,0),new Position(0,1));
			Assert.assertFalse(beobachtet);
				
			beobachtet=t.spielzugMoeglich(sf,new Position(0,0),new Position(9,9));
			Assert.assertFalse(beobachtet);
				

			beobachtet=t.spielzugMoeglich(sf, new Position(0,0), new Position(0,3));
			Assert.assertFalse(beobachtet);
				
			Bauer b=new Bauer(true);
			b = (Bauer) sf.getFigur(0,1);
			beobachtet=b.spielzugMoeglich(sf, new Position(0,1), new Position(0,3));
			Assert.assertTrue(beobachtet);
				
			
			beobachtet=b.spielzugMoeglich(sf, new Position(0,0), new Position(0,2));
			Assert.assertTrue(beobachtet);
			
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
			Assert.fail();
		}
	}

}
