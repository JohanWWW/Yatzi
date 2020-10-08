package com.company;

import java.util.Scanner;

public class YatziMain {
    public static Die[] dice;
    public static boolean isGameOver = false;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        startGame();
    }

    private static void startGame() {
        int turn;
        initializeDice();

        while (!isGameOver) {
            turn = 0;
            System.out.println("Welcome to Yatzi!");
            while (turn < 3) {
                System.out.println("Starting turn " + (turn + 1) + " of 3, rolling dice.");
                rollDice();

                if(checkIfYatzi()) {
                    System.out.println("You got YATZI! in " + dice[0].getValue() + "'s");
                    return;
                }

                //Here we check if there is no Yatzy: then we check what turn we are on and asks the player if we want to continue or not
                if(turn != 2) {
                    System.out.println("Want to throw again? (y for yes, anything else for no)");
                    if(promptUser()) {
                        turn++;
                    } else {
                        toggleGameOver();
                        break;
                    }
                } else {
                    System.out.println("Game over! Want to play again?");
                    if(promptUser()) {
                        turn = 0;
                    } else {
                        toggleGameOver();
                        break;
                    }
                }

            }
        }
    }

    private static boolean promptUser() {
        String input = scanner.next();
        switch (input) {
            case "y":
                return true;
            case "n":
            default:
                return false;
        }
    }

    private static void toggleGameOver() {
        isGameOver = !isGameOver;
    }

    private static boolean checkIfYatzi() {
        boolean isYatzi = true;
        for(int j = 1; j < 5; j++) {
            if(dice[j].getValue() != dice[j-1].getValue()) {
                isYatzi = false;
            }
        }
        return isYatzi;
    }

    private static void initializeDice() {
        dice = new Die[5];
        for(int d = 0; d < 5; d++) {
            dice[d] = new Die();
        }
    }

    private static void rollDice() {
        for(int i = 0; i < dice.length; i++) {
            dice[i].dieRoll();
            System.out.println(i + ": Dice shows " + dice[i].getValue());
        }
    }
}