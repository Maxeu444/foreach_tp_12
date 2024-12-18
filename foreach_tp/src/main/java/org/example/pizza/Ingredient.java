package org.example.pizza;

public class Ingredient {
    private String nom;
    private int calories;
    private double prixHT;
    private String AOC; // Optionnel

    public Ingredient(String nom, int calories, double prixHT, String AOC) {
        this.nom = nom;
        this.calories = calories;
        this.prixHT = prixHT;
        this.AOC = AOC;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public double getPrixHT() {
        return prixHT;
    }

    public void setPrixHT(double prixHT) {
        this.prixHT = prixHT;
    }

    public String getAOC() {
        return AOC;
    }

    public void setAOC(String AOC) {
        this.AOC = AOC;
    }
}
