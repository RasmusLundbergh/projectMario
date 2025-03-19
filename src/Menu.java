import java.util.ArrayList;
import java.util.List;

public class Menu {
    private List<Pizza> pizzaer;

    public Menu() {
        pizzaer = new ArrayList<>();
        pizzaer.add(new Pizza(1, "Vesuvio", 57, "Tomatsauce, ost, skinke, oregano"));
        pizzaer.add(new Pizza(2, "Amerikaner", 53, "Tomatsauce, ost, oksefars, oregano"));
        pizzaer.add(new Pizza(3, "Cacciatore", 57, "Tomatsauce, ost, pepperoni, oregano"));
        pizzaer.add(new Pizza(4, "Carbona", 63, "Tomatsauce, ost, kødsauce, spaghetti, cocktailpølser, oregano"));
        pizzaer.add(new Pizza(5, "Dennis", 65, "Tomatsauce, ost, skinke, pepperoni, cocktailpølser, oregano"));
        pizzaer.add(new Pizza(6, "Bertil", 57, "Tomatsauce, ost, bacon, oregano"));
        pizzaer.add(new Pizza(7, "Silvia", 61, "Tomatsauce, ost, pepperoni, rød peber, løg, oliven, oregano"));
        pizzaer.add(new Pizza(8, "Victoria", 61, "Tomatsauce, ost, skinke, ananas, champignon, løg, oregano"));
        pizzaer.add(new Pizza(9, "Toronto", 61, "Tomatsauce, ost, skinke, bacon, kebab, chili, oregano"));
        pizzaer.add(new Pizza(10, "Capricciosa", 61, "Tomatsauce, ost, skinke, champignon, oregano"));
        pizzaer.add(new Pizza(11, "Hawaii", 61, "Tomatsauce, ost, skinke, ananas, oregano"));
        pizzaer.add(new Pizza(12, "Le Blissola", 61, "Tomatsauce, ost, skinke, rejer, oregano"));
        pizzaer.add(new Pizza(13, "Venezia", 61, "Tomatsauce, ost, skinke, bacon, oregano"));
        pizzaer.add(new Pizza(14, "Mafia", 61, "Tomatsauce, ost, pepperoni, bacon, løg, oregano"));
        pizzaer.add(new Pizza(15, "Margherita", 56, "Tomatsauce, ost, oregano"));
        pizzaer.add(new Pizza(16, "Kartoffel", 67, "Mascarpone, kartoffel, basil, løg"));
        pizzaer.add(new Pizza(17, "Italiano", 64, "Tomatsauce, ost, peberfrugt, pepperoni, løg"));
        pizzaer.add(new Pizza(18, "Speciale", 70, "Tomatsauce, ost, kylling, ananas, oliven"));
        pizzaer.add(new Pizza(19, "Parken", 62, "Mascarpone, pepperoni, bacon"));
        pizzaer.add(new Pizza(20, "Kebab", 64, "Tomatsauce, ost, kebab, løg"));
        pizzaer.add(new Pizza(21, "Venizio", 65, "Tomatsauce, kylling, bacon, peberfrugt"));
        pizzaer.add(new Pizza(22, "Forte", 67, "Tomatsauce, ost, chili, ham, spinat"));
        pizzaer.add(new Pizza(23, "Carne", 71, "Tomatsauce, ost, pølse, skinke, bacon"));
        pizzaer.add(new Pizza(24, "Picante", 68, "Tomatsauce, ost, kød, artiskokker, chili"));
        pizzaer.add(new Pizza(25, "Amor", 67, "Tomatsauce, ost, skinke, chili, champignon"));
        pizzaer.add(new Pizza(26, "Mario special", 73, "Tomatsauce, ost, kebab, salat, dressing m. agurk"));
        pizzaer.add(new Pizza(27, "Antonelli", 65, "Tomatsauce, ost, skinke, ananas, champignon"));
        pizzaer.add(new Pizza(28, "Nørrebro", 62, "Tomatsauce, ost, kylling, peberfrugt, løg"));
        pizzaer.add(new Pizza(29, "Vegetar", 64, "Tomatsauce, ost, champignon, løg, oliven"));
        pizzaer.add(new Pizza(30, "Filip", 66, "Tomatsauce, ost, pepperoni, skinke, peberfrugt, løg"));
    }

    public void visMenu() {
        System.out.println("---- MENU ----");
        for (Pizza pizza : pizzaer) {
            System.out.println(pizza);
        }
    }

    public Pizza getPizza(int nummer) {
        for (Pizza pizza : pizzaer) {
            if (pizza.getNummer() == nummer) {
                return pizza;
            }
        }
        return null;
    }
}
