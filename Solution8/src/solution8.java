

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

                    break;
                case 3:

                    break;
                case 4:

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
        System.out.println("        3. Set up a controller for a device              ");
        System.out.println("        4. Pascal’s triangle                             ");
        System.out.println("        5. Find Partition                                ");
        System.out.println("*********************************************************");
        System.out.println("        Press 0 to exit the menu.........................");
    }

}

