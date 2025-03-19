import java.util.ArrayList;

public class Bestilling {

    private String pizza;
    private int afhentningstid;
    private ArrayList<Bestilling> bestillingsListe;

    public Bestilling() {
        bestillingsListe = new ArrayList<>();
    }

    public Bestilling (String pizza,int afhentningstid) {
        this.pizza = pizza;
        this.afhentningstid = afhentningstid;
        bestillingsListe = new ArrayList<>();
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

    public String getPizza() {
        return pizza;
    }

    public void setPizza(String pizza) {
        this.pizza = pizza;
    }

    public int getAfhentningstid() {
        return afhentningstid;
    }

    public void setAfhentningstid(int afhentningstid) {
        this.afhentningstid = afhentningstid;
    }

    public ArrayList<Bestilling> getBestillingsListe() {
        return bestillingsListe;
    }
    public String toString(){
        return "Bestilling: " + this.pizza + "Afhentningstid: " + this.afhentningstid + "Min";
    }
}