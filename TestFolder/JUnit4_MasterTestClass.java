import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ 
        JUnit4_TestClassA.class,
    })


public class JUnit4_MasterTestClass {
    //Empty, as this class is just a holder for the annotations above.
}
