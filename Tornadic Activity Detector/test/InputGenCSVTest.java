import org.junit.Before;
import org.junit.Test;

/**
* Created by IntelliJ IDEA.
* User: bryanroscoe
* Date: 12/4/11
* Time: 7:07 PM
* To change this template use File | Settings | File Templates.
*/
public class InputGenCSVTest {

    private RelevantTweetData relevantTweetData;

    @Before
    public void setUp() throws Exception {
        relevantTweetData = new RelevantTweetData();
        relevantTweetData.setText("This is the data of the tweet");
        relevantTweetData.setId(42);

    }

    @Test
    public void testFileCreation(){
        InputGenCSV inputGenCSV = new InputGenCSV(relevantTweetData);

    }
}
