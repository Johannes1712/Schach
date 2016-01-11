package Testing;

import static org.junit.Assert.*;

import org.htl.chess.model.Spielfeld;
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
			Spielfeld sf = SpielFeldIO.einlesen("testdata/bauer_feld1.txt");
			sf.setWeissNachOben(false);
			Bauer b = (Bauer) sf.getFeld(3, 6);

			// 3 nach vorn
			boolean beobachtet = b.spielzugMoeglich(sf, new Position(3, 6),
					new Position(3, 3));
			Assert.assertFalse(beobachtet);

			// 2 nach vorn bei Beginn
			beobachtet = b.spielzugMoeglich(sf, new Position(3, 6),
					new Position(3, 4));
			Assert.assertTrue(beobachtet);

			// 1 nach vorn bei Beginn
			beobachtet = b.spielzugMoeglich(sf, new Position(3, 6),
					new Position(3, 5));
			Assert.assertTrue(beobachtet);

			// 1x Diagonal wenn keine Figur auf Zielfeld steht LINKS
			beobachtet = b.spielzugMoeglich(sf, new Position(3, 6),
					new Position(4, 5));
			Assert.assertFalse(beobachtet);

			// 1x Diagonal wenn keine Figur auf Zielfeld steht LINKS
			beobachtet = b.spielzugMoeglich(sf, new Position(3, 6),
					new Position(7, 5));
			Assert.assertFalse(beobachtet);
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
			SpielFeld sf = SpielFeldIO.einlesen("testdata/bauer_feld2.txt");
			sf.setWeissNachOben(false);
			Bauer b = (Bauer) sf.getFeld(3, 6);

			// 1x Diagonal wenn gegnerische Figur auf Zielfeld steht LINKS
			boolean beobachtet = b.spielzugMoeglich(sf, new Position(3, 6),
					new Position(4, 5));
			Assert.assertTrue(beobachtet);

			b = (Bauer) sf.getFeld(4, 6);
			beobachtet = b.spielzugMoeglich(sf, new Position(4, 6),
					new Position(4, 5));

		} catch (FileNotFoundException e)
		{

			e.printStackTrace();
			Assert.fail();
		}
	}
}
