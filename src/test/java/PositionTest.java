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
        position.setX(x);
        Assert.assertEquals(x - 1, position.getX());
    }

    @Test
    public void test_y(){
        int y = 2;
        position.setY(y);
        Assert.assertEquals(y, position.getY());
    }

    @Test
    public void test_toString(){
        position.setX(1);
        position.setY(2);
        Assert.assertEquals("(1, 2)", position.toString());
    }
}
