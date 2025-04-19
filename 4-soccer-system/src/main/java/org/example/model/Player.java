package org.example.model;

public class Player {
    private String name;
    private int years;
    private String position;
    private int numberShirt;
    private int numberGoals;

    public Player() {}

    public Player(String name, int years, String position, int numberShirt) {
        this.name = name;
        this.years = years;
        this.position = position;
        this.numberShirt = numberShirt;
        this.numberGoals = 0;
    }

    public String getName() {
        return name;
    }

    public int getYears() {
        return years;
    }

    public String getPosition() {
        return position;
    }

    public int getNumberShirt() {
        return numberShirt;
    }

    public int getNumberGoals() {
        return numberGoals;
    }

}