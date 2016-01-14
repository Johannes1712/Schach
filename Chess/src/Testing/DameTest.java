package Testing;

import static org.junit.Assert.*;

import org.htl.chess.model.Bauer;
import org.htl.chess.model.Dame;
import org.htl.chess.model.Feld;
import org.htl.chess.model.Figur;
import org.htl.chess.model.Position;
import org.htl.chess.model.Spielfeld;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class DameTest 
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

	private Feld[ ] [ ] spielfeld;
	
	public void testSpielZug() 
	{
		fail("Not yet implemented");
	}

	@Test
	public void testSpielzugMoeglich() 
	{
			Spielfeld sf=new Spielfeld(); //SpielfeldIO.einlesen("testdata/bauer_feld1.txt");
			Dame d=new Dame(true);
			Position von=new Position(0,3);
			Position nach=new Position(3,1);
			sf.ausgabe();
			
			boolean beobachtet=d.spielzugMoeglich(sf,von,nach);
			Assert.assertFalse(beobachtet);
			
			nach.setX(9);
			nach.setY(9);
			beobachtet=d.spielzugMoeglich(sf,von,nach);
			Assert.assertFalse(beobachtet);
			
			nach.setX(3);
			nach.setY(3);
			beobachtet=d.spielzugMoeglich(sf, von, nach);
			Assert.assertFalse(beobachtet);
			
			Bauer b=new Bauer(true);
			von.setY(1);
			von.setX(4);
			nach.setX(4);
			nach.setY(2);
			beobachtet=b.spielzugMoeglich(sf, von, nach);
			Assert.assertTrue(beobachtet);
			
			nach.setX(5);
			nach.setY(2);
			beobachtet=b.spielzugMoeglich(sf, von, nach);
			Assert.assertTrue(beobachtet);
	}

}
