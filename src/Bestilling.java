import java.util.ArrayList;

public class Bestilling {

    String pizza;
    int afhentningstid;
    ArrayList<Bestilling> bestillingsListe;

    public Bestilling() {
        bestillingsListe = new ArrayList<>();
    }

    public Bestilling (String pizza,int afhentningstid) {
        this.pizza = pizza;
        this.afhentningstid = afhentningstid;
    }

    public void tilføjBestilling(Bestilling b) {
        bestillingsListe.add(b);
    }

    public void visBestilling() {
        System.out.println("Bestilling: " + this.pizza + ", Afhentningstid: " + this.afhentningstid + " min");
    }

    public void visBestillinger() {
        for (int i = 0; i < bestillingsListe.size(); i++) {
            bestillingsListe.get(i).visBestilling();
        }
    }


}