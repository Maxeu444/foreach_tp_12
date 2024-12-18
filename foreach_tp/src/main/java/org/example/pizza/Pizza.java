package org.example.pizza;
import lombok.*;

import java.util.*;

@Getter
@Setter
class Pizza {
    public enum Pate { EPAISSE, FINE }
    public enum Base { CREME, TOMATE }

    private Pate pate;
    private Base base;
    private List<Ingredient> fromages = new ArrayList<>();
    private List<Ingredient> proteines = new ArrayList<>();
    private List<Ingredient> assaisonnements = new ArrayList<>();
    private double prixFixe;
    private int tempsCuissonConseille = 90;

    public Pizza(Pate pate, Base base, double prixFixe) {
        this.pate = pate;
        this.base = base;
        this.prixFixe = prixFixe;
    }

    public void ajouterIngredient(Ingredient ingredient, String type) throws Exception {
        switch (type.toLowerCase()) {
            case "fromage":
                if (fromages.size() >= 5) throw new Exception("Maximum 5 fromages !");
                fromages.add(ingredient);
                break;
            case "protéine":
                if (proteines.size() >= 5) throw new Exception("Maximum 5 protéines !");
                proteines.add(ingredient);
                break;
            case "assaisonnement":
                if (assaisonnements.size() >= 5) throw new Exception("Maximum 5 assaisonnements !");
                assaisonnements.add(ingredient);
                break;
        }

        if (fromages.size() >= 4 && base != Base.CREME) {
            throw new Exception("Si 4 fromages ou plus, la base doit être CRÈME !");
        }
    }

    public double calculerPrix() {
        double total = prixFixe;
        for (Ingredient ing : fromages) total += ing.getPrixHT();
        for (Ingredient ing : proteines) total += ing.getPrixHT();
        for (Ingredient ing : assaisonnements) total += ing.getPrixHT();
        return total;
    }

    public int calculerCalories() {
        int total = 0;
        for (Ingredient ing : fromages) total += ing.getCalories();
        for (Ingredient ing : proteines) total += ing.getCalories();
        for (Ingredient ing : assaisonnements) total += ing.getCalories();
        return total;
    }
}