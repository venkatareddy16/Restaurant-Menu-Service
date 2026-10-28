package com.vcube.restaurantservice.service;

import java.util.List;

import com.vcube.restaurantservice.entity.Restaurant;

public interface RestaurantService {
    
	Restaurant createRestaurant(Restaurant rst);
	
	List<Restaurant> getAllRestaurants();
	
	Restaurant getRestaurantById(Integer id);
	
	Restaurant updateRestaurantById(Restaurant rst,Integer id);
	
	void deleteRestaurantById(Integer id);
	
}
