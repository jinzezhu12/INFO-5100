package ATM;

import java.util.ArrayList;

public class User {
    //defined the class attributes
    private String name;
    private int age;
    private String address;
    private String phoneNum;
    private String bankAccountNumber;
    private String password;
    private double accountBalance;
    private ArrayList<Transaction> transactions;

    public User(String name, int age, String address, String phoneNum, String bankAccountNumber, String password){
        //initialize every attribute in the
        this.name = name;
        this.age = age;
        this.address = address;
        this.phoneNum = phoneNum;
        this.bankAccountNumber = bankAccountNumber;
        this.password = password;
        this.accountBalance = 500;
        this.transactions = new ArrayList<Transaction>();
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public double setAccountBalance(double amount, boolean isWithdrawal){
        if(isWithdrawal) {
            if (this.accountBalance < amount)
                return 0;
            this.accountBalance = this.accountBalance - amount; //reset account balance for withdrawal
            Transaction transaction = new Transaction("Withdrawal", amount);
            this.transactions.add(transaction);
        }
        else {
            this.accountBalance = this.accountBalance + amount; //reset account balance for deposit
            Transaction transaction = new Transaction("Deposit", amount);
            this.transactions.add(transaction);
        }
        //update the accountBalance
        return this.accountBalance;
    }

    public String getBankAccountNumber() {
        return bankAccountNumber;
    }

    public String getName(){
        return name;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public int getAge() {
        return age;
    }

    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }

    public boolean validatePwd(String password) {
        if(this.password.equals(password)) //see if the password matches
            return true;
        return false;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
