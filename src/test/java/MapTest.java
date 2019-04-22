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
                Assert.assertThat(map.getTileType(new Position(i, j)),
                        anyOf(is(Map.Tile.GRASS), is(Map.Tile.TREASURE), is(Map.Tile.WATER)));
            }
        }
    }

    @Test
    public void test_map_size_change() {
        int k = 6;
        map = new Map(k);
        Assert.assertEquals(k, map.getMapSize());

        int n = 10;
        map.setMapSize(n);
        Assert.assertEquals(n, map.getMapSize());

    }

    @Test
    public void test_to_string() {
        map = new Map(4);
        map.generateMap();

        String mapString = map.toString();
        int tabs = 0, newlines = 0;
        for(char c : mapString.toCharArray()) {
            if("\t".equals(""+c)) {
                tabs++;
            } else if("\n".equals(""+c)) {
                newlines++;
            }
        }

        int size = map.getMapSize();
        Assert.assertTrue(tabs == size * size);
        Assert.assertTrue(newlines == size);
    }

}
