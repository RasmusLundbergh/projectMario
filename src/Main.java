import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Bestilling nyBestillingsListe = new Bestilling();

        boolean programmetSkalKøre = true;

        while (programmetSkalKøre) {
            Scanner scanner = new Scanner(System.in);
            System.out.println(" ___________________________________");
            System.out.println("|               MENU                |");
            System.out.println(" ___________________________________");
            System.out.println("|  Press 1 for Pizza overview       |");
            System.out.println("|  Press 2 to create a order        |");
            System.out.println("|  Press 3 to see order overview    |");
            System.out.println("|  Press 4 to see completed orders  |");
            System.out.println("|  Press 5 to see statistics        |");
            System.out.println(" ___________________________________");

            int brugerValg = scanner.nextInt();
            if (brugerValg == 1){
                Menu.showmenu();
            }
            else if (brugerValg == 2) {

                scanner.nextLine();

                System.out.println("Indtast bestilling");
                String inputBestilling = scanner.nextLine();

                System.out.println("Indtast afhentningstid");
                int inputAfhentningstidspunkt = scanner.nextInt();

                Bestilling ordre = new Bestilling(inputBestilling, inputAfhentningstidspunkt);

                nyBestillingsListe.tilføjBestilling(ordre);

            }

            else if (brugerValg == 3) {
                nyBestillingsListe.visBestillinger();
            }

            else if (brugerValg == 6) {
                programmetSkalKøre = false;
            }
        }
        System.out.println("Programmet er afsluttet");
    }
}