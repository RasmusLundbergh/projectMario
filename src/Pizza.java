public class Pizza {
    private int nummer;
    private String note;

    public Pizza(int nummer, String note) {
        this.nummer = nummer;
        this.note = note;
    }

    @Override
    public String toString() {
        return "Pizza " + nummer + (note.isEmpty() ? "" : " (Note: " + note + ")");
    }
}

