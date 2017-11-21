

import java.io.IOException;
import java.util.Scanner;

public class solution8 {
    public static void main(String args[]){
        System.out.println("*********************************************************");
        System.out.println("          Solutions For Home Assignment # 8              ");
        System.out.println("*********************************************************");

        acceptUserOption();
    }

    private static void acceptUserOption() {
        Scanner reader = new Scanner(System.in);
        int option = -1;
        while(option !=0){
            showSolutionMenu();
            option = reader.nextInt();

            switch (option){
                case 0:
                    break;
                case 1:
                    //FileAnalyzer
                    try{
                        FileAnalyzer.main();
                    } catch (IOException e){
                        e.printStackTrace();
                    }
                    break;
                case 2:
                    //Lyric Analyzer
                    try {
                        LyricAnalyzer.main();
                    } catch (IOException e) {
                        System.out.println("File Errors Encountered......");
                    }
                    break;
                case 3:
                    //transfer into JSON data
                    try {
                        MyJson.main();
                    } catch (IOException e) {
                        System.out.println("File Errors Encountered......");
                    }
                    break;

                default:
                    System.out.println("Please enter a valid option ( 0 - 3 )..........");
            }
        }
    }


    private static void showSolutionMenu() {
        System.out.println("        Which solution do you want to test?              ");
        System.out.println("*********************************************************");
        System.out.println("        1. File Analyzer                                 ");
        System.out.println("        2. Lyric Analyzer                                ");
        System.out.println("        3. MyJson For Vehicles                           ");
        System.out.println("*********************************************************");
        System.out.println("        Press 0 to exit the menu.........................");
    }

}

