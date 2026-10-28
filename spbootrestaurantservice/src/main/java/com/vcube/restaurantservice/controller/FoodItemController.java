package com.vcube.restaurantservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.vcube.restaurantservice.entity.FoodItem;
import com.vcube.restaurantservice.service.FoodItemService;

@RestController
@RequestMapping("/fooditems")
public class FoodItemController {

    @Autowired
    FoodItemService foodService;

    // Create Food Item
    @PostMapping("/save")
    public FoodItem createFoodItem(@RequestBody FoodItem food) {
        return foodService.createFoodItem(food);
    }

    // Get All Food Items
    @GetMapping("/findAll")
    public List<FoodItem> getAllFoodItems() {
        return foodService.getAllFoodItems();
    }

    // Get Food Item By ID
    @GetMapping("findFoodItem/{id}")
    public FoodItem getFoodItemById(@PathVariable Integer id) {
        return foodService.getFoodItemById(id);
    }

    // Get All Food Items By Restaurant ID
    @GetMapping("/findAll/{rstId}")
    public List<FoodItem> getAllFoodItemsByRestaurantId(
            @PathVariable Integer rstId) {
        return foodService.getAllFoodItems(rstId);
    }

    // Update Food Item By ID
    @PutMapping("updateFoodItem/{id}")
    public FoodItem updateFoodItemById(
            @RequestBody FoodItem food,
            @PathVariable Integer id) {
        return foodService.updateFoodItemById(food, id);
    }

    // Delete Food Item By ID
    @DeleteMapping("deleteFoodItem/{id}")
    public String deleteFoodItemById(@PathVariable Integer id) {
        foodService.deleteFoodItemById(id);
        return "Food item deleted successfully";
    }
}