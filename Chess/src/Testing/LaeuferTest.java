package Testing;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.htl.chess.model.Laeufer;
import org.htl.chess.model.Position;
import org.htl.chess.model.Spielfeld;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class LaeuferTest
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

	@Test
	public void testSpielZug() throws FileNotFoundException 
	{
		boolean ausfuehren;
		Laeufer figur=new Laeufer(true);
		Spielfeld spf= SpielFeldIO.einlesen("Spielfeld-Startposition.txt");
		SpielFeldIO.leseFeld("LW");
		Position von=new Position(1,1);
		Position nach=new Position(2,2);
		ausfuehren=figur.spielZug(spf, von, nach);	
		
		assertEquals(ausfuehren,true);	
	}

	@Test
	public void testSpielZugMoeglich() throws FileNotFoundException 
	{
		boolean ausfuehren;
		Laeufer figur=new Laeufer(true);
		Spielfeld spf= SpielFeldIO.einlesen("Spielfeld-Startposition.txt");
		SpielFeldIO.leseFeld("LW");
		Position von=new Position(1,1);
		Position nach=new Position(2,2);
		ausfuehren=figur.spielZugMoeglich(spf, von, nach);	
		assertEquals(ausfuehren,true);	
	}

}
