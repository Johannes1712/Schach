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
		Bauer figur=(Bauer) new Figur();
		Spielfeld spf=new Spielfeld();
		Position von=new Position();
		Position nach=new Position();
		
		assert(figur.spielzugMoeglich(spf, von, nach));
		
		fail("Not yet implemented");
	}

	@Test
	public void testSpielZugMoeglich() 
	{
		fail("Not yet implemented");
	}
}
