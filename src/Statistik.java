import java.util.ArrayList;
import java.util.List;

public class Statistik {

    // Klasse til at gemme både pizza og dens solgte antal
    class PizzaStatistik {
        Pizza pizza;
        int antalSolgt;

        PizzaStatistik(Pizza pizza) {
            this.pizza = pizza;
            this.antalSolgt = 0;
        }

        void opdaterStatistik() {
            antalSolgt++;
        }

        @Override
        public String toString() {
            return pizza.getNavn() + ": " + antalSolgt + " solgt(e).";
        }
    }

    // Liste af pizza statistikker
    private List<PizzaStatistik> pizzaStatistikListe = new ArrayList<>();

    public Statistik(List<Pizza> pizzaMenu) {
        // Opretter en pizzaStatistik for hver pizza
        for (Pizza pizza : pizzaMenu) {
            pizzaStatistikListe.add(new PizzaStatistik(pizza));
        }
    }

    // Nulstiller statistikken før opdatering
    private void nulstilStatistik() {
        for (PizzaStatistik pizzaStatistik : pizzaStatistikListe) {
            pizzaStatistik.antalSolgt = 0; // Nulstil antal solgte pizzaer
        }
    }

    // Opdaterer statistikken, når en ordre er afsluttet
    public void opdaterStatistik(List<Bestilling> afsluttedeOrdrer) {
        System.out.println("Opdaterer statistik med afsluttede ordrer...");

        // Før vi opdaterer, nulstiller vi statistikken
        nulstilStatistik();

        // Opdaterer statistikken med afsluttede ordrer
        for (Bestilling ordre : afsluttedeOrdrer) {
            for (Pizza pizza : ordre.getPizzaer()) {
                // Opdater statistik for hver pizza i ordren
                for (PizzaStatistik pizzaStatistik : pizzaStatistikListe) {
                    if (pizzaStatistik.pizza.equals(pizza)) {
                        pizzaStatistik.opdaterStatistik();
                        break;
                    }
                }
            }
        }
    }

    // Beregn den samlede omsætning
    public double beregnOmsætning(List<Bestilling> afsluttedeOrdrer) {
        double totalOmsætning = 0;
        for (Bestilling ordre : afsluttedeOrdrer) {
            for (Pizza pizza : ordre.getPizzaer()) {
                totalOmsætning += pizza.getPris();
            }
        }
        return totalOmsætning;
    }

    // Vist statistik
    public void visStatistik(List<Bestilling> afsluttedeOrdrer) {
        System.out.println("\n--- Salgsstatistik ---");

        if (afsluttedeOrdrer == null || afsluttedeOrdrer.isEmpty()) {
            System.out.println("Der er ikke afsluttede ordrer endnu.");
            return;
        }

        // Opdater statistik med afsluttede ordrer
        opdaterStatistik(afsluttedeOrdrer);

        // Vis de mest solgte pizzaer
        System.out.println("\nMest solgte pizzaer:");
        // Sorter pizzaStatistikListe efter antal solgt (fra mest solgt til mindst solgt)
        pizzaStatistikListe.sort((pizza1, pizza2) -> pizza2.antalSolgt - pizza1.antalSolgt);

        // Udskriv kun de pizzaer, der er solgt (antalSolgt > 0)
        boolean nogenSolgt = false;  // For at holde styr på, om der er solgt nogen pizzaer
        for (PizzaStatistik pizzaStatistik : pizzaStatistikListe) {
            if (pizzaStatistik.antalSolgt > 0) {
                System.out.println(pizzaStatistik);
                nogenSolgt = true;
            }
        }

        if (!nogenSolgt) {
            System.out.println("Ingen pizzaer er blevet solgt endnu.");
        }

        // Beregn og vis den samlede omsætning
        double omsætning = beregnOmsætning(afsluttedeOrdrer);
        System.out.println("\nSamlet omsætning: " + String.format("%.2f", omsætning) + " kr.");
    }
}




