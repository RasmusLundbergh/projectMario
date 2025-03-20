public class Pizza {
    private int pizzaNumber;  // Pizza nummer
    private String note;      // Note for pizzaen

    // Konstruktor til pizza
    public Pizza(int pizzaNumber, String note) {
        this.pizzaNumber = pizzaNumber;
        this.note = note;
    }

    public int getPizzaNumber() {
        return pizzaNumber;
    }

    public String getNote() {
        return note;
    }

    @Override
    public String toString() {
        return "Pizza Nr: " + pizzaNumber + ", Note: " + note;
    }
}
