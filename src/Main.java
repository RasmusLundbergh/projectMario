import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Bestilling nyBestillingsListe = new Bestilling();
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

            // Bruger valg 1
            if (brugerValg == 1) {
                Menu.showmenu();
            }
            // Bruger valg 2
            else if (brugerValg == 2) {

                scanner.nextLine();

                System.out.println("Indtast bestilling");
                String inputBestilling = scanner.nextLine();

                System.out.println("Indtast afhentningstid");
                int inputAfhentningstidspunkt = scanner.nextInt();

                Bestilling ordre = new Bestilling(inputBestilling, inputAfhentningstidspunkt);
                nyBestillingsListe.tilføjBestilling(ordre);

            }
            // Bruger valg 3
            else if (brugerValg == 3) {
                nyBestillingsListe.visBestillinger();
            }
            // Bruger valg 4
            else if (brugerValg == 4) {
                System.out.println("Ikke implementeret endnu");
            }
            // Bruger valg 5
            else if (brugerValg == 5) {
                System.out.println("Ikke implementeret endnu");
            }
            //Bruger valg 6
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