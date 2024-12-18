package org.example.pizza;
import java.util.*;
import lombok.*;

@Getter
@Setter
class Four {
    public enum TypeFour { BOIS, ELECTRIQUE, ATOMIQUE }

    private TypeFour typeFour;
    private int temperatureCuisson;
    private int maxPizzas;
    private Queue<Pizza> pizzasEnfournees = new LinkedList<>();
    private Map<Pizza, Long> tempsEnfournement = new HashMap<>(); // Associe les pizzas à leur instant d'enfournement

    public Four(TypeFour typeFour, int temperatureCuisson, int maxPizzas) {
        this.typeFour = typeFour;
        this.temperatureCuisson = temperatureCuisson;
        this.maxPizzas = maxPizzas;
    }

    public boolean enfournerPizza(Pizza pizza) {
        if (pizzasEnfournees.size() < maxPizzas) {
            pizzasEnfournees.add(pizza);
            tempsEnfournement.put(pizza, System.currentTimeMillis());
            return true;
        }
        return false;
    }

    public Pizza defournerPizza() {
        Pizza pizza = pizzasEnfournees.poll();
        if (pizza != null) {
            tempsEnfournement.remove(pizza);
        }
        return pizza;
    }

    public boolean estCuissonTerminee(Pizza pizza) {
        Long tempsDebut = tempsEnfournement.get(pizza);
        if (tempsDebut == null) return false;
        long tempsEcoule = (System.currentTimeMillis() - tempsDebut) / 1000; // Convertir en secondes
        double tempsCuissonEffectif = 400.0 / temperatureCuisson * pizza.getTempsCuissonConseille();
        return tempsEcoule >= tempsCuissonEffectif;
    }

    public int getTemperatureCuisson() {
        return temperatureCuisson;
    }
}
