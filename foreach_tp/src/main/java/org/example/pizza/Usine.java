package org.example.pizza;
import java.util.*;


public class Usine {
    private List<Four> fours = new ArrayList<>();

    public void ajouterFour(Four four) {
        fours.add(four);
    }

    public Four trouverFourDisponible() {
        for (Four four : fours) {
            if (four.enfournerPizza(new Pizza(Pizza.Pate.EPAISSE, Pizza.Base.TOMATE, 10.0))) {
                return four;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        // Création d'ingrédients
        Ingredient fromage = new Ingredient("Mozzarella", 300, 2.5, "Italie");
        Ingredient jambon = new Ingredient("Jambon", 200, 3.0, "France");
        Ingredient olive = new Ingredient("Olive", 50, 1.0, null);

        // Création d'une pizza
        Pizza pizza = new Pizza(Pizza.Pate.FINE, Pizza.Base.TOMATE, 5.0);
        try {
            pizza.ajouterIngredient(fromage, "fromage");
            pizza.ajouterIngredient(jambon, "protéine");
            pizza.ajouterIngredient(olive, "assaisonnement");
        } catch (Exception e) {
            System.out.println("Erreur lors de l'ajout des ingrédients : " + e.getMessage());
        }

        // Création de fours
        Four fourBois = new Four(Four.TypeFour.BOIS, 500, 1);
        Four fourElectrique = new Four(Four.TypeFour.ELECTRIQUE, 450, 5);

        // Création de l'usine
        Usine usine = new Usine();
        usine.ajouterFour(fourBois);
        usine.ajouterFour(fourElectrique);

        // Enfournement de la pizza
        if (fourBois.enfournerPizza(pizza)) {
            System.out.println("Pizza enfournée dans le four à bois !");
        } else {
            System.out.println("Impossible d'enfourner dans le four à bois.");
        }

        // Surveillance de la cuisson
        try {
            Thread.sleep(3000); // Attendre un peu pour simuler la cuisson
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (fourBois.estCuissonTerminee(pizza)) {
            System.out.println("Pizza prête !");
        } else {
            System.out.println("Pizza encore en cuisson.");
        }

        // Défourner
        Pizza pizzaDefournee = fourBois.defournerPizza();
        if (pizzaDefournee != null) {
            System.out.println("Pizza défournée : prête à être servie !");
        } else {
            System.out.println("Aucune pizza à défourner.");
        }
    }
}
