import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SafeMapTest {
    private Map map;

    @Before
    public void setup() {
        map = new SafeMap();
    }

    @After
    public void teardown() {
        map = null;
    }

    @Test
    public void test_map_size() {
        int n = 10;
        map = new SafeMap(n);
        Assert.assertEquals(n, map.getMapSize());
    }

}
