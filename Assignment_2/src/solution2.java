import java.util.Scanner;


public class solution2 {
    public static void main(String args[])
    {
        System.out.println("***********************************");
        System.out.println("Scenario #1 Salary Calculation");
        System.out.println("***********************************");
        calculateSalary();
        System.out.println("***********************************");
        System.out.println("Scenario #2 Digits Addition");
        System.out.println("***********************************");
        digitsAddition();
        System.out.println("***********************************");
        System.out.println("Scenario #3 Find Perfect Numbers");
        System.out.println("***********************************");
        printPerfectNumber();
        System.out.println("***********************************");
        System.out.println("Bonus Scenario - Drawing Triangle");
        System.out.println("***********************************");
        drawIsoTriangle();

        Pizza pizza = new Pizza(15, "meat");
        //System.out.println(pizza);
        pizza.print();
    }

    private static void calculateSalary() {
        // TODO Auto-generated method stub
        double totalSalary = 0; // total salary the employee will get after calculation
        Scanner reader = new Scanner(System.in); //initialize the scanner
        System.out.println("Hi, please enter the hours you worked this week:");
        double hoursWorked = reader.nextDouble(); //accepting user input
        while (hoursWorked < 0) //user input validation
        {
            System.out.println("Please enter a positive number:");
            hoursWorked = reader.nextDouble();
        }

        if (hoursWorked <= 36)
            totalSalary = hoursWorked * 15;
        else if (hoursWorked > 36 && hoursWorked <= 41) {
            totalSalary = (36 * 15) + (hoursWorked - 36) * 15 * 1.5;
        }
        else if (hoursWorked > 41 && hoursWorked <= 48 ) {
            totalSalary = (36 * 15) + (5 * 15 * 1.5) + (hoursWorked - 41) * 15 * 2;
        }
        else {
            System.out.println("You  the maximum 48-work-hours allowance, your compensation hours will be counted as 48 hours......");
            totalSalary = (36 * 15) + (5 * 15 * 1.5) + (7 * 15 * 2);
        }

        System.out.println("Based on your work hours, your salary for this week is $" + totalSalary);
    }

    private static void digitsAddition() {
        // TODO Auto-generated method stub
        int sum = 0; //initialize the sum of digits
        Scanner reader = new Scanner(System.in); //initialize the scanner
        System.out.println("Please enter a integer to get a sum of its digits:");
        int numberInput = reader.nextInt();
        while (numberInput < 0) //user input validation
        {
            System.out.println("Pleae enter a positive integer:");
            numberInput = reader.nextInt();
        }

        //loop for digits calculation
        while (numberInput > 0){
            sum = sum + numberInput % 10;
            numberInput = numberInput / 10;
        }

        System.out.println(String.format("The sum of digits of this integer is <%d>", sum));
    }

    private static void printPerfectNumber() {
        // TODO Auto-generated method stub
        Scanner reader = new Scanner(System.in); //initialize the scanner
        System.out.println("Please enter a integer to find the perfect numbers between 1 and your input.....");
        int userInput = reader.nextInt();
        //user input validation
        while (userInput < 0) {
            System.out.println("Please enter a positive integer:");
            userInput = reader.nextInt();
        }

        for(int i = 0; i <= userInput; i++) {
            int sumProperDivisors = calculateDivSum(i);
            if (i == sumProperDivisors)
                System.out.println(String.format("Perfect number <%d> found",i));
        }
    }


    private static int calculateDivSum(int number) {
        // TODO Auto-generated method stub
        int sum = 0;

        //find all proper divisors
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if(number%i == 0){
                if(i == (number/i))
                    sum += i;
                else
                    sum += (i + number/i);
            }
        }
        return sum + 1;
    }


    private static void drawIsoTriangle() {

    }
}
