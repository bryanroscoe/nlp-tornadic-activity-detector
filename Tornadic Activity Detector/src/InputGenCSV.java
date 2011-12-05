import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.util.ArrayList;


public class InputGenCSV {
    InputGenCSV(RelevantTweetData relevantTweetData)
	{
		try {
			//parseXmlFile();
            outFile = new String("input/tweet"+ Long.toString(relevantTweetData.getId()) + ".csv");
            bufferedWriter = new BufferedWriter(new FileWriter(outFile));
			readTweetToCSVFile(relevantTweetData);
		}
		catch (IOException e) {e.printStackTrace();	}
	}
    public String outFile;
	private static ArrayList<RelevantTweetData> relevantTweetDatas = new ArrayList<RelevantTweetData>();
	
	private static BufferedWriter bufferedWriter;
	
	public void readTweetToCSVFile(RelevantTweetData relevantTweetData)
	{
        System.out.println(relevantTweetData.getText() + " <-- something should be here");
		String TweetText="", TweetClass="", TweetString="", writeString="";
        try {
            writeString = "Class,text";
            bufferedWriter.write(writeString );
            bufferedWriter.newLine();
        }  catch (IOException e) {e.printStackTrace();}

        TweetText= relevantTweetData.getText();

        try {
            TweetString = TweetText.replaceAll(","," ");
            TweetString = TweetString.replaceAll("\n", " ");
            TweetString = TweetString.replaceAll("\r", " ");
            TweetString = TweetString.replaceAll("&#xd;", " ");
            writeString = "?,"+TweetString;
            bufferedWriter .write(writeString );
            bufferedWriter.newLine();
            bufferedWriter.close();


        } catch (IOException e) {e.printStackTrace();}
			

		System.out.println("Class along with tweets messages is created!!!!!");
	}

//	private static void parseXmlFile() throws ParserConfigurationException,	SAXException, IOException
//	{
//		XStream xStream = new XStream(new DomDriver());
//		BufferedReader bufferedReader = new BufferedReader(new FileReader("XML/annotatedQueryResults.xml"));
//		relevantTweetDatas = (ArrayList<RelevantTweetData>) xStream.fromXML(bufferedReader);
//		//Class1
//		bufferedWriter = new BufferedWriter(new FileWriter("ARFF/TornadoLevelText.csv"));
//
//		//Class2
//		bufferedWriter2 = new BufferedWriter(new FileWriter("ARFF/AboutText.csv"));
//
//		//Class2
//		bufferedWriter3 = new BufferedWriter(new FileWriter("ARFF/SeenText.csv"));
//
//    }
}
