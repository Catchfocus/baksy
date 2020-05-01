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
    private int usersNumber= 0;
    private int accountsNumber = 0;

    public void listAllUserName(){
        for (int i=0; i<this.getUsersNumber(); i++) {
            System.out.println(this.getUsers().get(i).getUserName());
        }
    }


    public void updateMemoryFromDataBase(String _corePath, String _accountsPath, String _usersPath, String _temporaryPath) {
        try{

            File corefile = new File("banksy.txt");
            File accountsfile = new File("banksy_accounts.txt");
            File usersfile = new File("banksy_users.txt");
            File temporaryFile = new File("temporary.txt");

            //write

            // core a végén
             BufferedWriter writeAccount = new BufferedWriter(new FileWriter(accountsfile.getAbsoluteFile(),true));
             BufferedWriter writeUsers = new BufferedWriter(new FileWriter(usersfile.getAbsoluteFile(),true));
             BufferedWriter writeTemporary = new BufferedWriter(new FileWriter(temporaryFile.getAbsoluteFile()));

            //read

            BufferedReader readCore = new BufferedReader(new FileReader(corefile.getAbsoluteFile()));
            BufferedReader readAccounts = new BufferedReader(new FileReader(accountsfile.getAbsoluteFile()));
            BufferedReader readUsers = new BufferedReader(new FileReader(usersfile.getAbsoluteFile()));
            BufferedReader readTemporary = new BufferedReader(new FileReader(temporaryFile.getAbsoluteFile()));


            // update

            // LOG:TYPE USER1 USER1ACCOUMT1 USER2 USER2ACCOUNT1 USER1ACCOUNT1BALDIFF USER2ACCUNT1BALDIFF VALUTA  (utalás kati 1. folyójáról józsi 1. folyósára -3000 3000 HUF
            // USER : ID Vezeteknev Keresztnev jelszo yyyy m dd where
            // ACCOUNT: ID USERID Vezeteknev Keresztnev folyoszamlajelszo balance valuta
            // BANK: 0 <-- user
            //       0 <-- account



            int usersNumberFromdb = Integer.parseInt(readCore.readLine());
            int accountsNumberFromdb = Integer.parseInt(readCore.readLine());




            this.setUsersNumber(usersNumberFromdb);
            this.setAccountsNumber(accountsNumberFromdb);







            for(int i=0; i<this.getUsersNumber(); i++){

                // user

                String userData = readUsers.readLine(); // itt ugrani fog a kovi cikluusban

                String[] splittedUserData = userData.split("\\s+"); // ezt hogy szeretned?


                int _id = Integer.parseInt(splittedUserData[0]);

                String _name = String.join(" " ,splittedUserData[1],splittedUserData[2]);

                String _password = splittedUserData[3];

                String _year = splittedUserData[4];

                String _mounth = splittedUserData[5];

                String _day = splittedUserData[6];
                String _where = splittedUserData[7];
                int _accountsnumber = Integer.parseInt(splittedUserData[8]);
                System.out.println("_accountsnumber: " + _accountsnumber);



                User fromdb = new User(_id,_name,_password,_year,_mounth,_day,_where);
                fromdb.setUserAccountsNumber(_accountsnumber);


                String[] accounts = new String[]{};


/*
                for(int j=0; i<this.getAccountsNumber(); i++){
                    String accountData = readAccounts.readLine();
                    accounts = accountData.split("\\s+");

                    if(String.valueOf(fromdb.getUserId()).equals(accounts[1])){

                        int _accountId = Integer.parseInt(accounts[0]);
                        int _ownerId = Integer.parseInt(accounts[1]);
                        String _ownername = accounts[2] + " " + accounts[3];
                        String _accountpassword = accounts[4];
                        int _balance = Integer.parseInt(accounts[5]);
                        String _valuta = accounts[6];


                        Account fromdbAccount = new Account(_accountId, _ownerId, _ownername, _accountpassword, _balance, _valuta);
                        fromdb.getUserAccounts().add(fromdbAccount);
                    }
                }

 */


                this.getUsers().add(fromdb);
            }


            // Banksy txt megnyitása és az a kemény két sor kiolvasása





            // legvégén kell lennie mert ebben összesítés van, és mindig törli az előzőt
            BufferedWriter writeCore = new BufferedWriter(new FileWriter(corefile.getAbsoluteFile(),true));
            writeCore.flush();
            writeCore.write(this.getUsersNumber());
            writeCore.newLine();
            writeCore.write(this.getAccountsNumber());




            readCore.close();
            readAccounts.close();
            readUsers.close();
            readTemporary.close();

          // writeCore.close();
           writeAccount.close();
           writeUsers.close();
           writeTemporary.close();


        }catch(Exception e){

        }

    }

    public void updateDataBaseFromMemory(String _corePath, String _accountsPath, String _usersPath, String _temporaryPath) {
        try{

            File corefile = new File("banksy.txt");
            File accountsfile = new File("banksy_accounts.txt");
            File usersfile = new File("banksy_users.txt");
            File temporaryFile = new File("temporary.txt");

            //write
            // core a végén
            BufferedWriter writeAccount = new BufferedWriter(new FileWriter(accountsfile.getAbsoluteFile()));
            BufferedWriter writeUsers = new BufferedWriter(new FileWriter(usersfile.getAbsoluteFile(),true));
            BufferedWriter writeTemporary = new BufferedWriter(new FileWriter(temporaryFile.getAbsoluteFile(),true));

            //read

            BufferedReader readCore = new BufferedReader(new FileReader(corefile.getAbsoluteFile()));
            BufferedReader readAccounts = new BufferedReader(new FileReader(accountsfile.getAbsoluteFile()));
            BufferedReader readUsers = new BufferedReader(new FileReader(usersfile.getAbsoluteFile()));
            BufferedReader readTemporary = new BufferedReader(new FileReader(temporaryFile.getAbsoluteFile()));

            writeAccount.flush();
            writeUsers.flush();
            writeTemporary.flush();
            // update

            // LOG:TYPE USER1 USER1ACCOUMT1 USER2 USER2ACCOUNT1 USER1ACCOUNT1BALDIFF USER2ACCUNT1BALDIFF VALUTA  (utalás kati 1. folyójáról józsi 1. folyósára -3000 3000 HUF
            // USER : ID Vezeteknev Keresztnev jelszo yyyy m dd where accountnumber
            // ACCOUNT: ID USERID Vezeteknev Keresztnev folyoszamlajelszo balance valuta
            // BANK: 0 <-- user
            //       0 <-- account


            for(int i=0; i<=this.getUsersNumber();i++){
                String _id =String.valueOf(this.getUsers().get(i).getUserId());
                String _name = this.getUsers().get(i).getUserName();
                String _password = this.getUsers().get(i).getUserPassword();
                String _year = this.getUsers().get(i).getUserBirthInformation()[0];
                String _mounth = this.getUsers().get(i).getUserBirthInformation()[1];
                String _day = this.getUsers().get(i).getUserBirthInformation()[2];
                String _where = this.getUsers().get(i).getUserBirthInformation()[3];
                String _accountnumber = String.valueOf(this.getUsers().get(i).getUserAccountsNumber());

                String line = String.join(" ",_id,_name,_password,_year,_mounth,_day,_where,_accountnumber);
                String readedLine = readUsers.readLine();

                if(!line.contains(readedLine)){
                    writeUsers.newLine();
                    writeUsers.write(line);

                }


            }









            // legvégén kell lennie mert ebben összesítés van, és mindig törli az előzőt

            BufferedWriter writeCore = new BufferedWriter(new FileWriter(corefile.getAbsoluteFile()));
            writeCore.flush();
            writeCore.write(String.valueOf(this.getUsersNumber()));
            writeCore.newLine();
            writeCore.write(String.valueOf(this.getAccountsNumber()));




            readCore.close();
            readAccounts.close();
            readUsers.close();
            readTemporary.close();

            writeCore.close();
            writeAccount.close();
            writeUsers.close();
            writeTemporary.close();

            this.getUsers().clear();
            this.setAccountsNumber(0);
            this.setUsersNumber(0);


        }catch(Exception e){

        }

    }

    public void createNewUser(){

        try {

        Scanner in = new Scanner(System.in);

            File corefile = new File("banksy.txt");
            File accountsfile = new File("banksy_accounts.txt");
            File usersfile = new File("banksy_users.txt");
            File temporaryFile = new File("temporary.txt");

            //write


            FileWriter wAccounts = new FileWriter(accountsfile.getAbsoluteFile(),true);
            FileWriter wUsers = new FileWriter(usersfile.getAbsoluteFile(),true);
            FileWriter wTemporary = new FileWriter(temporaryFile.getAbsoluteFile());


            BufferedWriter writeAccount = new BufferedWriter(wAccounts);
            BufferedWriter writeUsers = new BufferedWriter(wUsers);

            //read

            FileReader rCore = new FileReader(corefile.getAbsoluteFile());
            FileReader rAccounts = new FileReader(accountsfile.getAbsoluteFile());
            FileReader rUsers = new FileReader(usersfile.getAbsoluteFile());

            BufferedReader readCore = new BufferedReader(rCore);
            BufferedReader readAccounts = new BufferedReader(rAccounts);
            BufferedReader readUsers = new BufferedReader(rUsers);



            String usersNumberFromFile = readCore.readLine();

            System.out.println("usersnumberfromfile: " + usersNumberFromFile);

            String accountsNumberFromFile = readCore.readLine();
            System.out.println("accountsnumberfromfile: " + accountsNumberFromFile);

            this.setUsersNumber(Integer.parseInt(usersNumberFromFile));
            this.setAccountsNumber(Integer.parseInt(accountsNumberFromFile));

            System.out.println("Users and account: " + this.getUsersNumber()+ " "+ this.getAccountsNumber());

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
        this.addUsersNumber(1); // mintha lett volna benne vmi kodformazo funkci - ez noveli, igaz?

        System.out.println("newusersnumber: " + this.getUsersNumber());


        // A get users numbert is, a banksy_users.txt hosszaval
        User newUser = new User(this.getUsersNumber(),name,pass,y,m,d,w);
        this.getUsers().add(newUser);

        // Egyszer azt a ket sort ki lehetne szedni, majd valahogyan a folyoszamlat is be kell tolteni a felhasznaloknak
            // marmint a memoria feltolteskor

        newUser.createNewAccount(this.getAccountsNumber());


        this.addAccountsNumber(newUser.getUserAccountsNumber());

        System.out.println("Accounts: " + this.getAccountsNumber());

            String userData =
                    String.format("%d %s %s %s %s %s %s %d",
                            newUser.getUserId(),
                            newUser.getUserName(),
                            newUser.getUserPassword(),
                            newUser.getUserBirthInformation()[0],
                            newUser.getUserBirthInformation()[1],
                            newUser.getUserBirthInformation()[2],
                            newUser.getUserBirthInformation()[3],
                            newUser.getUserAccountsNumber());

            System.out.println(userData);

            writeUsers.write(userData);


            writeUsers.newLine();

            String usersNumberToCore = Integer.toString(this.getUsersNumber());
            String accountsNumberToCore = Integer.toString(this.getAccountsNumber());

            FileWriter wCore = new FileWriter(corefile.getAbsoluteFile());
            BufferedWriter writeCore = new BufferedWriter(wCore);

            writeCore.flush();
            writeCore.write(usersNumberToCore);
            writeCore.newLine();
            writeCore.write(accountsNumberToCore);
            writeCore.newLine();

            writeCore.close();
            writeAccount.close();
            writeUsers.close();

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

        if(this.getUsers().get(loginId).getUserPassword().equals(pass)){
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