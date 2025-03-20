import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Bestilling {

    private int pizza;
    private double afhentningstid;
    private int size;
    ArrayList<Bestilling> bestillingsListe;

    public Bestilling() {
        bestillingsListe = new ArrayList<>();
            }



        public void sorter() {
            //Collections.sort(bestillingsListe, new Comparator<Bestilling>());
                //public int compare (Bestilling b1), (Bestilling b2) {
            //return Integer.compare(b1.get, afhentningstid());
            //    }

        }
    public void sorterBestillinger() {
        Collections.sort(bestillingsListe, (b1, b2) -> Double.compare(b1.getAfhentningstid(), b2.getAfhentningstid()));
    }

    public Bestilling (int size, int pizza, double afhentningstid) {
        this.pizza = pizza;
        this.afhentningstid = afhentningstid;
        this.size = size;
    }

    public int getpizza() {
        return pizza;
    }
    public double getAfhentningstid() {
        return afhentningstid;
    }

    public void tilføjBestilling(Bestilling b) {
        bestillingsListe.add(b);
    }

    public void visBestilling() {
        System.out.println("bestilling: " + this.size + "x nr. " + this.pizza + ". Afhentningstid: " + this.afhentningstid);
    }

    public void visBestillinger() {
        for (int i = 0; i < bestillingsListe.size(); i++) {
            bestillingsListe.get(i).visBestilling();
        }
    }



}