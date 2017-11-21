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
        File testFile = new File(fPath);

        la.read(testFile); // reading testFile
        la.displayWords(); // use LyricAnalyzer to print results

        //print out the lyric stats
        System.out.println(String.format("The count of Unique Words: %d", la.uniqueCount()));
        System.out.println(String.format("Most Frequent Word: %s"+la.mostFreqWord()));

        //switch the file path to the output file
        fPath = "./src/Question2_output.txt";
        testFile = new File(fPath);
        testFile.createNewFile();
        la.writeLyrics(testFile);
    }

    private void read(File testFile) throws IOException {
        FileInputStream fis = new FileInputStream(testFile);
        int count = 1; //initialize the counter
        StringBuilder lyricWord = new StringBuilder();
        while(true){
            int tmp = fis.read();
            if(tmp == -1){
                add(lyricWord.toString(), -count);
            }
            if(tmp == 32){
                add(lyricWord.toString(), count);
                count++;
                lyricWord.delete(0, lyricWord.length());
            }
            else if (tmp == 10 || tmp == 13) {
                fis.read();
                add(lyricWord.toString(), -count);
                count++;
                lyricWord.delete(0, lyricWord.length());
            }
            else {
                lyricWord.append((char) tmp);
            }
            fis.close();
        }
    }

    //Writing lyrics
    private void writeLyrics(File file) throws IOException{
        int total = 0; //initialize the total lyrics
        List<String> words = new ArrayList<String>(map.keySet());
        for (String word : words)
            total += map.get(word).size();
        String[] lyric = new String[total + 1];
        Set<String> wordSet = map.keySet();
        for (String word : wordSet) {
            ArrayList<Integer> currentWordPosition = map.get(word);
            for (int i = 0; i < currentWordPosition.size(); i++)
                if (currentWordPosition.get(i) > 0)
                    lyric[currentWordPosition.get(i)] = word + " ";
                else
                    lyric[-currentWordPosition.get(i)] = word + "\n";
        }

        FileOutputStream fos = new FileOutputStream(file, true);
        for (int i = 1; i < lyric.length; i++) {
            byte[] b = lyric[i].getBytes();
            fos.write(b);
        }
        fos.close();
    }

    //display sorted words to the console
    public void displayWords() {
        System.out.println("Word          Word Position(s)");
        System.out.println("==============================");
        List<String> words = new ArrayList<String>(map.keySet());
        Collections.sort(words);
        for (String word : words) {
            System.out.print(word);
            int spaceLength = 14 - word.length();
            for (int i = 0; i < spaceLength; i++)
                System.out.print(" ");
            System.out.println(map.get(word).toString());
        }
    }
    //add word to specific location
    private void add(String word, int wordPosition){
        if (map.containsKey(word)) {
            map.get(word).add(wordPosition);
        }
        else {
            map.put(word, new ArrayList<Integer>());
            map.get(word).add(wordPosition);
        }
    }

    //get the word which is used most frequently
    private String mostFreqWord(){
        Set<String> words = map.keySet();
        int max = 0;
        String index = new String();
        for (String word : words) {
            if (map.get(word).size() > max) {
                max = map.get(word).size();
                index = word;
            }
        }
        return index;
    }

    //Count the unique words
    private int uniqueCount(){
        int total = 0;
        List<String> words = new ArrayList<String>(map.keySet());
        for (String word : words)
            total += map.get(word).size();
        System.out.println("Total words count: " + total);
        for (int i = 0; i < words.size(); i++)
            words.set(i, words.get(i).toUpperCase());
        LinkedHashSet<String> set = new LinkedHashSet<String>(words);
        words = new ArrayList<String>(set);
        return words.size();
    }


}
