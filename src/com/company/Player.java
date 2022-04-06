package com.company;

import java.util.Random;

public class Player {
    static int[][][] faceConfig = { { { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 } },
            { { 0, 0, 1 }, { 0, 0, 0 }, { 1, 0, 0 } },
            { { 0, 0, 1 }, { 0, 1, 0 }, { 1, 0, 0 } },
            { { 1, 0, 1 }, { 0, 0, 0 }, { 1, 0, 1 } },
            { { 1, 0, 1 }, { 0, 1, 0 }, { 1, 0, 1 } },
            { { 1, 0, 1 }, { 1, 0, 1 }, { 1, 0, 1 } }};

    public static void printDice(int value) {

        //displays the value
        int[][] displayVal = faceConfig[value - 1];
        System.out.println("+---------+");
        for (int i = 0; i < 3; i++) {
            System.out.print("|");
            for (int j = 0; j < 3; j++) {
                if (displayVal[i][j] == 1) {
                    System.out.print(" # ");
                } else {
                    System.out.print("   ");
                }
            }
            System.out.println("|");
        }
        System.out.println("+---------+");
    }
    public static int rollTheDice(){
        Random r = new Random();
        return r.nextInt(6) + 1;
    }
}
