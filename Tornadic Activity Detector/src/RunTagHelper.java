import edu.cmu.taghelpertools.gui.ProgressDialog;
import edu.cmu.taghelpertools.gui.TestModelFrame;
import edu.cmu.taghelpertools.middle_layer.SavedModelEvaluator;
import java.io.*;
import java.io.File;
import java.io.IOException;
import java.util.StringTokenizer;

/**
 * Created by IntelliJ IDEA.
 * User: bryanroscoe
 * Date: 12/3/11
 * Time: 1:31 PM
 * To change this template use File | Settings | File Templates.
 */
public class RunTagHelper extends TestModelFrame{
    public String theClass;

    public RunTagHelper(String dataFile, long Id)  {
        File modelFile;
        modelFile = new File("input/Class_sanjay.model");
        File testDataFile;
        testDataFile = new File(dataFile);
        String dimName = "Class";
        //TestModelFrame gui = new TestModelFrame();
//        dimName = dimName.replaceAll("\\.model$", "");
//        System.out.print(dimName);
//        ProgressDialog pDialog = new ProgressDialog(null, testDataFile.getName());
//        SavedModelEvaluator evaluator= new SavedModelEvaluator(modelFile, dimName, gui);
//        int flag = evaluator.setUp(pDialog, testDataFile);
//        evaluator.run(pDialog);
//        System.out.print("What?");
        TestModelFrame.Runn runn = new TestModelFrame.Runn(modelFile, testDataFile, dimName, this);
        runn.start();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        //runn.finished();
        runn.interrupt();
        //SUPP_Output_Class_tweet.csv
        //File resultFile = new File("OUTPUT/SUPP_Output_Class_tweet" + Long.toString(Id)+ ".csv");
        try{
        FileInputStream fstream = new FileInputStream("OUTPUT/SUPP_Output_Class_tweet" + Long.toString(Id)+ ".csv");
        DataInputStream in = new DataInputStream(fstream);
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        String strLine = new String(br.readLine());
        strLine = br.readLine();
        String[] stuff = strLine.split(",");
        theClass = stuff[1];

        }
        catch (Exception e){//Catch exception if any
           e.printStackTrace();
          }

        //System.exit(0);

        //pDialog.dispose();
    }
    public void old(){

    }
}
