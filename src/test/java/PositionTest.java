import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PositionTest {

    private Position position;

    @Before
    public void setup() {
        position = new Position();
    }

    @After
    public void teardown(){
        position = null;
    }

    @Test
    public void test_x(){
        int x = 1;
        position.x = x;
        Assert.assertEquals(x, position.x);
    }

    @Test
    public void test_y(){
        int y = 2;
        position.y = y;
        Assert.assertEquals(y, position.y);
    }

    @Test
    public void test_toString(){
        position.x = 1;
        position.y = 2;
        Assert.assertEquals("(1, 2)", position.toString());
    }
}
