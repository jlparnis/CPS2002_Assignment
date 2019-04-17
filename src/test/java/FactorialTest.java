import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FactorialTest {

    private Factorial factorial;

    @Before
    public void init(){
        factorial = new Factorial();
    }

    @After
    public void null_factorial(){
        factorial = null;
    }

    @Test
    public void test_factorial_small(){
        Assert.assertEquals(120, factorial.factorial(5));
    }

    @Test
    public void test_factorial_large(){
        Assert.assertEquals(479001600, factorial.factorial(12));
    }


}
