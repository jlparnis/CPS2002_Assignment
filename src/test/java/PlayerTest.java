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
        int x = 6;
        Assert.assertEquals(x, player.same(x));
    }
}
