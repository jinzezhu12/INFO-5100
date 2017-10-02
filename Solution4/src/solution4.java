import com.sun.xml.internal.fastinfoset.util.CharArray;
import com.sun.xml.internal.ws.api.streaming.XMLStreamWriterFactory;

import java.util.Scanner;

public class solution4 {
    public static void main(String args[]){
        System.out.println("*********************************************************");
        System.out.println("          Solutions For Home Assignment # 4              ");
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
                    // License key Formatting
                    formatLicenseKey();
                    break;
                case 2:
                    // Rock Paper Scissors Game
                    System.out.println("*************** Welcome to the Rock Paper Scissors Game ***************");
                    RockPaperScissorsGame.main();
                    break;
                case 3:
                    // Separating IP Address
                    break;
                case 4:
                    // Course Registration
                    break;
                case 5:
                    // Convert Integer to Roman Numeral
                    break;
                case 6:
                    // Find Median Sorted Arrays
                    break;
                default:
                    System.out.println("Please enter a valid option ( 0 - 6 )..........");
            }
        }
    }

    private static void formatLicenseKey() {
        Scanner reader = new Scanner(System.in);
        boolean isValid = false; //valid condition for string input
        String s = ""; //initialize for user string input
        int k;    //initialize for user integer input
        while(!isValid){
            System.out.println("Please enter a String (ONLY contains alphanumerical characters and dashes) for us to test....");
            s = reader.nextLine();
            if(s.equals(null)) {
                System.out.println("Please enter a non-empty string......");
                continue;
            }
            if(s.length() > 12000) {
                System.out.println("Please enter a string less than 12,000 characters......");
                continue;
            }
            if(!s.contains("-")){
                System.out.println("The string you entered does not contain a dash.........");
                continue;
            }
            else
                isValid = true;
        }


        System.out.println("The length of the given string ------> " + s.length());
        System.out.println("Please enter a positive integer (less than the length of the given String) to reformat the string....");
        k = reader.nextInt();
        while(k < 0){
            System.out.println("Please enter a positive integer.....");
            k = reader.nextInt();
        }

        //Begin to reformat the license key
        s = s.replaceAll("-","").toUpperCase();
        int nRes = s.length() % k; //get the remainder for remaining characters of first group letters
        StringBuilder output = new StringBuilder(s);
        int nIndex = nRes;
        if(nRes == 0)
            nIndex = k;
        while (nIndex < output.length()){
            output.insert(nIndex, '-');
            nIndex++;
            nIndex += k;
        }
        //display formatted license key
        System.out.println("After reformatting, the new license key is ------> " + output.toString());

    }

    private static void showSolutionMenu() {
        System.out.println("        Which solution do you want to test?              ");
        System.out.println("*********************************************************");
        System.out.println("        1. License Key Formatting                        ");
        System.out.println("        2. Rock Paper Scissors Game                      ");
        System.out.println("        3. Separating IP Address                         ");
        System.out.println("        4. Course Registration System                    ");
        System.out.println("        5. Convert Integer to Roman Numeral              ");
        System.out.println("        6. Find Median Sorted Arrays                     ");
        System.out.println("*********************************************************");
        System.out.println("        Press 0 to exit the menu.........................");
    }


}
