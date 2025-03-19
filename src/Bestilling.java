import java.util.ArrayList;

public class Bestilling {

    String pizza;
    int afhentningstid;
    ArrayList<Bestilling> bestillingsListe;
    int pris;

    public Bestilling() {
        bestillingsListe = new ArrayList<>();
    }

    public Bestilling (String pizza,int afhentningstid,int pris) {
        this.pizza = pizza;
        this.afhentningstid = afhentningstid;
        this.pris = pris;
    }

    public void tilføjBestilling(Bestilling b) {
        bestillingsListe.add(b);
    }

    public void visBestilling() {
        System.out.println("Bestilling: " + this.pizza + ", Tidspunkt: " + this.afhentningstid +
         ", Pris: " + this.pris + " kr");
    }

    public void visBestillinger() {
        for (int i = 0; i < bestillingsListe.size(); i++) {
            bestillingsListe.get(i).visBestilling();
        }
    }


}
