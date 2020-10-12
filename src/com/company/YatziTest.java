package com.company;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class YatziTest {
    @Test
    void isYatziWhenAllDiceMatches() {
        // Arrange
        Die[] dice = initializeTestDice();
        for(Die die: dice) {
            die.setValue(6);
        }
        YatziMain.setDice(dice);

        // Act
        boolean isYatzi = YatziMain.checkIfYatzi();

        // Assert
        assertTrue(isYatzi);
    }

    @Test
    void isNotYatziWhenOneDieIsNotMatchingTheOther() {
        Die[] dice = initializeTestDice();
        for(Die die: dice) {
            die.setValue(6);
        }
        dice[4].setValue(1);
        //Assert something?
    }

    private Die[] initializeTestDice() {
        return new Die[] {
            new Die(),
            new Die(),
            new Die(),
            new Die(),
            new Die()
        };
    }
}
