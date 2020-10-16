package com.company;

import java.util.Scanner;

public class YatziMain {
    private Die[] dice;
    private Scanner scanner = new Scanner(System.in);
    private int turn;

    public static void main(String[] args) {
        var game = new YatziMain();
        game.startGame();
    }

    private void startGame() {
        initializeDice();
        turn = 0;
        while (!isGameOver()) {
            if (isFirstTurn())
                System.out.println("Welcome to Yatzi!");

            System.out.println("Starting turn " + (turn + 1) + " of 3, rolling dice.");
            rollDice();
            printDice();

            if(checkIfYatzi()) {
                System.out.println("You got YATZI! in " + dice[0].getValue() + "'s");
                return;
            }

            if(isLastTurn()) {
                System.out.println("Game over! Want to play again?");
                if(promptUser()) {
                    turn = 0;
                } else {
                    //toggleGameOver();
                    break;
                }
            } else {
                System.out.println("Want to throw again? (y for yes, anything else for no)");
                if(promptUser()) {
                    turn++;
                } else {
                    //toggleGameOver();
                    break;
                }
            }
       }
        scanner.close();
    }

    private boolean promptUser() {
        String input = scanner.next();
        switch (input) {
            case "y":
                return true;
            case "n":
            default:
                return false;

        }
    }

    private void initializeDice() {
        Die[] newDice = new Die[5];
        for(int i = 0; i < 5; i++) {
            newDice[i] = new Die();
        }
        setDice(newDice);
    }

    private void rollDice() {
        for (Die die: dice) {
            die.roll();
        }
    }

    private void printDice() {
        for (int i = 0; i < dice.length; i++) {
            System.out.println(i + ": Dice shows " + dice[i].getValue());
        }
    }

    private boolean isLastTurn() {
        return turn >= 2;
    }

    private boolean isFirstTurn() {
        return turn == 0;
    }

    private boolean isGameOver() {
        return turn == 3;
    }

    boolean checkIfYatzi() {
        boolean isYatzi = true;
        for(int i = 1; i < 5; i++) {
            if(dice[i].getValue() != dice[i - 1].getValue()) {
                isYatzi = false;
            }
        }
        return isYatzi;
    }

    void setDice(Die[] dice) {
        this.dice = dice;
    }
}