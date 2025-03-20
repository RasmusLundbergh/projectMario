import java.time.LocalDateTime;
import java.util.ArrayList;

public class Bestilling implements Comparable<Bestilling> {  // Implements Comparable
    private LocalDateTime afhentningstid;
    private ArrayList<Pizza> pizzaListe;

    public Bestilling(LocalDateTime afhentningstid) {
        this.afhentningstid = afhentningstid;
        this.pizzaListe = new ArrayList<>();
    }

    public void tilføjPizza(int pizzaNummer, String note) {
        Pizza pizza = new Pizza(pizzaNummer, note);
        pizzaListe.add(pizza);
    }

    public LocalDateTime getAfhentningstid() {
        return afhentningstid;
    }

    @Override
    public int compareTo(Bestilling other) {
        return this.afhentningstid.compareTo(other.afhentningstid);
    }

    @Override
    public String toString() {
        String result = "Afhentningstid: " + afhentningstid + "\nPizzas:\n";

        for (Pizza p : pizzaListe) {
            result += " - " + p + "\n";
        }

        return result;
    }
}


