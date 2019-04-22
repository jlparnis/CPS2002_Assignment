import org.hamcrest.Matcher;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.*;

public class MapTest {
    private Map map;

    @Before
    public void setup() {
        map = new Map();
    }

    @After
    public void teardown() {
        map = null;
    }

    @Test
    public void test_map_size() {
        int n = 10;
        map = new Map(n);
        Assert.assertEquals(n, map.getMapSize());
    }

    @Test
    public void test_map_all_tiles() {
        map = new Map(4);
        map.generateMap();

        for(int i = 0; i < map.getMapSize(); i++) {
            for(int j = 0; j < map.getMapSize(); j++) {
                Assert.assertThat(map.getTileType(i, j),
                        anyOf(is(Map.Tile.GRASS), is(Map.Tile.TREASURE), is(Map.Tile.WATER)));
            }
        }
    }

}
