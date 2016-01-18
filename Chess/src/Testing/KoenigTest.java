package Testing;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.htl.chess.model.Bauer;
import org.htl.chess.model.Figur;
import org.htl.chess.model.Koenig;
import org.htl.chess.model.Position;
import org.htl.chess.model.Spielfeld;
import org.htl.chess.model.Springer;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;



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
			Spielfeld sf = SpielFeldIO.einlesen("SchachRM.txt");
			Koenig k = (Koenig) sf.getFigur(1,0);
			
			//kleine Rochade weiﬂ
			boolean beobachtet = k.spielzugMoeglich(sf, new Position(4,0),
					new Position(6, 0));
			Assert.assertFalse(beobachtet);
			
			//groﬂe Rochade weiﬂ
			beobachtet = k.spielzugMoeglich(sf, new Position(4,0),
					new Position(2, 0));
			Assert.assertFalse(beobachtet);
			
			//kleine Rochade schwarz
			beobachtet = k.spielzugMoeglich(sf, new Position(4,7),
					new Position(6, 7));
			Assert.assertFalse(beobachtet);
			
			//groﬂe Rochade schwarz
			beobachtet = k.spielzugMoeglich(sf, new Position(4,7),
					new Position(2, 7));
			Assert.assertFalse(beobachtet);
			
		} catch (Exception e)
		{

			e.printStackTrace();
			Assert.fail();
		}
		
		//fail("Not yet implemented");
	}
	
	
	public void testSpielzugMoeglich2() {
		
		try
		{
			Spielfeld sf = SpielFeldIO.einlesen("SchachRNM.txt");
			Koenig k = (Koenig) sf.getFigur(1,0);
			
			//kleine Rochade weiﬂ
			boolean beobachtet = k.spielzugMoeglich(sf, new Position(4,0),
					new Position(6, 0));
			Assert.assertFalse(beobachtet);
			
			//groﬂe Rochade weiﬂ
			beobachtet = k.spielzugMoeglich(sf, new Position(4,0),
					new Position(2, 0));
			Assert.assertFalse(beobachtet);
			
			//kleine Rochade schwarz
			beobachtet = k.spielzugMoeglich(sf, new Position(4,7),
					new Position(6, 7));
			Assert.assertFalse(beobachtet);
			
			//groﬂe Rochade schwarz
			beobachtet = k.spielzugMoeglich(sf, new Position(4,7),
					new Position(2, 7));
			Assert.assertFalse(beobachtet);
			
			//aus dem Schach mit Koenig schlagen
			beobachtet = k.spielzugMoeglich(sf, new Position(3,0),
					new Position(3, 1));

		} catch (Exception e)
		{
			e.printStackTrace();
			Assert.fail();
		}
		
		//fail("Not yet implemented");
	}
	
public void testSpielzugMoeglich3() {
		
		try
		{
			Spielfeld sf = SpielFeldIO.einlesen("Schach.txt");
			Koenig k = (Koenig) sf.getFigur(1,0);
			
			//selbst ins Schach setzen
			boolean beobachtet = k.spielzugMoeglich(sf, new Position(3,1),
					new Position(3, 2));
			Assert.assertFalse(beobachtet);
			
			//Koenig nicht aus dem Schach bewegen
			beobachtet = k.spielzugMoeglich(sf, new Position(0,1),
					new Position(0, 2));
			Assert.assertFalse(beobachtet);
			
			//Figur bei Schach vorsetzen
			beobachtet = k.spielzugMoeglich(sf, new Position(4,1),
					new Position(4, 2));
			Assert.assertFalse(beobachtet);
			
		} catch (Exception e)
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
