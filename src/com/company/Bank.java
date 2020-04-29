package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Bank {


    Bank(String _bankName){
        this.setBankName(_bankName);

        System.out.println("Bank létrehozva: " + this.getBankName());
    }

    public ArrayList<User> users = new ArrayList<User>();

    private String bankName="";
    private int usersNumber= users.size();
    private int accountsNumber = 0;

    public void listAllUserName(){
        for (int i=0; i<=usersNumber; i++) {
            System.out.println(users.get(i).getUserName());
        }
    }

    public void listAllUserData(){
        for (int i=0; i<=this.getUsersNumber()-1; i++){ // a j nel akadt el -  felment ketoig
            System.out.print(this.users.get(i).getUserName() + " aki, a(z) " +
                    this.users.get(i).getUserId() + ". felhasználó, született ");
            this.users.get(i).writeUserBirthInformation();
            System.out.println(" "+this.users.get(i).getUserAccountsNumber()+" folyószámlával rendelkezik.");
            for (int j=0; j<=this.users.get(i).getUserAccountsNumber()-1; j++){
               System.out.println((j+1)+". számla: " + this.getUsers().get(0).getUserAccounts().get(j).getAccountBalance());

            }

        }
    }


    public void createNewUser(){
        Scanner in = new Scanner(System.in);

        System.out.println("Család neved: ");
        String forname = in.next();
        System.out.println("Kereszt neved: ");
        String surename = in.next();
        System.out.println("Jelszó: ");
        String pass = in.next();
        System.out.println("Mikor és hol születtél?\n");
        System.out.println("Év: ");
        String y = in.next();
        System.out.println("Hónap: ");
        String m = in.next();
        System.out.println("Nap: ");
        String d = in.next();
        System.out.println("Hely: ");
        String w = in.next();

        String name = forname+" "+surename;
        this.setUsersNumber();
        User newUser = new User(this.getUsersNumber(),name,pass,y,m,d,w);
        this.getUsers().add(newUser);

        newUser.createNewAccount();

    }

    public void login(){
        Scanner input = new Scanner(System.in);
        System.out.println("ID: ");
        int loginId= input.nextInt();
        System.out.println("Jelszó: ");
        String pass = input.next();

        if(this.getUsers().get(loginId-1).getUserPassword().equals(pass)){
            userInterface(this.getUsers().get(loginId-1));
        }

    }

    public void userInterface(User _user){
        System.out.println("Folyószámlák listázása: ");

        for (int i = 0; i<=_user.getUserAccountsNumber()-1; i++) {
            System.out.println(_user.getUserAccounts().get(i).getAccountId() + ". folyoszamla adatai: ");
            System.out.println("Azonosito: " + _user.getUserAccounts().get(i).getAccountId());
            System.out.println("Egyenleg: " + _user.getUserAccounts().get(i).getAccountBalance() + " Ft ");
            System.out.println("_ _ _");// es akkor igy az ossyeg jon ki az adott fszamhoz
        }

        // Folyoszamla navigaciok
        Scanner in = new Scanner(System.in);

        System.out.println("Melyik folyoszamlan szeretne valtoztatasokat vegrehajtani? Irja be az azonositot.");
        int azonosito = in.nextInt();
        System.out.println("Lehetosegek: 1. Penz feltoltese \n 2. Penz utalasa/kuldese \n 3. Pezz kivetele");
        int action = in.nextInt();

        switch (action) {
            case 1:
                System.out.println("Mennyi penzt kivan feltolteni?");
                int amount = in.nextInt();
                break;
            case 2:
                break;
            case 3:
                break;
            default:
                break;
        }



    }

    //setter

    public void setAccountsNumber(int accountsNumber) {
        this.accountsNumber = accountsNumber;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }

    public void setUsersNumber() {
        this.usersNumber += 1;
    }
    //getter


    public int getAccountsNumber() {
        return accountsNumber;
    }

    public int getUsersNumber() {
        return usersNumber;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public String getBankName() {
        return bankName;
    }

}
