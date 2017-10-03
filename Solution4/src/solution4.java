import Question_2.RockPaperScissorsGame;
import Question_3.IpAddress;
import Question_4.Course;
import Question_4.Student;

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
                    // Question_2.Rock Question_2.Paper Question_2.Scissors Game
                    System.out.println("*************** Welcome to the Rock-Paper-Scissors Game ***************");
                    RockPaperScissorsGame.main();
                    break;
                case 3:
                    // Separating IP Address
                    IpAddress ip = new IpAddress("216.27.6.136");
                    System.out.println(ip.getDottedDecimal());
                    System.out.println(ip.getOctet(4));
                    System.out.println(ip.getOctet(1));
                    System.out.println(ip.getOctet(3));
                    System.out.println(ip.getOctet(2));
                    break;
                case 4:
                    // Course Registration
                    Course myCourse = new Course("History");
                    Student zezhu = new Student("Zezhu", "11321534");
                    Student peter = new Student("Peter", "1231wr12");
                    Student bob = new Student("Bob", "eqw123142");
                    Student jane = new Student("Jane", "asd11234");
                    Student nerd = new Student("Nerd", "13324sb");
                    //register student into the course
                    myCourse.registerStudent(zezhu);
                    myCourse.registerStudent(peter);
                    myCourse.registerStudent(bob);
                    myCourse.registerStudent(jane);
                    myCourse.registerStudent(nerd);
                    myCourse.registerStudent(nerd);
                    myCourse.registerStudent(nerd);
                    myCourse.registerStudent(nerd);
                    myCourse.registerStudent(nerd);
                    myCourse.registerStudent(nerd);
                    myCourse.registerStudent(nerd);

                    break;
                case 5:
                    // Convert Integer to Roman Numeral
                    System.out.println("Please enter a integer within the range( 1-3999 ): ");
                    int input = reader.nextInt();
                    while(input > 3999 || input < 0) {
                        System.out.println("Invalid input! Please re-enter a valid integer.");
                        input = reader.nextInt();
                    }
                    System.out.println("The roman output ---> " + intToRoman(input));
                    break;
                case 6:
                    // Find Median Sorted Arrays
                    break;
                default:
                    System.out.println("Please enter a valid option ( 0 - 6 )..........");
            }
        }
    }

    private static String intToRoman(int num) {
        if(num>=1000) return "M"+intToRoman(num-1000);
        if(num>=900) return "CM"+intToRoman(num-900);
        if(num>=500) return "D"+intToRoman(num-500);
        if(num>=400) return "CD"+intToRoman(num-400);
        if(num>=100) return "C"+intToRoman(num-100);
        if(num>=90) return "XC"+intToRoman(num-90);
        if(num>=50) return "L"+intToRoman(num-50);
        if(num>=40) return "XL"+intToRoman(num-40);
        if(num>=10) return "X"+intToRoman(num-10);
        if(num>=9) return "IX"+intToRoman(num-9);
        if(num>=5) return "V"+intToRoman(num-5);
        if(num>=4) return "IV"+intToRoman(num-4);
        if(num>=1) return "I"+intToRoman(num-1);
        return "";
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
        System.out.println("        2. Rock-Paper-Scissors Game                      ");
        System.out.println("        3. Separating IP Address                         ");
        System.out.println("        4. Course Registration System                    ");
        System.out.println("        5. Convert Integer to Roman Numeral              ");
        System.out.println("        6. Find Median Sorted Arrays                     ");
        System.out.println("*********************************************************");
        System.out.println("        Press 0 to exit the menu.........................");
    }


}
