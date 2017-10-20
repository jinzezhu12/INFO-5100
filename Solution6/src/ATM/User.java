package ATM;

public class User {
    //defined the class attributes
    private String name;
    private int age;
    private String address;
    private String phoneNum;
    private String bankAccountNumber;
    private String password;
    private double accountBalance;

    public User(String name, int age, String address, String phoneNum, String bankAccountNumber, String password){
        //initialize every attribute in the
        this.name = name;
        this.age = age;
        this.address = address;
        this.phoneNum = phoneNum;
        this.bankAccountNumber = bankAccountNumber;
        this.password = password;
        this.accountBalance = 0;
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

    public boolean validatePwd(String password) {
        if(this.password.equals(password)) //see if the password matches
            return true;
        return false;
    }
}
