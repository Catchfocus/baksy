package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {


    public static void separator(){
        System.out.println("\n- - - - - - - - - - - - - - - - - - - - - - - - \n");
    }


    public static void main(String[] args) throws IOException {

        int userchoice = 0;
        boolean running = true;

        Bank Banksy = new Bank("Banksy");




        while(running) {

            Banksy.updateMemoryFromDataBase("banksy.txt","banksy_accounts.txt", "banksy_users.txt", "temporary.txt");
            separator();
            System.out.println("Üdvözöllek a Banksy Fiktív Bank felhasználói felületén.");
            separator();
            System.out.println("Kérlek válassz az alábbi lehetőségek közül");
            separator();
            System.out.println("\t1 - Új felhasználó regisztráció\n\t2 - Bejelentkezés a fiókba\n\t3 - Összes felhasználó neve");

            System.out.println("\nUsers number from memory after clone from db:" + Banksy.getUsers().size());

            Scanner input = new Scanner(System.in);
            userchoice = input.nextInt();

            switch (userchoice) {


                case 1: Banksy.createNewUser();break;

                case 2: separator(); System.out.println("Ez még nincs kész sicc");  separator(); break;
                case 3: separator(); System.out.println("Az összes felhasználó neve");  Banksy.listAllUserName(); separator(); break;

                default: System.out.println("Nem értelmezhető input. Kérlek próbáld újra!");

            }
            // update database from memory
            Banksy.updateDataBaseFromMemory("banksy.txt","banksy_accounts.txt", "banksy_users.txt", "temporary.txt");
        }

    }
}
