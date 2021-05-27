package com.tsoy.dmitriy.russia.FoodListApp.model;

import lombok.Data;
import javax.persistence.*;

@Entity
@Table(name = "food")
@Data
public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String category;
    private int calories;
    private double protein;
    private double fat;
    private double carbs;
    private String picture;

    public static Builder newBuilder(){
        return new Food().new Builder();
    }

    public class Builder {

        public Builder() {
        }

        public Builder name(String name){
            Food.this.name = name;
            return this;
        }

        public Builder category(String category){
            Food.this.category = category;
            return this;
        }

        public Builder calories(int calories){
            Food.this.calories = calories;
            return this;
        }

        public Builder protein(double protein) {
            Food.this.protein = protein;
            return this;
        }

        public Builder fat(double fat) {
            Food.this.fat = fat;
            return this;
        }

        public Builder carbs(double carbs) {
            Food.this.carbs = carbs;
            return this;
        }

        public Builder picture(String picture) {
            Food.this.picture = picture;
            return this;
        }

        public Food build() {
            return Food.this;
        }
    }
}
