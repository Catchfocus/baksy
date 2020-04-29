package com.company;


import java.util.ArrayList;
import java.util.Scanner;

public class User{

    public User(int _userId, String _userName, String _userPassword, String _year, String _mounth, String _day, String _where){

        this.setUserId(_userId);
        this.setUserName(_userName);
        this.setUserPassword(_userPassword);



        this.setUserBirthInformation(_year,_mounth,_day,_where);

        System.out.println("User létrehozva: " + "\n  ID: " + this.getUserId() + "\n   User Name: " + this.getUserName() + "\n    Password: " + this.getUserPassword());

        //default userAccount





    }

    ArrayList<Account> userAccounts = new ArrayList<Account>(); // en sem tudom
    private int userId=0;
    private String userName="";
    private String userPassword="";
    private String[] userBirthInformation = new String[4]; //0. y 1. m 2. d 3. where
    private int userAccountsNumber = 0;



    public void createNewAccount(){
        Scanner input = new Scanner(System.in);
        this.setUserAccountsNumber();
        System.out.println("Folyószámla jelszó: ");
        String pass = input.next();
        Account defaultNewAccount = new Account(this.getUserAccountsNumber(), this.getUserName(),pass,0);
        this.getUserAccounts().add(defaultNewAccount);
    }

    //getter

    public void writeUserBirthInformation(){
        System.out.print(this.userBirthInformation[0]+"."+this.userBirthInformation[1]+"."+this.userBirthInformation[2]+"."+this.userBirthInformation[3]);
    }

    public int getUserAccountsNumber() {
        return userAccountsNumber;
    }

    public int getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public ArrayList<Account> getUserAccounts() {
        return userAccounts;
    }

    public String getUserPassword() {
        return userPassword;
    } // itt melyik a get() hivas?

    public String[] getUserBirthInformation() {
        return userBirthInformation;
    }

    //setter


    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserAccountsNumber() {
        this.userAccountsNumber++;
    }

    public void setUserBirthInformation(String[] userBirthInformation) {
        this.userBirthInformation = userBirthInformation;
    }

    public void setUserBirthInformation(String y, String m, String d, String w){
        this.userBirthInformation[0]=y;
        this.userBirthInformation[1]=m;
        this.userBirthInformation[2]=d;
        this.userBirthInformation[3]=w;

    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public void setUserAccounts(ArrayList<Account> userAccounts) {
        this.userAccounts = userAccounts;
    }
}
