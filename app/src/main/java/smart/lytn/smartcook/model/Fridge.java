package smart.lytn.smartcook.model;

import java.util.List;

/**
 * Created by ivans on 29/01/2018.
 */

public class Fridge {

    private int id;
    private String name;
    private List<Ingredient> food;

    public Fridge(){}

    public Fridge(int id, String name, List<Ingredient> food){
        this.id = id;
        this.name = name;
        this.food = food;
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

    public List<Ingredient> getFood() {
        return food;
    }

    public void setFood(List<Ingredient> food) {
        this.food = food;
    }
}
