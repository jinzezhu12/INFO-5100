import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class LyricAnalyzer {
    //data storage declaration
    private HashMap<String , ArrayList<Integer>> map;


    public LyricAnalyzer(){
        super();
        this.map = new HashMap<String, ArrayList<Integer>>();
    }

    public static void main() throws IOException{
        LyricAnalyzer la = new LyricAnalyzer();
        String fPath = "./src/Question2_test1.txt"; // retrieve the input file
        File testFile = new File(testFilePath);

        la.read(testFile); // reading testFile
        la.displayWords(); // use LyricAnalyzer to print results

        //print out the lyric stats
        System.out.println(String.format("The count of Unique Words: %d", la.count()));
        System.out.println(String.format("Most Frequent Word: %s"+la.mostFreqWord()));

        //switch the file path to the output file
        fPath = "./src/Question2_output.txt";
        testFile = new File(fPath);
        testFile.createNewFile();
        la.writeLyrics(testFile);
    }

    private void read(File testFile) throws IOException {
    }

    private void add(String word, int wordPosition){

    }

    private writeLyrics(File file) throws IOException{
        
    }
}
