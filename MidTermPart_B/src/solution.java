import Questions.Question_1;
import Questions.Question_2;
import Questions.Question_3;
import Questions.Question_4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class solution {
    public static void main(String args[]){
        System.out.println("*********************************************************");
        System.out.println("          Solutions For Midterm Test                     ");
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
                    Question_1.test();
                    break;
                case 2:
                    Question_2.test();
                    break;
                case 3:
                    Question_3.test();
                    break;
                case 4:
                    Question_4.test();
                    break;

                default:
                    System.out.println("Please enter a valid option ( 0 - 3 )..........");
            }
        }
    }

    private static void showSolutionMenu() {
        System.out.println("        Which solution do you want to test?              ");
        System.out.println("*********************************************************");
        System.out.println("        1. Reverse Even Indices                          ");
        System.out.println("        2. Arrange Coins                                 ");
        System.out.println("        3. Minimum Moves                                 ");
        System.out.println("        4. Count of Possible Ways                        ");
        System.out.println("        5. Find                                ");
        System.out.println("*********************************************************");
        System.out.println("        Press 0 to exit the menu.........................");
    }
}
