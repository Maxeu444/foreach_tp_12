package org.example.iterator;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class PoupeeRusse implements Iterable<PoupeeRusse> {
    private final int taille;
    private PoupeeRusse contenue;

    public PoupeeRusse(int taille) {
        if (taille <= 0) {
            throw new IllegalArgumentException("doit être supérieur à 1.");
        }
        this.taille = taille;
    }

    public int getTaille() {
        return taille;
    }

    public void inserer(PoupeeRusse poupée) {
        if (poupée == null) {
            throw new IllegalArgumentException("donnée invalide ou null.");
        }
        if (poupée.getTaille() >= this.taille) {
            throw new IllegalArgumentException("La poupée doit être plus petite.");
        }
        if (this.contenue != null) {
            this.contenue.inserer(poupée);
        } else {
            this.contenue = poupée;
        }
    }

    public PoupeeRusse getContenue() {
        return contenue;
    }

    @Override
    public Iterator<PoupeeRusse> iterator() {
        return new Iterator<PoupeeRusse>() {
            private PoupeeRusse current = PoupeeRusse.this;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public PoupeeRusse next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                PoupeeRusse result = current;
                current = current.getContenue();
                return result;
            }
        };
    }

    @Override
    public String toString() {
        return "PoupéeRusse{" +
                "taille=" + taille +
                '}';
    }

    public static void main(String[] args) {
        PoupeeRusse grande = new PoupeeRusse(10);
        PoupeeRusse moyenne = new PoupeeRusse(7);
        PoupeeRusse petite = new PoupeeRusse(5);

        grande.inserer(moyenne);
        moyenne.inserer(petite);

        System.out.println("poupées russes de la plus grande à la plus petite :");
        for (PoupeeRusse poupée : grande) {
            System.out.println(poupée);
        }
    }
}