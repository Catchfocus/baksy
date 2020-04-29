package com.company;

public class Account {

    public Account(int _accountID, String _accountOwner, String _accountPassword, int _accountBalance) {

        this.setAccountId(_accountID);
        this.setAccountOwner(_accountOwner);
        this.setAccountPassword(_accountPassword);
        this.setAccountBalance(_accountBalance);

        System.out.println("Account létrehozva: " + "\n  ID: " + this.getAccountId() + "\n   Owner: " + this.getAccountOwner() + "\n    Password: " + this.getAccountPassword() + "\n   Egyenleg: " + this.getAccountBalance());


    }

    private int accountId = 0;
    private String accountOwner="";
    private String accountPassword="";
    private int accountBalance = 0;

    //getter

    public int getAccountId() {
        return accountId;
    }

    public String getAccountOwner() {
        return accountOwner;
    }

    public String getAccountPassword() {
        return accountPassword;
    }

    public int getAccountBalance() {
        return accountBalance;
    }

    //setter

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public void setAccountOwner(String accountOwner) {
        this.accountOwner = accountOwner;
    }

    public void setAccountPassword(String accountPassword) {
        this.accountPassword = accountPassword;
    }

    public void setAccountBalance(int balance) {
        this.accountBalance = balance;
    }

}
