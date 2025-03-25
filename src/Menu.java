import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    private Scanner scanner = new Scanner(System.in);
    private ArrayList<Pizza> pizzaMenu = new ArrayList<>();
    private ArrayList<Bestilling> aktiveOrdrer = new ArrayList<>();

    public Menu() {
        pizzaMenu.add(new Pizza(1, "Vesuvio", 57, "Tomatsauce, ost, skinke, oregano"));
        pizzaMenu.add(new Pizza(2, "Amerikaner", 53, "Tomatsauce, ost, oksefars, oregano"));
        pizzaMenu.add(new Pizza(3, "Cacciatore", 57, "Tomatsauce, ost, pepperoni, oregano"));
        pizzaMenu.add(new Pizza(4, "Carbona", 63, "Tomatsauce, ost, kødsauce, spaghetti, cocktailpølser, oregano"));
        pizzaMenu.add(new Pizza(5, "Dennis", 65, "Tomatsauce, ost, skinke, pepperoni, cocktailpølser, oregano"));

    }

    public void visHovedMenu() {
        boolean kører = true;
        while (kører) {
            System.out.println("\nVelkommen tilbage!");
            System.out.println("1. Opret ny ordre");
            System.out.println("2. Se menukortet");
            System.out.println("3. Se aktive ordrer");
            System.out.println("4. Afslut program");
            System.out.print("Vælg en mulighed: ");

            int valg = scanner.nextInt();
            scanner.nextLine(); // Ryd scanner

            switch (valg) {
                case 1 -> opretOrdre();
                case 2 -> visMenu();
                case 3 -> visAktiveOrdrer();
                case 4 -> {
                    System.out.println("Programmet afsluttes...");
                    kører = false;
                }
                default -> System.out.println("Ugyldigt valg, prøv igen.");
            }
        }
    }

    public void visMenu() {
        System.out.println("\n--- Pizzamenu ---");
        for (Pizza pizza : pizzaMenu) {
            System.out.println(pizza);
        }
    }

    private void opretOrdre() {
        System.out.println("\n--- Opret ny ordre ---");
        System.out.print("Hvornår skal ordren være klar? (f.eks. 18:30): ");
        String afhentningstidspunkt = scanner.nextLine();
        Bestilling nyOrdre = new Bestilling(afhentningstidspunkt);

        boolean tilføjerPizza = true;
        while (tilføjerPizza) {
            System.out.println("\nIndtast nummeret på pizzaen, du vil tilføje (eller 0 for at afslutte): ");
            visMenu();

            if (scanner.hasNextInt()) {
                int pizzaNummer = scanner.nextInt();
                scanner.nextLine();

                if (pizzaNummer == 0) {
                    tilføjerPizza = false;
                } else {
                    Pizza valgtPizza = findPizza(pizzaNummer);
                    if (valgtPizza != null) {
                        nyOrdre.tilføjPizza(valgtPizza);
                        System.out.println(valgtPizza.getNavn() + " tilføjet til ordren.");
                    } else {
                        System.out.println("Ugyldigt pizzanummer, prøv igen.");
                    }
                }
            } else {
                System.out.println("Ugyldigt input. Indtast venligst et tal.");
                scanner.next();
            }
        }

        aktiveOrdrer.add(nyOrdre);
        System.out.println("Ordre oprettet:\n" + nyOrdre);
    }

    private Pizza findPizza(int nummer) {
        for (Pizza pizza : pizzaMenu) {
            if (pizza.getNummer() == nummer) {
                return pizza;
            }
        }
        return null;
    }

    private void visAktiveOrdrer() {
        System.out.println("\n--- Aktive ordrer ---");
        if (aktiveOrdrer.isEmpty()) {
            System.out.println("Ingen aktive ordrer.");
        } else {
            for (Bestilling ordre : aktiveOrdrer) {
                System.out.println(ordre);
            }
        }
    }
}
