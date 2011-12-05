import antlr.TokenStreamException;
import bios.common.NercToken;
import bios.common.WordToken;
import bios.nerc.Nerc;
import bios.nerc.namex.NamexConstants;
import bios.tokenizer.Tokenizer;
import edu.stanford.nlp.tagger.maxent.MaxentTagger;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Sanjay
 * Date: 04/12/11
 * Time: 6:50 PM
 * To change this template use File | Settings | File Templates.
 */
public class Bios {
    private static Nerc nerc;
    private static Tokenizer tokenizer;
    private static MaxentTagger maxentTagger;

    public static void initialize() throws Exception, ClassNotFoundException {
        nerc = new Nerc("in/namex" , "conll.paum.ci.model", NamexConstants.PAUM,"in/numex" , false);
        tokenizer = new Tokenizer("in/english.multiwords");
        maxentTagger = new MaxentTagger("in/models/train-wsj-0-18.holder");
    }

    public static String findLocation(String tweet) throws Exception, TokenStreamException {
        List<NercToken> nercTokens = new ArrayList<NercToken>() ;
        List<WordToken> wordTokens = tokenizer.tokenizeWords(tweet);
        String locations = "";

        for (WordToken wordToken : wordTokens)
            nercTokens.add(new NercToken(wordToken.getWord(),"","","",wordToken.getStart(),wordToken.getEnd()));

        String s = maxentTagger.tagString(tweet);
        String[] split = s.split(" ");
        for (int i = 0, splitLength = split.length; i < splitLength; i++) {
            String s1 = split[i];
            String[] wordTag = s1.split("/");
            nercTokens.get(i).setPos(wordTag[1]);
        }

        String[] strings = nerc.predictSentences((ArrayList) nercTokens);
        for (int i = 0, stringsLength = strings.length; i < stringsLength; i++) {
            if("B-LOC".equals(strings[i])){
                locations += (wordTokens.get(i).getWord() + " ");
            }
        }
        return locations;
    }
}