import java.util.ArrayList;

public class Bestilling {
    private static int ordreTæller = 1;
    private int ordreNummer;
    private ArrayList<Pizza> pizzaer;
    private String afhentningstidspunkt;

    public Bestilling(String afhentningstidspunkt) {
        this.ordreNummer = ordreTæller++;
        this.pizzaer = new ArrayList<>();
        this.afhentningstidspunkt = afhentningstidspunkt;
    }

    public void tilføjPizza(Pizza pizza) {
        pizzaer.add(pizza);
    }

    public int getOrdreNummer() {
        return ordreNummer;
    }

    public ArrayList<Pizza> getPizzaer() {
        return pizzaer;
    }

    public String getAfhentningstidspunkt() {
        return afhentningstidspunkt;
    }


    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Ordre #").append(ordreNummer).append("\nAfhentningstidspunkt: ").append(afhentningstidspunkt).append("\nPizzaer:\n");
        for (Pizza pizza : pizzaer) {
            sb.append(" - ").append(pizza.getNummer()).append(". ").append(pizza.getNavn()).append("\n");
        }
        return sb.toString();
    }
}
