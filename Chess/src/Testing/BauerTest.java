package Testing;


import static org.junit.Assert.*;

import org.htl.chess.model.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class BauerTest 
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
	public void testSpielZug() 
	{
		boolean ausfuehren;
		Spielfeld spf=new Spielfeld();
		Bauer figur2=new Bauer(true);
		spf.ausgabe();
		Position von=new Position();
		Position nach=new Position();
		von.setX(1);
		von.setY(1);
		nach.setX(1);
		nach.setY(2);
		System.out.println(von.getX()+" h "+von.getY());
		System.out.println(nach.getX()+" h "+nach.getY());
		System.out.println(figur2+" h ");
		System.out.println(figur2.spielZug(spf, von, nach));
		ausfuehren=figur2.spielZug(spf, von, nach);	
		assertEquals(ausfuehren,true);		
	}

	@Test
	public void testSpielZugMoeglich() 
	{
		
	}
}
