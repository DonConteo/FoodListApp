package com.tsoy.dmitriy.russia.FoodListApp.controller;

import com.tsoy.dmitriy.russia.FoodListApp.model.Food;
import com.tsoy.dmitriy.russia.FoodListApp.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("food")
public class FoodController {

    @Autowired
    FoodService foodService;

    @GetMapping()
    public ResponseEntity<List<Food>> getAllFood() {
        List<Food> users = foodService.getAllFood();
        return users.isEmpty()
                ? new ResponseEntity<>(HttpStatus.NOT_FOUND)
                : new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("id")
    public ResponseEntity<Optional<Food>> getFoodById(@PathVariable("id") long id) {
        Optional<Food> food = foodService.getFoodById(id);
        return food.isPresent()
                ? new ResponseEntity<>(food, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping()
    public ResponseEntity<String> saveFood(@RequestBody List<Food> list) {
        foodService.saveFood(list);
        return new ResponseEntity<>("Food successfully added", HttpStatus.CREATED);
//                : new ResponseEntity<>(HttpStatus.SERVICE_UNAVAILABLE);
    }

    @DeleteMapping("id")
    public ResponseEntity<String> deleteFood(@PathVariable("id") long id) {
        if (foodService.getFoodById(id).isEmpty()) {
            return new ResponseEntity<>("There is no food with presented id", HttpStatus.NOT_FOUND);
        }
        foodService.deleteFood(id);
        Optional<Food> food = foodService.getFoodById(id);
        return food.isEmpty()
                ? new ResponseEntity<>("Food successfully deleted", HttpStatus.OK)
                : new ResponseEntity<>("We have some trouble with deleting this food", HttpStatus.SERVICE_UNAVAILABLE);
    }
}
