package ATM;

import java.util.ArrayList;
import java.util.Scanner;

public class Atm {
    private double availableAmountInMachie;
    private double transactionFee;
    private ArrayList<User> users;

    public Atm(double availableAmountInMachie, double transactionFee){
        this.availableAmountInMachie = availableAmountInMachie;
        this.transactionFee = transactionFee;
        this.users = new ArrayList<User>();
    }

    public void addUser(User newUser){
        this.users.add(newUser);
    }

    public User userLogin(String acctNum, String password){
        for (User u : this.users){
            //check if account number is correct
            if(u.getBankAccountNumber().compareTo(acctNum) == 0 && u.validatePwd(password))
                return u;
        }
        //if we haven't found the match password & acctNum
        return null;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public User loginPrompt() {
        //inits
        Scanner reader = new Scanner(System.in);
        String acctNum;
        String pwd;
        User authUser;
        //prompt the user for account number & password until a correct one is reached
        do{
            System.out.println("****************** Welcome to Login Menu ******************");
            System.out.println("Enter your account number......");
            acctNum = reader.nextLine();
            System.out.println("Enter your password......");
            pwd = reader.nextLine();

            //validate the user info
            authUser = userLogin(acctNum, pwd);
            if(authUser == null){
                System.out.println("Incorrect Account Number/ Password, please try again.....");
            }
        } while (authUser == null);

        return authUser;
    }

    public static void printUserMenu(User theUser) {

        //init
        Scanner reader = new Scanner(System.in);
        int choice;

        //user menu
        do{
            System.out.println(String.format("************* Welcome %s, what would you like to do? *************", theUser.getName()));
            System.out.println("               1. Show Available Balance               ");
            System.out.println("               2. Withdrawal                           ");
            System.out.println("               3. Deposit                              ");
            System.out.println("               4. Show Recent Transactions             ");
            System.out.println("               5. Change Password                      ");
            System.out.println("               0. Back to Previous Menu                ");
            System.out.println("*******************************************************");
            choice = reader.nextInt();

            if(choice < 0 || choice > 5)
                System.out.println("Invalid choice. Please choose 0-5");
        } while(choice < 0 || choice > 5);

        switch (choice){
            case 1:
                Atm.showAvailableBalance(theUser, reader);
                break;
            case 2:
                Atm.withDrawal(theUser, reader);
                break;
            case 3:
                Atm.Deposit(theUser, reader);
                break;
            case 4:
                Atm.showRecentTrans(theUser, reader);
                break;
            case 5:
                Atm.changePassword(theUser, reader);
                break;
        }

        if(choice != 0){
            Atm.printUserMenu(theUser);
        }

    }
}
