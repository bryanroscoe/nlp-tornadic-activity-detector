import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;


public class InputGenARFF {
	InputGenARFF ()
	{
		try {
			parseXmlFile();
			readXMLtoTextfile();
		} 
		catch (ParserConfigurationException e) {	e.printStackTrace();} 
		catch (SAXException e) {e.printStackTrace();} 
		catch (IOException e) {e.printStackTrace();	}
	}
	private static ArrayList<RelevantTweetData> relevantTweetDatas = new ArrayList<RelevantTweetData>();
	
	private static BufferedWriter bufferedWriter1, bufferedWriter2, bufferedWriter3  ;
	
	public void readXMLtoTextfile()
	{
		String TweetText="", TweetClass1="", TweetClass2="", TweetClass3="", TweetString="", writeString="";
        try {
            writeString = "class,text";
            bufferedWriter1 .write(writeString );
            bufferedWriter1.newLine();
            bufferedWriter2 .write(writeString );
            bufferedWriter2.newLine();
            bufferedWriter3.write(writeString );
            bufferedWriter3.newLine();
        }  catch (IOException e) {e.printStackTrace();}
		for(int i=0;i<relevantTweetDatas.size(); i++)
		{
			RelevantTweetData relevantTweetData = relevantTweetDatas.get(i);
			TweetText= relevantTweetData.getText();
			TweetClass1= relevantTweetData.getTornadoLevel();
			TweetClass2= relevantTweetData.getAboutTornado();
			TweetClass3= relevantTweetData.getSeenTornado();

            if(TweetClass1.equals("0"))
                TweetClass1 = "zero";
			if(TweetClass1.equals("1")  )
                TweetClass1 = "one";
            if(TweetClass1.equals("2") )
                TweetClass1 = "two";
            if(TweetClass1.equals("3") )
                TweetClass1 = "three";


			try {
				TweetString = TweetText.replaceAll(","," ");
				TweetString = TweetString.replaceAll("\n", " ");
                TweetString = TweetString.replaceAll("\r", " ");
                TweetString = TweetString.replaceAll("&#xd;", " ");
				writeString = TweetClass1+","+TweetString;
				bufferedWriter1 .write(writeString );
				bufferedWriter1.newLine();
				
				//class2
				writeString = TweetClass2+","+TweetString;
				bufferedWriter2 .write(writeString );
				bufferedWriter2.newLine();
				
				//class3
				writeString = TweetClass3+","+TweetString;
				bufferedWriter3.write(writeString );
				bufferedWriter3.newLine();
				
			} catch (IOException e) {e.printStackTrace();}
			
		}
		System.out.println("Class along with tweets messages is created!!!!!");
	}
	
	private static void parseXmlFile() throws ParserConfigurationException,	SAXException, IOException 
	{
		XStream xStream = new XStream(new DomDriver());
		BufferedReader bufferedReader = new BufferedReader(new FileReader("XML/annotatedQueryResults.xml"));
		relevantTweetDatas = (ArrayList<RelevantTweetData>) xStream.fromXML(bufferedReader);	 
		//Class1
		bufferedWriter1 = new BufferedWriter(new FileWriter("ARFF/TornadoLevelText.csv"));
		
		//Class2
		bufferedWriter2 = new BufferedWriter(new FileWriter("ARFF/AboutText.csv"));
		
		//Class2
		bufferedWriter3 = new BufferedWriter(new FileWriter("ARFF/SeenText.csv"));
		
}
	public static void main(String[] args) {
		new InputGenARFF();
	}
}
