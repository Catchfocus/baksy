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

        Banksy.bankLoop();

    }
}
