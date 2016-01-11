package Testing;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.htl.chess.model.Bauer;
import org.htl.chess.model.Figur;
import org.htl.chess.model.Koenig;
import org.htl.chess.model.Position;
import org.htl.chess.model.Spielfeld;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import junit.framework.Assert;

public class KoenigTest {

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
	public void testSpielzugMoeglich() {
		
		try
		{
			SpielFeld sf = SpielFeldIO.einlesen("testdata/bauer_feld1.txt");
			
			Koenig k = new Koenig();
			Position von = new Position();
			Position nach = new Position();
			
			//1 vor
			
			//1 zurück
			
			//1 rechts
			
			//1 links
			
			//1 dia rechts vor
			
			//1 dia rechts zurück
			
			//1 dia links vor
			
			//1 dia rechts vor
			
			//kleine Rochade
			
			//große Rochade
		
		} catch (FileNotFoundException e)
		{

			e.printStackTrace();
			Assert.fail();
		}
		
		//fail("Not yet implemented");
	}

	@Test
	public void testSpielzug() {
		fail("Not yet implemented");
	}

}
