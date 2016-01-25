package Testing;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ BauerTest.class, DameTest.class, FigurTest.class, KoenigTest.class, LaeuferTest.class,
		SpringerTest.class, TurmTest.class })
public class AllTests {

}
