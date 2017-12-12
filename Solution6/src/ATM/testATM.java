package ATM;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.invoke.SwitchPoint;
import java.util.Scanner;

public class testATM {
    private static String userData = "./user.txt";
    private static String transactionData = "./transaction.txt";


    public static void launchATM() throws IOException{

        //initialize the input reader
        Scanner reader = new Scanner(System.in);

        //initialize the file & file writer
        System.out.println("Lucky ATM is loading the data files.........");
        File userFile = new File(userData);
            if (userFile.createNewFile()) {
                System.out.println("New user data file is created!");
                FileWriter userWriter = new FileWriter(userFile);
                userWriter.write("name, age, address, phoneNum, bankAccountNum, password");
                userWriter.close();
            }
            else
                System.out.println("user data file already exists!");
        File transactionFile = new File(transactionData);
            if (transactionFile.createNewFile()) {
                System.out.println("New transaction data file is created!");
                FileWriter transactionWrtiter = new FileWriter(transactionFile); //initialize the file writer
                transactionWrtiter.write("transtype, amount, bankAccountNum");
                transactionWrtiter.close();
            }
            else
                System.out.println("transaction data file already exists!");


        //put some sample users into the system
        User user1 = new User("Zezhu", 25, "1031 fairfax drive, Tuscaloosa AL 35406", "2058868735", "77853316", "123456" );
        User user2 =  new User("Daugh", 19, "8458 spotted fawn drive, Memphis TN 38133", "9013344231", "12341234", "123456" );
        User user3 =  new User("Jennie", 23, "3600 45th ave SW, Seattle WA 98126", "2067763212", "99823112", "123456" );
        //initialize the atm
        Atm myAtm = new Atm(1000, 1);
        //add sample users to the ATM system
        myAtm.addUser(user1);
        myAtm.addUser(user2);
        myAtm.addUser(user3);

        int option = -1; //initialize the user input, invalid value '-1' given
        while(option != 0){
            showLevel_1_Menu(); //show users level_1 menu which allows them choose if they are current users or new users
            option = reader.nextInt();

            switch (option){
                case 0:
                    break;
                case 1:
                    //actions for current users
                    currentUserMenu(myAtm);
                    break;
                case 2:
                    //actions for new users
                    myAtm.registerNewAccountMenu();
                    break;
                default:
                    System.out.println("Please enter a valid option (0 - 2)......");
            }
        }



    }



    private static void currentUserMenu(Atm myAtm) {
        Scanner reader = new Scanner(System.in);
        int option = -1; //initialize the user input, invalid value '-1' given
        while(option != 0){
            showLevel_2_Menu_currentUser(); //show options for current users
            option = reader.nextInt();
            switch (option){
                case 0:
                    break;
                case 1:
                    //take users to login menu
                    myAtm.printUserMenu(myAtm.loginPrompt());
                    break;
                case 2:
                    //take users to retrieve back their password
                    myAtm.forgotpwdPrompt();
                    break;
                default:
                    System.out.println("Please enter a valid option (0 - 2)......");
            }
        }

    }




    private static void showLevel_2_Menu_currentUser() {
        //welcome prompts for current users
        System.out.println("*************          Welcome Back            ******************");
        System.out.println("                1. Log-in to your account                        ");
        System.out.println("                2. Forgot your password?                         ");
        System.out.println("                0. Back to Previous Menu                         ");
        System.out.println("*****************************************************************");
    }

    public static void showLevel_1_Menu(){
        //welcome prompts for users
        System.out.println("****************** Welcome to Lucky ATM System ******************");
        System.out.println("                1. Current Users                                 ");
        System.out.println("                2. New Users                                     ");
        System.out.println("                0. Back to Previous Menu                         ");
        System.out.println("*****************************************************************");
    }

}
