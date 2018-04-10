package smart.lytn.smartcook.model;

/**
 * Created by ivans on 05/02/2018.
 */

public class Ingredient {

    private int id;
    private String name;
    private Fridge fridge;

    public Ingredient(){}

    public Ingredient(int id, String name, Fridge fridge){
        this.id = id;
        this.name = name;
        this.fridge = fridge;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Fridge getFridge() {
        return fridge;
    }

    public void setFridge(Fridge fridge) {
        this.fridge = fridge;
    }

    @Override
    public String toString() {
        return "Ingredient{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", fridge=" + fridge +
                '}';
    }
}
