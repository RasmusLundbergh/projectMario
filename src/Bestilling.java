import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Bestilling {

    private List<Pizza> pizzas;
    private LocalDateTime afhentningsTidspunkt;

    public Bestilling(LocalDateTime afhentningsTidspunkt) {
        this.pizzas = new ArrayList<>();
        this.afhentningsTidspunkt = afhentningsTidspunkt;
    }

    public void tilføjPizza (int pizzaNumber,String note) {
        pizzas.add(new Pizza(pizzaNumber, note));
    }
    public LocalDateTime getAfhentningsTidspunkt(){
        return afhentningsTidspunkt;
    }
    public List<Pizza> getPizzas() {
        return pizzas;
    }

    @Override
    public String toString() {
        StringBuilder ordreDetaljer = new StringBuilder();
        ordreDetaljer.append("Afhentningstidspunkt: ").append(afhentningsTidspunkt).append("\n");
        for (Pizza pizza : pizzas) {
            ordreDetaljer.append(pizza).append("\n");
        }
        return ordreDetaljer.toString();
    }
    public static Comparator<Bestilling> AfhentingsTidspunktComparator = new Comparator<Bestilling>() {
        @Override
        public int compare(Bestilling o1, Bestilling o2) {
            return o1.getAfhentningsTidspunkt().compareTo(o2.getAfhentningsTidspunkt());
        }
    };
}