import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;


public class LyricAnalyzer {
    private HashMap<String, ArrayList<Integer>> map;

    public LyricAnalyzer() {
        this.map = new HashMap<>();
    }

    public static void main() throws IOException{
        LyricAnalyzer la = new LyricAnalyzer();
        la.read(new File("./src/Question2_test2.txt"));
        System.out.println("unique words: " + la.count());
        System.out.println("most frequently word: " + la.mostFrequentWord());
        System.out.println();
        la.displayWords();
        File newfile = new File("./outputFiles/lyrics.txt");
        la.writeLyrics(newfile);
    }

    public void read(File file) throws FileNotFoundException, IOException {
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        int pos = 1; //initialize the word position
        String line;
        while (true) {
            line = br.readLine();
            if (line == null) {
                break;
            }
            String[] words = line.toUpperCase().split(" ");
            for (int i = 0; i < words.length; ++i) {
                if (i == words.length - 1) {
                    add(words[i], -pos);
                } else add(words[i], pos);
                pos++;
            }
        }
        br.close();
        fr.close();

    }

    private void displayWords() {
        String[] words = new String[map.size()];
        map.keySet().toArray(words);
        Arrays.sort(words);
        for (String word : words) {
            StringBuilder sb = new StringBuilder();
            sb.append(word).append(": ");
            //enclosed in square brackets ("[]")
            String list = map.get(word).toString();
            sb.append(list.substring(1, list.length() - 1));
            System.out.println(sb.toString());
        }
    }


    private void add(String word, int wordPosition) {
        if (!map.containsKey(word)) {
            ArrayList<Integer> pos=new ArrayList<>();
            pos.add(wordPosition);
            map.put(word, pos);
        } else {
            map.get(word).add(wordPosition);
        }
    }


    private int count() {
        return map.size();
    }

    private String mostFrequentWord() {
        int count = 0;
        String str = "";
        for (String s : map.keySet()) {
            if (map.get(s).size() > count) {
                count = map.get(s).size();
                str = s;
            }
        }
        return str;
    }

    private void writeLyrics(File file) throws IOException {
        int n = 0;
        for (ArrayList<Integer> a : map.values()) {
            n += a.size();
        }
        String[] words = new String[n + 1];
        Arrays.fill(words, "");
        for (String s : map.keySet()) {
            for (Integer i : map.get(s)) {
                if (i < 0) {
                    words[-i] = s.toUpperCase() + " " + "\n";
                } else words[i] = s.toUpperCase() + " ";
            }
        }
        FileWriter fw = new FileWriter(file);
        PrintWriter pw = new PrintWriter(fw);
        for (int i = 1; i < words.length; ++i) {
            pw.print(words[i]);
        }

        fw.close(); //close the file writer stream
        pw.close(); //close the print writer stream
    }
}
