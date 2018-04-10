package smart.lytn.smartcook.model;

import java.util.List;

/**
 * Created by ivans on 29/01/2018.
 */

class Allergy {

    private int id;
    private String name;

    public Allergy(){}

    public Allergy(int id, String name){
        this.id = id;
        this.name = name;
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

}
