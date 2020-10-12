package com.company;

public class Die {
    private int value;

    public void roll() {
        value = (int)(Math.random() * 6 + 1);
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
