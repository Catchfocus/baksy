package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {


    public static void separator(){
        System.out.println("\n- - - - - - - - - - - - - - - - - - - - - - - - \n");
    }

    public static String[] createReadStream(String file_name) throws IOException {
        BufferedReader abc = new BufferedReader(new FileReader(file_name));

        List<String> lines = new ArrayList<String>();
        String line;
        while((line = abc.readLine()) != null) {
            lines.add(line);
        }
        abc.close();

        String[] data = lines.toArray(new String[]{});

        return data;
    } // en azt talaltam ki, h egy tombot adunk at a kiiratasnal, es loop utan dobunk csak uj sort

    public static void createWriteStream(String[] input, String file_name) throws IOException {
        String[] content = input; // Splitelni csak stringet lehet :D
        File file = new File(file_name);
        FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
        BufferedWriter bw = new BufferedWriter(fw);

        String row = String.join(" ", content);
        bw.write(row);
        bw.newLine(); // Ez ugy dontott, h akkor nem mukodik

        bw.close(); // igen, csak elfailol az uj sorral. utana irjuk hozza aket ujat, miutan beolvasta
    }

    // Database -> Banksy_database.txt, neve, adatai, meg a folyószámlák id-ja
       //         Accounts_txt Csak folyószámlák, a fájl név pedig id


    public static void main(String[] args) throws IOException {

        int userchoice = 0;
        boolean running = true;

        Bank Banksy = new Bank("Banksy");


        createWriteStream(new String[]{"1", "2"},"banksy_database.txt");

        String[] data = createReadStream("banksy_database.txt");
        for (int i = 0; i< data.length; i++) {
            System.out.println(data[i]); // es akkor ez egy sor lesz, ha minden igaz
            // ezzel lehet annyi lesz a baj, h nem dob uj sort, hanem felulirja. hogy erted? nezd
        }

        while(running) {
            separator();
            System.out.println("Üdvözöllek a Banksy Fiktív Bank felhasználói felületén.");
            separator();
            System.out.println("Kérlek válassz az alábbi lehetőségek közül");
            separator();
            System.out.println("\t1 - Új felhasználó regisztráció\n\t2 - Bejelentkezés a fiókba\n\t3 - Összes felhasználó listázása");

            Scanner input = new Scanner(System.in);
            userchoice = input.nextInt();

            switch (userchoice) {

                case 1: Banksy.createNewUser();break;

                case 2: separator(); System.out.println("Ez még nincs kész sicc"); Banksy.login(); separator(); break;
                case 3: separator(); System.out.println("Az összes felhasználó adatainak kilistázása"); separator(); Banksy.listAllUserData(); separator(); break;

                default: System.out.println("Nem értelmezhető input. Kérlek próbáld újra!");

            } // En is kezkek mar faramsdkdalsk
        }

    }
}
