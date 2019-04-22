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
    public void test_player() {
        Position pos = new Position(3, 5);
        player = new Player(pos);

        Assert.assertEquals(pos.x, player.getPosition().x);
        Assert.assertEquals(pos.y, player.getPosition().y);
    }

    @Test
    public void test_move_up() {
        int x = 3, y = 4;
        Position pos = new Position(x, y);
        player = new Player(pos);

        player.move(Player.Move.UP);
        Assert.assertEquals(pos.x, player.getPosition().x);
        Assert.assertEquals(pos.y, player.getPosition().y);

        Assert.assertEquals(x, player.getPosition().x);
        Assert.assertEquals(y + 1, player.getPosition().y);
    }

    @Test
    public void test_move_down() {
        int x = 3, y = 4;
        Position pos = new Position(x, y);
        player = new Player(pos);

        player.move(Player.Move.DOWN);
        Assert.assertEquals(pos.x, player.getPosition().x);
        Assert.assertEquals(pos.y, player.getPosition().y);

        Assert.assertEquals(x, player.getPosition().x);
        Assert.assertEquals(y - 1, player.getPosition().y);
    }

    @Test
    public void test_move_left() {
        int x = 3, y = 4;
        Position pos = new Position(x, y);
        player = new Player(pos);

        player.move(Player.Move.LEFT);
        Assert.assertEquals(pos.x, player.getPosition().x);
        Assert.assertEquals(pos.y, player.getPosition().y);

        Assert.assertEquals(x - 1, player.getPosition().x);
        Assert.assertEquals(y, player.getPosition().y);
    }

    @Test
    public void test_move_right() {
        int x = 3, y = 4;
        Position pos = new Position(x, y);
        player = new Player(pos);

        player.move(Player.Move.RIGHT);
        Assert.assertEquals(pos.x, player.getPosition().x);
        Assert.assertEquals(pos.y, player.getPosition().y);

        Assert.assertEquals(x + 1, player.getPosition().x);
        Assert.assertEquals(y, player.getPosition().y);
    }

    @Test
    public void test_set_pos() {
        Position pos = new Position(3,4);

        player.setPosition(pos);
        Assert.assertEquals(pos, player.getPosition());
    }

    @Test
    public void test_set_reset_pos() {
        int x = 4, y = 5;
        Position pos = new Position(x, y);

        player = new Player(pos);
        player.move(Player.Move.UP);
        player.move(Player.Move.LEFT);
        player.resetStartingPos();

        Assert.assertEquals(x, player.getPosition().x);
        Assert.assertEquals(y, player.getPosition().y);
    }
}
