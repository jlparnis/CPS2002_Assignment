import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PlayerTest {

    private Player player;

    @Before
    public void setup() {
        player = new Player(new Position(1,1));
    }

    @After
    public void teardown(){
        player = null;
    }

    @Test
    public void testSame(){
        int x = 6;
        Assert.assertEquals(x, player.same(x));
    }

    @Test
    public void testSame2(){
        int x = 6;
        Assert.assertEquals(6, player.same(x));
    }

    @Test
    public void testSame3(){
        int x = 7;
        Assert.assertEquals(7, player.same(x));
    }
}
