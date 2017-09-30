
import java.util.Arrays;
import java.util.Scanner;
import static java.lang.Math.*;


public class solution3 {
    public static void main(String args[]){
        //initialize the scanner to read user input
        Scanner reader1 = new Scanner(System.in);
        System.out.println("*********************************************************");
        System.out.println("Solution For Question #3 Removing Vowels From Any String ");
        System.out.println("*********************************************************");
        System.out.println("Please enter a string:");
        String vString = reader1.nextLine();
        System.out.println(String.format("The output string is -----> %s",removeVowelsFromString(vString)));
        System.out.println("*********************************************************");
        System.out.println("Solution For Question #4 Check If Two String are Anagrams");
        System.out.println("*********************************************************");
        System.out.println("Please enter the first string:");
        String string1 = reader1.nextLine();
        System.out.println("Please enter the second string:");
        String string2 = reader1.nextLine();
        if (checkIfTwoStringsAreAnagram(string1,string2) == true)
                System.out.println("These two strings are anagram of each other......");
        else
                System.out.println("These two strings are not anagram of each other.......");
        System.out.println("*********************************************************");
        System.out.println("Solution For Question #5 Creating A Calculator");
        System.out.println("*********************************************************");

        showCalculator();
    }

    private static void showCalculator() {
        //create the scanner
        Scanner reader = new Scanner(System.in);
        //initialize the result after calculation (only for function #1 - #4)
        double input1, input2, result;
        int operationInput = -1; //initialize the operation input, and set it equal to '-1'
        while(operationInput != 0) {
            showCalculatorMenu();
            operationInput = reader.nextInt();

            switch (operationInput) {
                case 0:
                    break;
                case 1:
                    System.out.println("Please enter your first value");
                    input1 = reader.nextDouble();
                    System.out.println("Please enter you second value");
                    input2 = reader.nextDouble();
                    result = input1 + input2;
                    System.out.println(String.format("addition of these two value is %f", result));
                    break;
                case 2:
                    System.out.println("Please enter your first value");
                    input1 = reader.nextDouble();
                    System.out.println("Please enter you second value");
                    input2 = reader.nextDouble();
                    result = input1 - input2;
                    System.out.println(String.format("addition of these two value is %f", result));
                    break;
                case 3:
                    System.out.println("Please enter your first value");
                    input1 = reader.nextDouble();
                    System.out.println("Please enter you second value");
                    input2 = reader.nextDouble();
                    result = input1 * input2;
                    System.out.println(String.format("addition of these two value is %f", result));
                    break;
                case 4:
                    System.out.println("Please enter your first value");
                    input1 = reader.nextDouble();
                    System.out.println("Please enter you second value");
                    input2 = reader.nextDouble();
                    result = input1 / input2;
                    System.out.println(String.format("addition of these two value is %f", result));
                    break;
                case 5:
                    doSquareroot();
                    break;
                case 6:
                    doSquare();
                    break;
                case 7:
                    doCube();
                    break;
                case 8:
                    F_C_Conversion(); // convert between Fahrenheit and Celsius
                    break;
                case 9:
                    F_I_Conversion(); // convert between Feet and Inches
                    break;
                case 10:
                    getRootsForQuadraticEquation(); // retrieve the roots from a quadratic equation
                default:
                    System.out.println("Please enter a valid option (0 ~ 10).....");
            }
        }

    }

    private static void getRootsForQuadraticEquation() {
        int a, b, c;
        double root1, root2, d;
        Scanner reader = new Scanner(System.in);
        System.out.println("Given quadratic equation ----> Ax^2 + Bx + C");
        System.out.print("Enter a Integer value for A: ");
        a = reader.nextInt();
        System.out.print("Enter a Integer value for B: ");
        b = reader.nextInt();
        System.out.print("Enter a Integer value for C: ");
        c = reader.nextInt();
        d = b * b - 4 * a * c;

        //if discriminant is greater than zero, two distinct roots will be retrieved
        if (d > 0) {
            System.out.println("Two roots for this equation:");
            root1 = (-b + Math.sqrt(d))/(2*a);
            root2 = (-b - Math.sqrt(d))/(2*a);
            System.out.println(String.format("The first root -----> %.2f ||| The second root -----> %.2f", root1, root2));
        }
        //if discriminant is equal to zero, there will be only one root
        else if (d == 0){
            System.out.println("Two roots for this equation:");
            root1 = (-b + Math.sqrt(d))/(2*a);
            System.out.println(String.format("The root -----> %.2f", root1));
        }
        else
        {
            System.out.println("Roots are imaginary");
        }

    }

