package ATM;

import java.util.ArrayList;
import java.util.Scanner;

public class Atm {
    private double availableAmountInMachie;
    private double transactionFee; // % fee of each transaction charged
    private ArrayList<User> users;

    public Atm(double availableAmountInMachie, double transactionFee){
        this.availableAmountInMachie = availableAmountInMachie;
        this.transactionFee = transactionFee;
        this.users = new ArrayList<User>();
    }

    public boolean addUser(User newUser){
        for (User u : this.users)
        {
            if(u.getBankAccountNumber().equals(newUser.getBankAccountNumber())) {
                System.out.println("The bank account number you entered is already in the system, try to fnd your password or use another account number");
                return false;
            }
        }
        this.users.add(newUser);
        return true;
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

    public void printUserMenu(User theUser) {

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
                this.availableAmountInMachie -= Atm.withDrawal(theUser, reader) * (1 + this.transactionFee/100); //charge the ATM transaction fee & update the availableBalance in the ATM
                break;
            case 3:
                this.availableAmountInMachie += Atm.Deposit(theUser, reader) * (1 - this.transactionFee/100);    //charge the ATM transaction fee & update the availableBalance in the ATM
                break;
            case 4:
                Atm.showRecentTrans(theUser);
                break;
            case 5:
                Atm.changePassword(theUser, reader);
                break;
        }

        if(choice != 0){
            printUserMenu(theUser);
        }

    }

    private static void changePassword(User theUser, Scanner reader) {
        boolean isConfirmed = false;
        do {
            System.out.println("Enter your new password here: ");
            if(reader.hasNextInt()) //detect if there is any remaining newline()
                reader.nextLine();
            String pwd = reader.nextLine();
            System.out.println("Enter again for confirmation: ");
            String pwd2 = reader.nextLine();

            if(pwd2.equals(pwd)) {
                isConfirmed = true;
                //updating the password
                theUser.setPassword(pwd);
            }
            else
                System.out.println("You enter the different password at the second entry, please try to keep them the same......");
        } while (!isConfirmed);

    }

    private static void showRecentTrans(User theUser) {
        System.out.println("The following are your most recent 10 transactions:");
        ArrayList<Transaction> transactions = theUser.getTransactions();
        if (transactions.size() > 10) {
            for (int i = 0; i < 10; i++) {
                System.out.println(String.format("Deposit type : %s, Transaction amount : $%.2f", transactions.get(i).getTransType(), transactions.get(i).getAmount()));
            }
        }
        else
            for (Transaction t : transactions){
                System.out.println(String.format("Deposit type : %s, Transaction amount : $%.2f", t.getTransType(), t.getAmount()));
            }
    }

    private static double Deposit(User theUser, Scanner reader) {
        System.out.println("What's the amount of money you want to deposit into your account?");
        double depositAmount = reader.nextDouble();
        theUser.setAccountBalance(depositAmount, false);
        System.out.println(String.format("You just successfully deposited $%.2f from your account, and your current balance is $%.2f", depositAmount, theUser.getAccountBalance()));
        return depositAmount;
    }

    private static double withDrawal(User theUser, Scanner reader) {
        System.out.println("What's the amount of money you want to withdrawal from you account?");
        double withdrawalAmount = reader.nextDouble();
        if(theUser.setAccountBalance(withdrawalAmount, true) == 0)
            System.out.println("Your account does not have enough balance now!");
        else
            System.out.println(String.format("You just successfully withdrawal $%.2f from your account, and your current balance is $%.2f", withdrawalAmount, theUser.getAccountBalance()));

        return withdrawalAmount;
    }

    private static void showAvailableBalance(User theUser, Scanner reader) {
        System.out.println(String.format("You current balance ---> %.2f ", theUser.getAccountBalance()));
    }


    public void forgotpwdPrompt() {
        //inits
        Scanner reader = new Scanner(System.in);
        String name;
        int age;
        String phoneNum;
        User validUser;

        do {
            System.out.println("*************   Forgot your password?   *************");
            System.out.println("  Enter the following info to get your password back.");
            System.out.println(" Enter your name: ");
            name = reader.nextLine();
            System.out.println(" Enter your age: ");
            age = Integer.parseInt(reader.nextLine());
            System.out.println(" Enter your phone number: ");
            phoneNum = reader.nextLine();
            validUser = userValidation(name, age, phoneNum);
            if(validUser == null)
                System.out.println("Based on the information you provided, we are not able to find your password/account number back. Please try again......");
        } while (validUser == null);

        System.out.println("Congratulations! We found your account information:");
        System.out.println("Your Account Number is ---> " + validUser.getBankAccountNumber());
        Atm.changePassword(validUser, reader);

    }

    private User userValidation(String name, int age, String phoneNum) {
        for (User u : this.users ){
            if( u.getName().compareTo(name) == 0 && u.getAge() == age && u.getPhoneNum().compareTo(phoneNum) == 0)
                return u;
        }

        //if we haven't any record matched
        return null;
    }

    public void registerNewAccountMenu() {
        //inits
        Scanner reader = new Scanner(System.in);
        String name, phoneNum, address, bankAccountNumber, password;
        int age;
        boolean isRegistered = false;

        do {
            System.out.println("*************   New Account Registration   *************");
            System.out.println(" Enter your name: ");
            name = reader.nextLine();
            System.out.println(" Enter your age: ");
            age = Integer.parseInt(reader.nextLine());
            System.out.println(" Enter your address: ");
            address = reader.nextLine();
            System.out.println(" Enter your phone number: ");
            phoneNum = reader.nextLine();
            System.out.println("Set up an account number: ");
            bankAccountNumber = reader.nextLine();
            System.out.println("Set up a password: ");
            password = reader.nextLine();

            User newUser = new User(name, age, address, phoneNum, bankAccountNumber, password);
            if(this.addUser(newUser))
                isRegistered = true;
        } while (!isRegistered);

    }
}
