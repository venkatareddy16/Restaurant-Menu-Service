package com.vcube.restaurantservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vcube.restaurantservice.entity.FoodItem;
// import com.vcube.restaurantservice.entity.Restaurant;
import com.vcube.restaurantservice.repo.FoodItemRepo;

@Service
public class FoodItemImpl implements FoodItemService {

    @Autowired
    FoodItemRepo foodrepo;

    // Create Food Item
    @Override
    public FoodItem createFoodItem(FoodItem food) {
        return foodrepo.save(food);
    }

    // Get All Food Items
    @Override
    public List<FoodItem> getAllFoodItems() {
        return foodrepo.findAll();
    }

    // Get Food Item By ID
    @Override
    public FoodItem getFoodItemById(Integer id) {
        return foodrepo.findById(id).get();
    }

    // Get All Food Items By Restaurant ID
    @Override
    public List<FoodItem> getAllFoodItems(Integer rstId) {
        return foodrepo.findByRst_Id(rstId);
    }

    // Update Food Item By ID
    @Override
    public FoodItem updateFoodItemById(FoodItem food, Integer id) {
        FoodItem f = getFoodItemById(id);

        f.setItem_name(food.getItem_name());
        f.setItem_price(food.getItem_price());
        f.setRst(food.getRst());

        return foodrepo.save(f);
    }

    // Delete Food Item By ID
    @Override
    public void deleteFoodItemById(Integer id) {
        foodrepo.deleteById(id);
    }
}