package Testing;

import org.htl.chess.model.*;
import java.io.*;
import org.htl.chess.model.*;
import org.junit.*;

public class FigurTest {

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
			Springer sp = (Springer) sf.getFigur(0,1);

			// über das Spielfeld hinaus
			boolean beobachtet = sp.spielzugMoeglich(sf, new Position(0,1),new Position(10, 27));
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
			Spielfeld sf = SpielFeldIO.einlesen("Spielfeld-Startposition.txt");
			Springer sp = (Springer) sf.getFigur(7,1);
			
			// nicht dieselbe Figur schlagen
			boolean beobachtet = sp.spielzugMoeglich(sf, new Position(7,1),new Position(6,3));
			Assert.assertFalse(beobachtet);


		} catch (FileNotFoundException e)
		{
			e.printStackTrace();
			Assert.fail();
		}
	}
}
