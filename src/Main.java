import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Bestilling ordre1 = new Bestilling("2x nr.3 + 1 x nr.17", 15);

        Bestilling nyBestillingsListe = new Bestilling();

        nyBestillingsListe.tilføjBestilling(ordre1);

        nyBestillingsListe.visBestillinger();



    }
}
