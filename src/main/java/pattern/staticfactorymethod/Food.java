package pattern.staticfactorymethod;

public abstract class Food {
    private FoodType name;

    public FoodType getName() {
        return name;
    }
    protected void setName(FoodType name) {
        this.name = name;
    }
}