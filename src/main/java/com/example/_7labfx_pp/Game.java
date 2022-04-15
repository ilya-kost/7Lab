package com.example._7labfx_pp;

import java.util.Random;

public class Game {

    private int min;
    private int max;
    private int number;
    private Random random;

    public Game() {
        this.number = 0;
        this.random = new Random();
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int guessNumber() {
        return (getMin() + random.nextInt(getMax() - getMin() + 1));
    }

}

