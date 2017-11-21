import java.io.IOException;
import java.util.Scanner;

public class FileCounter {
    private int characterCount;
    private int wordCount;
    private int lineCount;

    public FileCounter(){
        //initialize the file counter's variables
        this.characterCount = 0;
        this.wordCount = 0;
        this.lineCount = 0;
    }

    //getters for declared variables
    public int getCharacterCount() {
        return characterCount;
    }

    public int getLineCount() {
        return lineCount;
    }

    public int getWordCount() {
        return wordCount;
    }

    //read test file
    public void readFile(Scanner scanner) throws IOException{
        StringBuilder  stringBuilder = new StringBuilder();
            while(scanner.hasNextLine()){
                stringBuilder.append(scanner.nextLine());;
                stringBuilder.append(" ");
                lineCount++;
            }

            String a = stringBuilder.toString().trim();
            if(a.length()==0){
                return;
            }
            else
                wordCount++;
                for(int i = 0; i < a.length(); i++){
                    if(a.charAt(i) != ' ')
                        characterCount++;
                    else{
                        if(a.charAt(i+1) != ' ')
                            wordCount++;
                    }
                }
    }
}
