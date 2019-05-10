import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class HazardousMapTest {

    private Map map;

    @Before
    public void setup() {
        map = new HazardousMap();
    }

    @After
    public void teardown() {
        map = null;
    }

    @Test
    public void test_map_size() {
        int n = 10;
        map = new HazardousMap(n);
        Assert.assertEquals(n, map.getMapSize());
    }

}