    private static void showCalculatorMenu() {
        System.out.println(".......  Welcome to my Calculator  .......................");
        System.out.println("Which operation do you want to do?........................");
        System.out.println("Enter 1 for addition......................................");
        System.out.println("Enter 2 for subtraction...................................");
        System.out.println("Enter 3 for multiplication................................");
        System.out.println("Enter 4 for division......................................");
        System.out.println("Enter 5 for squareRoot....................................");
        System.out.println("Enter 6 for square........................................");
        System.out.println("Enter 7 for cube..........................................");
        System.out.println("Enter 8 for unit conversion between Fahrenheit and Celsius");
        System.out.println("Enter 9 for unit conversion between Feet and Inches.......");
        System.out.println("Enter 10 for finding the roots of Quadratic Equation......");
        System.out.println("Press 0 to EXIT the Calculator............................");
    }



    private static void F_I_Conversion() {
        Scanner reader = new Scanner(System.in);
        boolean isValid = false; // initialize the validation
        double convResult;

        while(!isValid)
        {
            System.out.println("********* Press 1 For Converting Feet to Inches *********");
            System.out.println("********* Press 2 For Converting Inches to Feet *********");
            int option = reader.nextInt();
            switch (option)
            {
                case 1:
                    System.out.println("Please enter a value with unit of Feet:");
                    double fValue = reader.nextDouble();
                    if(fValue < 0) //input validation
                        continue;
                    convResult = fValue * 12;
                    System.out.println("The value with the unit of Inches is ----> " + Double.toString(convResult));
                    isValid = true;
                    break;
                case 2:
                    System.out.println("Please enter a value with unit of Inches:");
                    double iValue = reader.nextDouble();
                    if (iValue < 0)
                        continue;
                    convResult = iValue / 12;
                    System.out.println("The value with the unit of Feet is ----> " + Double.toString(convResult));
                    isValid = true;
                    break;
                default:
                    System.out.println("Please enter a valid option '1'/'2'......... ");
                    break;
            }
        }
    }

    private static void F_C_Conversion() {
        Scanner reader = new Scanner(System.in);
        boolean isValid = false; // initialize the validation
        double convResult;

        while(!isValid) {
            System.out.println("********* Press 1 For Converting Fahrenheit to Celsius *********");
            System.out.println("********* Press 2 For Converting Celsius to Fahrenheit *********");
            int option = reader.nextInt();
            switch (option) {
                case 1:
                    System.out.println("Please enter a value with unit of Fahrenheit:");
                    double fValue = reader.nextDouble();
                    convResult = (fValue - 32) * (5 / 9);
                    System.out.println("The value with the unit of Celsius is ----> " + Double.toString(convResult));
                    isValid = true;
                    break;
                case 2:
                    System.out.println("Please enter a value with unit of Celsius:");
                    double cValue = reader.nextDouble();
                    convResult = (cValue * 1.8) + 32;
                    System.out.println("The value with the unit of Fahrenheit is ----> " + Double.toString(convResult));
                    isValid = true;
                    break;
                default:
                    System.out.println("Please enter a valid option '1'/'2'......... ");
                    break;
            }
        }
    }


    private static void doCube() {
        Scanner reader = new Scanner(System.in);
        System.out.println("Please enter a number: ");
        double result;
        double input = reader.nextDouble();
        result = Math.pow(input,3);
        System.out.println("The output(after cube) is -----> "+ String.valueOf(result));

    }

    private static void doSquare() {
        Scanner reader = new Scanner(System.in);
        System.out.println("Please enter a number: ");
        double result;
        double input = reader.nextDouble();
        result = Math.pow(input,2);
        System.out.println("The output(after square) is -----> "+ String.valueOf(result));

    }

    private static void doSquareroot() {
        Scanner reader = new Scanner(System.in);
        System.out.println("Please enter a positive number: ");
        double result;
        double input = reader.nextDouble();
        //input validation
        while(input < 0){
            System.out.println("Invalid input, please enter a valid number......");
            input = reader.nextDouble();
        }
        result = Math.sqrt(input);
        System.out.println("The output(after squareRoot) is -----> "+ String.valueOf(result));

    }


    private static String removeVowelsFromString(String vString) {
        String outString = vString.replaceAll("[aeiouAEIOU]","");
        return outString;
    }

    private static Boolean checkIfTwoStringsAreAnagram(String string1, String string2) {
        int n1 = string1.length();
        int n2 = string2.length();

        if(n1 != n2)
            return false;

        //sort both user input strings
        String sortedString1 = quickSort(string1);
        String sortedString2 = quickSort(string2);


        //compare the sorted strings
        if (sortedString1.equals(sortedString2))
            return true;
        else
            return false;
    }

    private static String quickSort(String input) {
        char[] chars = input.toCharArray(); //put all letters of this string into a charArray
        Arrays.sort(chars); //sorting the letters
        String sortedString = new String(chars);
        //return the sorted String
        return  sortedString;
    }

}
