import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Bestilling implements Comparable<Bestilling> {
    private static int ordreTæller = 1;
    private int ordreNummer;
    private ArrayList<Pizza> pizzaer;
    private Date afhentningstidspunkt;

    public Bestilling(Date afhentningstidspunkt) {
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

    public Date getAfhentningstidspunkt() {
        return afhentningstidspunkt;
    }


    public String toString() {
        StringBuilder sb = new StringBuilder();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        String formattedTime = sdf.format(afhentningstidspunkt);
        sb.append("Ordre #").append(ordreNummer).append("\nAfhentningstidspunkt: ").append(formattedTime).append("\nPizzaer:\n");
        for (Pizza pizza : pizzaer) {
            sb.append(" - ").append(pizza.getNummer()).append(". ").append(pizza.getNavn()).append("\n");
        }
        return sb.toString();
    }

    public double getPris() {
        double totalPris = 0.0;
        for (Pizza pizza : pizzaer) {
            totalPris += pizza.getPris();
        }
        return totalPris;
    }

    @Override
    public int compareTo(Bestilling o) {
        return getAfhentningstidspunkt().compareTo(o.getAfhentningstidspunkt());
    }
}