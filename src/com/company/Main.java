package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Game.game();
        System.out.println();
        System.out.println("Do you want to play one more time? Press 1 for YES / Press 2 for NO:");
        int inputNumber = scanner.nextInt();
        if (inputNumber == 1){
            Game.game();
        }else if (inputNumber == 2){
            System.out.println("GAME IS OVER!!!");
        }
    }
}
