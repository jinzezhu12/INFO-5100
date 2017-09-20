
public class Pizza {

    private double size;
    private String type;

    public Pizza() {
        this.size = 12;
        this.type = "chicken";
    }

    public Pizza(double size, String type) {
        this.size = size;
        this.type = type;
    }

    public double getSize() {
        return size;
    }

    public String getType() {
        return type;
    }

    public void print() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.size);
        stringBuilder.append(this.type);

        System.out.println(stringBuilder.toString());
    }
}
