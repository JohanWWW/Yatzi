package com.company;

public class Die {
    private int value;

    public Die() {
        value = (int) Math.random();
    }

    public int dieRoll() {
        value = (int)(Math.random()*6+1);
        return value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
