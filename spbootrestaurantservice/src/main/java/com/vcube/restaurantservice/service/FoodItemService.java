package com.vcube.restaurantservice.service;

import java.util.List;

import com.vcube.restaurantservice.entity.FoodItem;

public interface FoodItemService {
     
	 FoodItem createFoodItem(FoodItem food);

	 List<FoodItem> getAllFoodItems();

	 FoodItem getFoodItemById(Integer id);
	 
	 List<FoodItem> getAllFoodItems(Integer rstId);

	 FoodItem updateFoodItemById(FoodItem food, Integer id);

	 void deleteFoodItemById(Integer id);
}
