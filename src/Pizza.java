public class Pizza {
    private int nummer;
    private String navn;
    private double pris;
    private String ingredienser; // Ny variabel til at gemme ingredienser

    public Pizza(int nummer, String navn, double pris, String ingredienser) {
        this.nummer = nummer;
        this.navn = navn;
        this.pris = pris;
        this.ingredienser = ingredienser;
    }

    public int getNummer() {
        return nummer;
    }

    public String getNavn() {
        return navn;
    }

    public double getPris() {
        return pris;
    }

    public String getIngredienser() {
        return ingredienser;
    }

    @Override
    public String toString() {
        return nummer + ". " + navn + " - " + pris + " kr.\n   Ingredienser: " + ingredienser;
    }
}
