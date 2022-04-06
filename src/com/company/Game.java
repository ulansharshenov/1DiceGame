package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Game {
    public static void game(){
        List<Integer> userList = new ArrayList<>();
        List<Integer> computerList = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("---------------   Start game   ---------------");
            //System.out.println("ROUND: " + i);
            System.out.print("Predict amount of points (2..12): ");
            int num1 = scanner.nextInt();
            //System.out.println("Do you want to cheat? Press 1 for YES / Press 2 for NO: ");
            System.out.println("User rolls the dices...");
            int a = Player.rollTheDice();
            int b = Player.rollTheDice();
            Player.printDice(a);
            Player.printDice(b);
            System.out.println("On the dice fell " + (a+b) + " points.");
            int points1 = ((a + b) - Math.abs((a + b) - num1) * 2);
            System.out.println("Result is " + (a+b) + " - abs(" + (a+b) +" - "
                    + num1 + ") * 2: " +  points1 + " points");

            System.out.println();
            Random random = new Random();
            int num2 = random.nextInt(12-2+1)+2;
            System.out.println("Computer predicted " + num2 +  " points");
            System.out.println("Computer rolls the dices...");
            int c = Player.rollTheDice();
            int d = Player.rollTheDice();
            Player.printDice(c);
            Player.printDice(d);
            System.out.println("On the dice fell " + (c+d) + " points.");
            int points2 = ((c + d) - Math.abs((c + d) - num1) * 2);
            System.out.println("Result is " + (c+d) + " - abs(" + (c+d) +" - "
                    + num2 + ") * 2: " +  points2 + " points");

            System.out.println();
            System.out.println("---------------   Current score   ---------------");
            System.out.println("User: " + points1 + " points");
            System.out.println("Computer: " + points2 + " points");
            if (points1 > points2){
                System.out.println("User is ahead by " + (points1-points2) + " points!");
                userList.add(num1);
                userList.add(a+b);
                userList.add(points1);

                computerList.add(num2);
                computerList.add(a+b);
                computerList.add(points2);

                System.out.println();
            }else if (points2 > points1){
                System.out.println("Computer is ahead by " + (points2-points1) + " points!");

                computerList.add(num2);
                computerList.add(a+b);
                computerList.add(points2);

                userList.add(num1);
                userList.add(a+b);
                userList.add(points1);
                System.out.println();
            }
        }

        System.out.println();
        System.out.println("---------------   Finish Game   ---------------");
        System.out.println();
        System.out.println(" Round |           User |      Computer ");

        int counter = 0;
        for (int h = 0; h < 3; h++){
            System.out.println("-------+----------------+----------------");
            System.out.println("       | Predicted:  " + userList.get(counter) + "  | Predicted:  " + computerList.get(counter));
            counter++;
            System.out.println(" - " + (h+1) + " - | Dice:       " + userList.get(counter) + "  | Dice:       " + computerList.get(counter));
            counter++;
            System.out.println("       | Result:     " + userList.get(counter) + "  | Result:     " + computerList.get(counter));
            counter++;
        }
        System.out.println("-------+----------------+----------------");

        int userSum = userList.stream().mapToInt(Integer::intValue).sum();
        int computerSum = computerList.stream().mapToInt(Integer::intValue).sum();
        System.out.println(" Total | Points:     " + userSum + " | Computer:   " + computerSum);

        System.out.println();

        if (userSum > computerSum)
            System.out.println("User win with " + (userSum - computerSum) + " points more. Congratulations!");
        if (userSum < computerSum)
            System.out.println("Computer win with " + (computerSum - userSum) + " points more. Congratulations!");
        if (userSum == computerSum)
            System.out.println("The result is same!");
    }
}
