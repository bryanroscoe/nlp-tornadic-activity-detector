import org.junit.Test;

/**
 * Created by IntelliJ IDEA.
 * User: bryanroscoe
 * Date: 12/4/11
 * Time: 8:06 PM
 * To change this template use File | Settings | File Templates.
 */
public class BiosTest {
    @Test
    public void testBios() throws Exception {
        Bios.initialize();
        String locations;
        locations = Bios.findLocation("i come. i fuck shit up. i leave. #tornado Beauchamp.");
        System.out.println(locations);
    }
}
