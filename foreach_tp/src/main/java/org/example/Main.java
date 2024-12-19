package org.example;

import org.example.bimap.BiMap;

import java.util.HashMap;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        // Initialiser BiMap
        BiMap<String, String> superheroes = new BiMap<>(new HashMap<>(), new HashMap<>());

        // Ajouter des éléments
        superheroes.put("Superman", "DCComics");
        superheroes.put("Batman", "DCComics");
        superheroes.put("Hulk", "Marvel");

        // Afficher les maps
        System.out.println("Superheroes map :");
        System.out.println(superheroes);

        // Récupérer une valeur
        System.out.println("\nSuperman appartient à : " + superheroes.getValue("Superman"));

        // Récupérer les clés associées à une valeur
        Set<String> dcComicsHeroes = superheroes.getKeysForValue("DCComics");
        System.out.println("Personnages de DCComics : " + dcComicsHeroes);

        // Supprimer une clé
        superheroes.removeKey("Superman");
        System.out.println("\nAprès suppression de Superman :");
        System.out.println(superheroes);

        // Supprimer une valeur
        superheroes.removeValue("DCComics");
        System.out.println("\nAprès suppression de DCComics :");
        System.out.println(superheroes);

        // Vérifier l'existence d'une clé ou d'une valeur
        System.out.println("\nHulk existe-t-il comme clé ? " + superheroes.containsKey("Hulk"));
        System.out.println("Marvel existe-t-il comme valeur ? " + superheroes.containsValue("Marvel"));
    }
}
