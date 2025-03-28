import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Menu {
        private Scanner scanner = new Scanner(System.in);
        private ArrayList<Pizza> pizzaMenu = new ArrayList<>();
        private ArrayList<Bestilling> aktiveOrdrer = new ArrayList<>();
        private ArrayList<Bestilling> afsluttedeOrdre = new ArrayList<>();

        public Menu() {
                pizzaMenu.add(new Pizza(1, "Vesuvio", 57, "Tomatsauce, ost, skinke, oregano"));
                pizzaMenu.add(new Pizza(2, "Amerikaner", 53, "Tomatsauce, ost, oksefars, oregano"));
                pizzaMenu.add(new Pizza(3, "Cacciatore", 57, "Tomatsauce, ost, pepperoni, oregano"));
                pizzaMenu.add(new Pizza(4, "Carbona", 63, "Tomatsauce, ost, kødsauce, spaghetti, cocktailpølser, oregano"));
                pizzaMenu.add(new Pizza(5, "Dennis", 65, "Tomatsauce, ost, skinke, pepperoni, cocktailpølser, oregano"));
                pizzaMenu.add(new Pizza(6, "Bertil", 57, "Tomatsauce, ost, bacon, oregano"));
                pizzaMenu.add(new Pizza(7, "Silvia", 61, "Tomatsauce, ost, pepperoni, rød peber, løg, oliven, oregano"));
                pizzaMenu.add(new Pizza(8, "Victoria", 61, "Tomatsauce, ost, skinke, ananas, champignon, løg, oregano"));
                pizzaMenu.add(new Pizza(9, "Toronto", 61, "Tomatsauce, ost, skinke, bacon, kebab, chili, oregano"));
                pizzaMenu.add(new Pizza(10, "Capricciosa", 61, "Tomatsauce, ost, skinke, champignon, oregano"));
                pizzaMenu.add(new Pizza(11, "Hawaii", 61, "Tomatsauce, ost, skinke, ananas, oregano"));
                pizzaMenu.add(new Pizza(12, "Le Blissola", 61, "Tomatsauce, ost, skinke, rejer, oregano"));
                pizzaMenu.add(new Pizza(13, "Venezia", 61, "Tomatsauce, ost, skinke, bacon, oregano"));
                pizzaMenu.add(new Pizza(14, "Mafia", 61, "Tomatsauce, ost, pepperoni, bacon, løg, oregano"));
                pizzaMenu.add(new Pizza(15, "Margherita", 56, "Tomatsovs, ost, oregano"));
                pizzaMenu.add(new Pizza(16, "Kartoffel", 67, "Mascarpone, kartoffel, basil, løg"));
                pizzaMenu.add(new Pizza(17, "Italiano", 64, "Tomatsovs, ost, peberfrugt, pepperoni, løg"));
                pizzaMenu.add(new Pizza(18, "Speciale", 70, "Tomatsovs, ost, kylling, ananas, oliven"));
                pizzaMenu.add(new Pizza(19, "Parken", 62, "Mascarpone, pepperoni, bacon"));
                pizzaMenu.add(new Pizza(20, "Kebab", 64, "Tomatsovs, ost, kebab, løg"));
                pizzaMenu.add(new Pizza(21, "Venizio", 65, "Tomatsauce, kylling, bacon, peberfrugt"));
                pizzaMenu.add(new Pizza(22, "Forte", 67, "Tomatsauce, ost, chili, ham, spinat"));
                pizzaMenu.add(new Pizza(23, "Carne", 71, "Tomatsovs, ost, pølse, skinke, bacon"));
                pizzaMenu.add(new Pizza(24, "Picante", 68, "Tomatsovs, ost, kød, artiskokker, chili"));
                pizzaMenu.add(new Pizza(25, "Amor", 67, "Tomatsovs, ost, skinke, chili, champignon"));
                pizzaMenu.add(new Pizza(26, "Mario special", 73, "Tomatsovs, ost, kebab, salat, dressing m. agurk"));
                pizzaMenu.add(new Pizza(27, "Antonelli", 65, "Tomatsovs, ost, skinke, ananas, champignon"));
                pizzaMenu.add(new Pizza(28, "Nørrebro", 62, "Tomatsovs, ost, kylling, peberfrugt, løg"));
                pizzaMenu.add(new Pizza(29, "Vegetar", 64, "Tomatsovs, ost, champignon, løg, oliven"));
                pizzaMenu.add(new Pizza(30, "Filip", 66, "Tomatsovs, ost, pepperoni, skinke, peberfrugt, løg"));
        }

        public void visHovedMenu() {
                boolean kører = true;
                while (kører) {
                        System.out.println("\nVelkommen tilbage!");
                        System.out.println("1. Opret ny ordre");
                        System.out.println("2. Se menukortet");
                        System.out.println("3. Se aktive ordrer");
                        System.out.println("4. Se afsluttede ordrer");
                        System.out.println("5. Vis omsætning");
                        System.out.println("6. Afslut program");
                        System.out.print("Vælg en mulighed: ");

                        if (scanner.hasNextInt()) {
                                int valg = scanner.nextInt();
                                scanner.nextLine();

                                switch (valg) {
                                        case 1 -> opretOrdre();
                                        case 2 -> visMenu();
                                        case 3 -> visAktiveOrdrer();
                                        case 4 -> visAfsluttedeOrdrer();
                                        case 5 -> visOmsætning();
                                        case 6 -> {
                                                System.out.println("Programmet afsluttes...");
                                                kører = false;
                                        }
                                        default -> System.out.println("Ugyldigt valg, prøv igen.");
                                }
                        } else {
                                System.out.println("Ugyldigt input, prøv igen.");
                                scanner.nextLine();
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
                String afhentningstidspunktString = scanner.nextLine();
                DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
                LocalTime localTime = LocalTime.parse(afhentningstidspunktString, timeFormatter);
                LocalDateTime localDateTime = LocalDateTime.of(LocalDate.now(), localTime);
                Date afhentningstidspunkt = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());

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
                                scanner.nextLine();
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

                        boolean seAktiveOrdre = true;
                        while (seAktiveOrdre) {
                                if (aktiveOrdrer.isEmpty()) {
                                        System.out.println("Ingen aktive ordrer.");
                                        seAktiveOrdre = false;
                                } else {
                                        aktiveOrdrer.sort(Comparator.comparing(Bestilling::getAfhentningstidspunkt));
                                        System.out.println(aktiveOrdrer);
                                        System.out.println("\nIndtast ordrenummeret på den afsluttede ordre (eller 0 for at afslutte): ");
                                        int ordreNummer = scanner.nextInt();
                                        if (ordreNummer == 0) {
                                                seAktiveOrdre = false;
                                                visHovedMenu();
                                        } else {
                                                boolean foundAMatch = false;
                                                for (Bestilling ordre : aktiveOrdrer) {
                                                        if (ordreNummer == ordre.getOrdreNummer()) {
                                                                afsluttedeOrdre.add(ordre);
                                                                aktiveOrdrer.remove(ordre);
                                                                foundAMatch = true;
                                                                break;
                                                        }
                                                }
                                                if (!foundAMatch) {
                                                        System.out.println("Der eksistere ingen ordre med ordrenummer " + ordreNummer);
                                                }
                                        }
                                }
                        }
                }
        }


        private void visAfsluttedeOrdrer() {
                System.out.println("\n--- Afsluttede ordrer ---");
                if (afsluttedeOrdre.isEmpty()) {
                        System.out.println("Ingen afsluttede ordrer.");
                } else {
                        afsluttedeOrdre.sort(Comparator.comparing(Bestilling::getAfhentningstidspunkt));
                        System.out.println(afsluttedeOrdre);
                }
        }
        private void visOmsætning() {
                // Lav et for loop som kører igennem arraylisten af afsluttedeordrer og lægger det sammen
                double omsætning = 0.0;
                for (int i = 0; i < afsluttedeOrdre.size(); i++) {
                     omsætning += afsluttedeOrdre.get(i).getPris();
                }
                System.out.println("Samlet omsætning: " + omsætning + " kr.");
        }
}