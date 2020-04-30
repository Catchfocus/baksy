package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Bank {


    Bank(String _bankName){
        this.setBankName(_bankName);

        System.out.println("Bank létrehozva: " + this.getBankName());
    }

    public ArrayList<User> users = new ArrayList<User>();

    private String bankName="";
    private int usersNumber= getUsers().size();
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

        try {

        Scanner in = new Scanner(System.in);

            File file = new File("banksy_database.txt");
            FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
            BufferedWriter bw = new BufferedWriter(fw);
            BufferedReader br = new BufferedReader(new FileReader("banksy_database.txt"));

            String line = (String)(this.getUsersNumber()+" "+this.getAccountsNumber()); // szerintem leallitottam az elot 0 0

            String[] bankusersandaccounts = new String[]{"0","0"};
            String firstLine = br.readLine(); // ez az elso sor, hmm nem tudom
            //System.out.println(firstLine);



            System.out.println(firstLine.contains(line)); // 0 0 vs 1 asd asd asd asd asd asd 1

            while(firstLine.contains(line)){
                 bankusersandaccounts = firstLine.split("\\s+");

                 firstLine = (br.readLine() != null) ? br.readLine() : ""; // de az a baj, hogy ugyis beszivja a NULLt

                System.out.println("match");
            } // pont rosszul mondtam. vagyis, azt nem tudom h miert nem lep ki


            this.setUsersNumber(Integer.parseInt(bankusersandaccounts[0]));
            this.setAccountsNumber(Integer.parseInt(bankusersandaccounts[1]));

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
        this.addUsersNumber(1);
        User newUser = new User(this.getUsersNumber(),name,pass,y,m,d,w);
        this.getUsers().add(newUser);

        newUser.createNewAccount();

        this.addUsersNumber(newUser.getUserAccountsNumber());


            String content =
                    String.format("%d %s %s %s %s %s %d",
                            newUser.getUserId(),
                            newUser.getUserName(),
                            newUser.getUserPassword(),
                            newUser.getUserBirthInformation()[0],
                            newUser.getUserBirthInformation()[1],
                            newUser.getUserBirthInformation()[2],
                            newUser.getUserAccountsNumber());

            bw.write(content);
            bw.newLine();
            bw.close();
            // nem tudom

            BufferedWriter bwnew = new BufferedWriter(new FileWriter("banksy_database.txt", false));
            //bw.write((String)(this.getUsersNumber()+" "+this.getAccountsNumber())); // kipro oh nem
            bwnew.write((String)(this.getUsersNumber()+" "+this.getAccountsNumber()));
            //bwnew.write(content); -- firstline + all_content, else it overwrites

            bwnew.newLine();
            bwnew.write(content);
            //bwnew.newLine(); // probaltam atgondolni, de azt kene, hogy mindent ami nem az elso sor
            // osszegyujteni, es ciklussal kitologatni ujra igen. En is akarok, szoval okes. :D jo

            br.close(); // ohh most meg talan a ping is jobb lett
            bwnew.close();
        }
        catch(IOException e){
            System.out.println("Hiba történt az adatbázis elérése közben.");
        }

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

    public void addAccountsNumber(int n){
        this.accountsNumber+=n;
    }

    public void setAccountsNumber(int accountsNumber) {
        this.accountsNumber = accountsNumber;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }

    public void addUsersNumber(int n) {
        this.usersNumber += n;
    }

    public void setUsersNumber(int usersNumber) {
        this.usersNumber = usersNumber;
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
