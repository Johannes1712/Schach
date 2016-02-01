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
	public void testSpielzugMoeglich1() { //weiﬂe Rochaden (richtig)

		try
		{
			Spielfeld sf = SpielFeldIO.einlesen("SchachRM.txt");
			Koenig k = (Koenig) sf.getFigur(3,7);
			
			//kleine Rochade weiﬂ
			boolean beobachtet = k.spielzugMoeglich(sf, new Position(3,7),
					new Position(1, 7));
			Assert.assertTrue(beobachtet);
			
			//groﬂe Rochade weiﬂ
			beobachtet = k.spielzugMoeglich(sf, new Position(3,7),
					new Position(5, 7));
			Assert.assertTrue(beobachtet);
			
		} catch (Exception e)
		{

			e.printStackTrace();
			Assert.fail();
		}
		
	}
	
	public void testSpielzugMoeglich2() { //schwarze Rochaden (richtig)

		try
		{
			Spielfeld sf = SpielFeldIO.einlesen("SchachRM.txt");
			Koenig k = (Koenig) sf.getFigur(3,0);
			
			//kleine Rochade schwarz
			boolean beobachtet = k.spielzugMoeglich(sf, new Position(3,0),
					new Position(1, 0));
			Assert.assertTrue(beobachtet);
			
			//groﬂe Rochade schwarz
			beobachtet = k.spielzugMoeglich(sf, new Position(3,0),
					new Position(5, 0));
			Assert.assertTrue(beobachtet);
			
		} catch (Exception e)
		{

			e.printStackTrace();
			Assert.fail();
		}
		
	}
	
	public void testSpielzugMoeglich3() { //weiﬂe Rochaden (falsch)

		try
		{
			Spielfeld sf = SpielFeldIO.einlesen("SchachRNM.txt");
			Koenig k = (Koenig) sf.getFigur(3,7);
			

			//kleine Rochade weiﬂ
			boolean beobachtet = k.spielzugMoeglich(sf, new Position(3,7),
					new Position(1, 7));
			Assert.assertFalse(beobachtet);
			
			//groﬂe Rochade weiﬂ
			beobachtet = k.spielzugMoeglich(sf, new Position(3,7),
					new Position(5,7));
			Assert.assertFalse(beobachtet);
			
			//aus dem Schach mit Koenig schlagen
			beobachtet = k.spielzugMoeglich(sf, new Position(3,7),
					new Position(3, 6));
			Assert.assertTrue(beobachtet);
			
		} catch (Exception e)
		{

			e.printStackTrace();
			Assert.fail();
		}
		
	}
	
	public void testSpielzugMoeglich4() { //schwarze Rochaden (falsch)

		try
		{
			Spielfeld sf = SpielFeldIO.einlesen("SchachRNM.txt");
			Koenig k = (Koenig) sf.getFigur(3,7);

			//kleine Rochade schwarz
			boolean beobachtet = k.spielzugMoeglich(sf, new Position(3,7),
					new Position(1, 7));
			Assert.assertFalse(beobachtet);
			
			//groﬂe Rochade schwarz
			beobachtet = k.spielzugMoeglich(sf, new Position(3,7),
					new Position(5, 7));
			Assert.assertFalse(beobachtet);
			
		} catch (Exception e)
		{

			e.printStackTrace();
			Assert.fail();
		}
		
	}
	
	public void testSpielzugMoeglich5() {
		
		try
		{
			Spielfeld sf = SpielFeldIO.einlesen("Schach.txt");
			Koenig k = (Koenig) sf.getFigur(3,1);
			
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
			Assert.assertTrue(beobachtet);
			
		} catch (Exception e)
		{
			e.printStackTrace();
			Assert.fail();
		}
		
	}

	@Test
	public void testSpielzug() {
		
		testSpielzugMoeglich1();
		testSpielzugMoeglich2();
		testSpielzugMoeglich3();
		testSpielzugMoeglich4();
		testSpielzugMoeglich5();
	}

}
