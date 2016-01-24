package Testing;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.htl.chess.model.Bauer;
import org.htl.chess.model.Dame;
import org.htl.chess.model.Feld;
import org.htl.chess.model.Figur;
import org.htl.chess.model.Position;
import org.htl.chess.model.Spielfeld;
import org.htl.chess.model.Springer;
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
		try
		{
			Spielfeld sf = SpielFeldIO.einlesen("Spielfeld-Startposition.txt");
			// Dame d=new Dame(true);
			Dame d = (Dame) sf.getFigur(4,0);	
			
			boolean beobachtet=d.spielzugMoeglich(sf,new Position(4,0),new Position(4,1));
			Assert.assertFalse(beobachtet);
			

			beobachtet=d.spielzugMoeglich(sf,new Position(4,0),new Position(9,9));
			Assert.assertFalse(beobachtet);
			
			beobachtet=d.spielzugMoeglich(sf,new Position(4,0),new Position(4,2));
			Assert.assertFalse(beobachtet);
			
			Bauer b=new Bauer(true);
			b = (Bauer) sf.getFigur(5,1);
			beobachtet=b.spielzugMoeglich(sf, new Position(5,1), new Position(5,2));
			Assert.assertTrue(beobachtet);
			
			beobachtet=b.spielzugMoeglich(sf, new Position(4,0), new Position(6,2));
			Assert.assertTrue(beobachtet);
			
	}
	catch(FileNotFoundException e)
	{
		e.printStackTrace();
		Assert.fail();
	}
	}

}
