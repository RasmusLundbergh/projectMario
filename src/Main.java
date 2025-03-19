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
            System.out.println("Menu:");
            System.out.println("1: Vis menu ");
            System.out.println("2: Opret ordre/bestilling ");
            System.out.println("3: Vis ordreoversigt/bestillingsliste ");
            System.out.println("4:... ");
            System.out.println("5:...");
            System.out.println("6: Afslut programmet");
            System.out.println("Vælg funktion:");

            int brugerValg = scanner.nextInt();

            if (brugerValg == 2) {

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