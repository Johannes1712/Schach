package Testing;

import org.htl.chess.model.*;
import java.io.*;
import org.htl.chess.model.*;
import org.junit.*;

public class SpringerTest 
{

	@Test
	public void test() 
	{
		
		testSpielzugMoeglich1();
		testSpielzugMoeglich2();
		
	}
	public void testSpielzugMoeglich1()
	{
		try
		{
			Spielfeld sf = SpielFeldIO.einlesen("Spielfeld-Startposition.txt");
			Springer sp = (Springer) sf.getFigur(0,1);

			// rechts nach vorn
			boolean beobachtet = sp.spielzugMoeglich(sf, new Position(0,1),new Position(2, 2));
			Assert.assertTrue(beobachtet);

			// links nach vorn bei Beginn
			beobachtet = sp.spielzugMoeglich(sf, new Position(0,1),new Position(2,0));
			System.out.println("Farbe: "+sp.getFarbeW());
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
			Springer sp = (Springer) sf.getFigur(7,1);
			
			boolean beobachtet = sp.spielzugMoeglich(sf, new Position(7,1),new Position(4,3));
			Assert.assertFalse(beobachtet);

		} catch (FileNotFoundException e)
		{
			e.printStackTrace();
			Assert.fail();
		}
	}
}
