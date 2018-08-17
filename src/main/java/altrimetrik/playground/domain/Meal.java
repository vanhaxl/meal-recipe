package altrimetrik.playground.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Meal {

    @Id
    @GeneratedValue
    private Long id;
    private String name;

    @Transient
    private float overallNutrionalValue;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "meal_ingredient", joinColumns = {@JoinColumn(name = "meal_id")},
            inverseJoinColumns = {@JoinColumn(name = "ingredient_id")})
    Set<Ingredient> ingredients = new HashSet<>();

    public Meal() {
    }

    public Meal(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Set<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(Set<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public float getOverallNutrionalValue() {
        return overallNutrionalValue;
    }

    public void setOverallNutrionalValue(float overallNutrionalValue) {
        this.overallNutrionalValue = overallNutrionalValue;
    }

    public void calcOverallNutritionalValue() {
//        float result = 0;
//
//        for (Ingredient ingredient : ingredients) {
//            result += ingredient.getValue();
//        }
//
//        overallNutrionalValue = result;

        overallNutrionalValue = (float) ingredients.stream().mapToDouble(i -> i.getValue()).sum();
    }

}
