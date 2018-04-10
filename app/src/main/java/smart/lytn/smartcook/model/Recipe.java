package smart.lytn.smartcook.model;

import java.util.List;

/**
 * Created by ivans on 29/01/2018.
 */

public class Recipe {

    private int id;
    private String name;
    private List<Ingredient> ingredients;
    private float coockingTime;
    private String preparation;
    private Difficulty difficulty;
    private String utensils;

    public Recipe(){}

    public Recipe(int id, String name, List<Ingredient> ingredients, float coockingTime, String preparation,
                  Difficulty difficulty, String utensils){
        this.id = id;
        this.name = name;
        this.ingredients = ingredients;
        this.coockingTime = coockingTime;
        this.preparation = preparation;
        this.difficulty = difficulty;
        this.utensils = utensils;
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

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public float getCoockingTime() {
        return coockingTime;
    }

    public void setCoockingTime(float coockingTime) {
        this.coockingTime = coockingTime;
    }

    public String getPreparation() {
        return preparation;
    }

    public void setPreparation(String preparation) {
        this.preparation = preparation;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    public String getUtensils() {
        return utensils;
    }

    public void setUtensils(String utensils) {
        this.utensils = utensils;
    }
}
