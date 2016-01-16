package Testing;


import org.htl.chess.model.Spielfeld;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.htl.chess.model.Position;
import org.htl.chess.model.Spielfeld;
import org.htl.chess.model.Springer;
import org.junit.Assert;
import org.junit.Test;

public class SpringerTest {

	@Test
	public void test() {
		
		testSpielzugMoeglich1();
		testSpielzugMoeglich2();
		
	}
	public void testSpielzugMoeglich1()
	{
		try
		{
			Spielfeld sf = SpielFeldIO.einlesen("Spielfeld-Startposition.txt");
			Springer sp = (Springer) sf.getFigur(1,0);

			// rechts nach vorn
			boolean beobachtet = sp.spielzugMoeglich(sf, new Position(1,0),
					new Position(2, 2));
			Assert.assertTrue(beobachtet);
			System.out.println(beobachtet);
			

			// links nach vorn bei Beginn
			beobachtet = sp.spielzugMoeglich(sf, new Position(1,0),
					new Position(3, 4));
			Assert.assertTrue(beobachtet);

		} catch (FileNotFoundException e)
		{

			e.printStackTrace();
			Assert.fail();
		}
	}

	public void testSpielzugMoeglich2()
	{
		try
		{
			Spielfeld sf = SpielFeldIO.einlesen("Spielfeld-Startposition.txt");
			Springer sp = (Springer) sf.getFigur(1,7);

			// nicht eigene Figur schlagen
			boolean beobachtet = sp.spielzugMoeglich(sf, new Position(1,7),
					new Position(3, 6));
			Assert.assertFalse(beobachtet);

	
		} catch (FileNotFoundException e)
		{

			e.printStackTrace();
			Assert.fail();
		}
	}
}
