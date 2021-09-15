package code020.supermarket;

public enum  Category {
    FOOD(1),
    COOK(3),
    SNACK(5),
    CLOTHES(7),
    ELECTRIC(9);

    private  int id;
    Category(int id) {
        this.id = id;
    }

    public int getId(){
        return id;
    }
}
