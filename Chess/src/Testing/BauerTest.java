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
	
	boolean ausfuehren;
	SpielFeldIO spf=new SpielFeldIO();
	Bauer figur2=new Bauer(true);	
	
	
	@Test
	public void testSpielZug() 
	{
		Position von=new Position(1,1);
		Position nach=new Position(1,2);
		SpielFeldIO.einlesen('B');
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
		Position von=new Position(1,2);
		Position nach=new Position(3,2);
		von.setX(1);
		von.setY(1);
		nach.setX(3);
		nach.setY(2);
		System.out.println(von.getX()+" h "+von.getY());
		System.out.println(nach.getX()+" h "+nach.getY());
		System.out.println(figur2+" h ");
		System.out.println(figur2.spielZugMoeglich(spf, von, nach));
		spf.figurenSetzen(von, figur2);
		ausfuehren=figur2.spielZug(spf, von, nach);	
		assertEquals(ausfuehren,false);
	}
}
