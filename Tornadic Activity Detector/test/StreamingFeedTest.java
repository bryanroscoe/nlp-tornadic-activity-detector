import org.junit.Before;
import org.junit.Test;
import twitter4j.TwitterStreamFactory;

public class StreamingFeedTest {

    private StreamingFeed streamingFeed;

    @Before
    public void setUp() throws Exception {
        streamingFeed = new StreamingFeed(new TwitterStreamFactory().getInstance());
    }

    @Test
    public void testListenOnCustomStatusListener(){
        streamingFeed.listenOnCustomStatusListener();
    }

}
