import org.apache.log4j.Logger;
import twitter4j.FilterQuery;
import twitter4j.Tweet;
import twitter4j.TwitterStream;
import twitter4j.TwitterStreamFactory;

import java.util.List;

public class StreamingFeed {

    private TwitterStream instance;
    private List<Tweet> tweetList;
    private static Logger logger = Logger.getLogger(StreamingFeed.class.getName());

    public StreamingFeed(TwitterStream instance) {
        this.instance = instance;
    }

    public void listenOnCustomStatusListener() {
        instance.addListener(new CustomStatusListener());
        FilterQuery filterQuery = new FilterQuery();
        String[] keywords = new String[]{"tornado"};
        filterQuery.track(keywords);
        instance.filter(filterQuery);
    }

    public static void main(String[] args) throws Exception {
        StreamingFeed streamingFeed = new StreamingFeed(new TwitterStreamFactory().getInstance());
        Bios.initialize();
        streamingFeed.listenOnCustomStatusListener();
    }
}