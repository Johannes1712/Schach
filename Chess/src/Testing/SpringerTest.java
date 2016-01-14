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
		fail("Not yet implemented");
	}
	public void testSpielzugMoeglich1()
	{
		try
		{
			Spielfeld sf = SpielFeldIO.einlesen("testdata/springer.txt");
			Springer sp = (Springer) sf.getFigur(1,0);

			// rechts nach vorn
			boolean beobachtet = sp.spielzugMoeglich(sf, new Position(1,0),
					new Position(2, 2));
			Assert.assertFalse(beobachtet);

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
			Spielfeld sf = SpielFeldIO.einlesen("testdata/bauer_feld2.txt");
			Springer b = (Springer) sf.getFigur(3, 6);

			// 1x Diagonal wenn gegnerische Figur auf Zielfeld steht LINKS
			boolean beobachtet = b.spielzugMoeglich(sf, new Position(3, 6),
					new Position(4, 5));
			Assert.assertTrue(beobachtet);

			//b = (Bauer) sf.getFigur(4, 6);
			beobachtet = b.spielzugMoeglich(sf, new Position(4, 6),
					new Position(4, 5));

		} catch (FileNotFoundException e)
		{

			e.printStackTrace();
			Assert.fail();
		}
	}
}
