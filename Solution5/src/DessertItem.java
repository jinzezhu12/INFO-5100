public abstract class DessertItem {
    private String name;

    public DessertItem(){
        this("");
    }

    public DessertItem(String name){
        this.name = name;
    }

    public final String getName(){
        return this.name;
    }

    public abstract int getCost();


}
