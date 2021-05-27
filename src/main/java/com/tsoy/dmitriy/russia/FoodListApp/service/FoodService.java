package com.tsoy.dmitriy.russia.FoodListApp.service;

import com.tsoy.dmitriy.russia.FoodListApp.model.Food;
import com.tsoy.dmitriy.russia.FoodListApp.repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FoodService {

    @Autowired
    FoodRepository foodRepository;

    public List<Food> getAllFood() {
        return foodRepository.findAll();
    }

    public Optional<Food> getFoodById(long id) {
        return foodRepository.findById(id);
    }

    public void saveFood(List<Food> list) {
        for(Food food : list) {
            Food.newBuilder().
                    name(food.getName()).
                    category(food.getCategory()).
                    calories(food.getCalories()).
                    protein(food.getProtein()).
                    carbs(food.getCarbs()).
                    fat(food.getFat()).
                    picture(food.getPicture()).build();
            foodRepository.save(food);
        }
    }

    public void deleteFood(long id) {
        foodRepository.deleteById(id);
    }
}
