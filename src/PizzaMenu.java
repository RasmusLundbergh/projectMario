import java.util.ArrayList;

public class PizzaMenu {
    private ArrayList<Pizza> pizzaer = new ArrayList<>();

    public PizzaMenu() {
        opretPizzaer();
    }

    private void opretPizzaer() {
        pizzaer.add(new Pizza(1, "Vesuvio", 57.0, "tomatsauce, ost, skinke og oregano"));
        pizzaer.add(new Pizza(2, "Amerikaner", 53.0, "tomatsauce, ost, oksefars og oregano"));
        pizzaer.add(new Pizza(3, "Cacciatore", 57.0, "tomatsauce, ost, pepperoni og oregano"));
        pizzaer.add(new Pizza(4, "Carbona", 63.0, "tomatsauce, ost, kødsauce, spaghetti, cocktailpølser og oregano"));
        pizzaer.add(new Pizza(5, "Dennis", 65.0, "tomatsauce, ost, skinke, pepperoni, cocktailpølser og oregano"));
        pizzaer.add(new Pizza(6, "Bertil", 57.0, "tomatsauce, ost, bacon og oregano"));
        pizzaer.add(new Pizza(7, "Silvia", 61.0, "tomatsauce, ost, pepperoni, rød peber, løg, oliven og oregano"));
        pizzaer.add(new Pizza(8, "Victoria", 61.0, "tomatsauce, ost, skinke, ananas, champignon, løg og oregano"));
        pizzaer.add(new Pizza(9, "Toronto", 61.0, "tomatsauce, ost, skinke, bacon, kebab, chili og oregano"));
        pizzaer.add(new Pizza(10, "Capricciosa", 61.0, "tomatsauce, ost, skinke, champignon og oregano"));

    }

    public void visMenu() {
        System.out.println("--- MENUKORT ---");
        for (Pizza pizza : pizzaer) {
            System.out.println(pizza);
        }
    }

    public ArrayList<Pizza> getPizzaer() {
        return pizzaer;
    }
}
