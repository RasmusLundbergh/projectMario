import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        PriorityQueue<Bestilling> ordersQueue = new PriorityQueue<>();  // No need for a Comparator now
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        Scanner scanner = new Scanner(System.in);

        boolean programmetSkalKøre = true;

        while (programmetSkalKøre) {
            System.out.println(" ___________________________________");
            System.out.println("|               MENU                |");
            System.out.println(" ___________________________________");
            System.out.println("|  Press 1 for Pizza overview       |");
            System.out.println("|  Press 2 to create a order        |");
            System.out.println("|  Press 3 to see order overview    |");
            System.out.println("|  Press 4 to see completed orders  |");
            System.out.println("|  Press 5 to see statistics        |");
            System.out.println("|  Press 6 to exit                  |");
            System.out.println(" ___________________________________");

            int brugerValg = scanner.nextInt();

            if (brugerValg == 1) {
                Menu.showmenu();
            }
            else if (brugerValg == 2) {
                scanner.nextLine();

                System.out.println("Indtast afhentningstidspunkt (Format: yyyy-MM-dd HH:mm)");
                String afhentningsTidspunktString = scanner.nextLine();
                LocalDateTime afhentningsTidspunkt = LocalDateTime.parse(afhentningsTidspunktString, formatter);

                Bestilling ordre = new Bestilling(afhentningsTidspunkt);

                boolean tilføjPizzas = true;
                while (tilføjPizzas) {
                    System.out.println("Indtast pizza nummer (fx. 1 for Vesuvio, 2 for Amerikaner)");
                    int pizzaNumber = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Indtast en note for pizzaen (valgfrit)");
                    String note = scanner.nextLine();

                    ordre.tilføjPizza(pizzaNumber, note);

                    System.out.println("Vil du tilføje en pizza til denne ordre? (ja/nej):");
                    String response = scanner.nextLine();
                    if (response.equalsIgnoreCase("nej")) {
                        tilføjPizzas = false;
                    }
                }

                ordersQueue.offer(ordre);
                System.out.println("Ordren er blevet tilføjet.");
            }
            else if (brugerValg == 3) {
                if (ordersQueue.isEmpty()) {
                    System.out.println("Ingen ordre er blevet lavet endnu.");
                } else {
                    System.out.println("Alle ordrer i rækkefølge:\n");
                    PriorityQueue<Bestilling>tempQueue = new PriorityQueue<>(ordersQueue);
                    while (!tempQueue.isEmpty()) {
                        System.out.println(tempQueue.poll());
                    }
                }
            }
            else if (brugerValg == 4) {
                System.out.println("Ikke implementeret endnu");
            }
            else if (brugerValg == 5) {
                System.out.println("Ikke implementeret endnu");
            }
            else if (brugerValg == 6) {
                programmetSkalKøre = false;
            } else {
                System.out.println("Ugyldigt valg, prøv igen");
            }
        }

        System.out.println("Programmet er afsluttet");
        scanner.close();
    }
}
