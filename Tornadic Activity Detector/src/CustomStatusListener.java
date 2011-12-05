import twitter4j.Status;
import twitter4j.StatusDeletionNotice;
import twitter4j.StatusListener;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


public class CustomStatusListener implements StatusListener{

    public void onStatus(Status status) {
        //System.out.println(status.getText());
        BufferedWriter bufferedWriter = null;
        try {
            bufferedWriter = new BufferedWriter(new FileWriter("OUTPUT/onlineTornadoTweetAnalyzer", true));
        } catch (IOException e) {
            e.printStackTrace();
        }
        RelevantTweetData relevantTweetData = new RelevantTweetData();
        relevantTweetData.setText(status.getText());
        //relevantTweetData.setFromUser(status.getFromUser());
        relevantTweetData.setCreatedAt(status.getCreatedAt());
        relevantTweetData.setGeoLocation(status.getGeoLocation());
        relevantTweetData.setPlace(status.getPlace());
        relevantTweetData.setAnnotate(" ");
        relevantTweetData.setId(status.getId());
        InputGenCSV csvGen = new InputGenCSV(relevantTweetData);
        RunTagHelper steadyRunnin = new RunTagHelper(csvGen.outFile, status.getId());
        relevantTweetData.setTornadoLevel(steadyRunnin.theClass);
        System.out.println(status.getText());
        System.out.println("The class is:" + steadyRunnin.theClass);
        String location = null;
        try {
            location = Bios.findLocation(relevantTweetData.getText());
        } catch (Exception e) {e.printStackTrace();}
        if(!"".equals(location))  {
            System.out.println(location);
            relevantTweetData.setLocation(location);
        }

        try {
                bufferedWriter.write(status.getText() + "\n");
                if("one".equals(steadyRunnin.theClass))
                    bufferedWriter.write("Class: Conditions for Tornado Exist\n");
                else if("zero".equals(steadyRunnin.theClass))
                    bufferedWriter.write("Class: Unrelated to tornado\n");
                else if("two".equals(steadyRunnin.theClass))
                    bufferedWriter.write("Class: Tornado Likely Forming.\n");
                else if("three".equals(steadyRunnin.theClass))
                    bufferedWriter.write("Class: HOLY CRAP a Tornado!\n");
                if(!"".equals(location))
                    bufferedWriter.write("Location:" + location);
//                else
//                    bufferedWriter.write("Location: Unknown");

                bufferedWriter.write("\n\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        try {
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void onDeletionNotice(StatusDeletionNotice statusDeletionNotice) {

    }

    public void onTrackLimitationNotice(int i) {

    }

    public void onScrubGeo(long l, long l1) {

    }

    public void onException(Exception e) {

    }
}
