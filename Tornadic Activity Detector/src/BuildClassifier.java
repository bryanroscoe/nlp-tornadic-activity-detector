/**
 * Created by IntelliJ IDEA.
 * User: bryanroscoe
 * Date: 11/28/11
 * Time: 4:57 PM
 * To change this template use File | Settings | File Templates.
 */

import weka.classifiers.Evaluation;
import weka.classifiers.functions.SMO;
import weka.core.SerializationHelper;
import weka.core.converters.ConverterUtils.DataSource;
import weka.core.Instances;
import weka.classifiers.functions.supportVector.PolyKernel;

import java.util.Random;


public class BuildClassifier {
    Instances data;
    SMO classifier;
    public BuildClassifier() throws Exception {
        readArff();
        filterData();
        build();
        save();
    }

    public void readArff() throws Exception {
        //data = DataSource.read("input/dataset.arff");
        DataSource source = new DataSource("input/dataset.arff");
        data = source.getDataSet();
        data.setClassIndex(data.numAttributes() - 1);

    }
    public void filterData(){

    }
    public void build() throws Exception {
        classifier = new SMO();
//        String[] options ={
//            "-C 1.0",
//            "-L 0.0010",
//            "-P 1.0E-12",
//            "-N 0",
//            "-V -1",
//            "-W 1",
//            "-K \"weka.classifiers.functions.supportVector.PolyKernel -C 250007 -E 1.0\""
//        };
        //String[] options = weka.core.Utils.splitOptions("-C 1.0 -L 0.0010 -P 1.0E-12 -N 0 -V -1 -W 1 -K weka.classifiers.functions.supportVector.PolyKernel -C 250007 -E 1.0");
        classifier.setOptions(weka.core.Utils.splitOptions("-D -C 1.0 -L 0.0010 -P 1.0E-12 -N 0 -V -1 -W 1 -K \"weka.classifiers.functions.supportVector.PolyKernel -C 250007 -E 1.0\""));
        classifier.buildClassifier(data);
        //Evaluation eval = new Evaluation(data);
        //eval.crossValidateModel(classifier, data, 10, new Random(1));
        //System.out.println(eval.toSummaryString("\nResults\n======\n", false));


    }
    public void save() throws Exception {
        SerializationHelper.write("output/classifier.model", classifier);

    }

    public static void main(String[] args) throws Exception {
        BuildClassifier buildClassifier = new BuildClassifier();

    }
}
