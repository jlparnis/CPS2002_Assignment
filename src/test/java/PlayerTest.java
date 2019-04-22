import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PlayerTest {

    private Player player;

    @Before
    public void setup() {
        player = new Player();
    }

    @After
    public void teardown(){
        player = null;
    }

    @Test
    public void testSame(){
        int x = 4;
        Assert.assertEquals(x, player.same(x));
    }

    @Test
    public void testSame2(){
        int x = 6;
        Assert.assertEquals(1, player.same(x));
    }

    @Test
    public void testSame3(){
        int x = 7;
        Assert.assertEquals(2, player.same(x));
    }
}
