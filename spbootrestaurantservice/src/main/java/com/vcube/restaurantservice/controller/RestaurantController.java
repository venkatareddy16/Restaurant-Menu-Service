package com.vcube.restaurantservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.vcube.restaurantservice.entity.Restaurant;
import com.vcube.restaurantservice.service.RestaurantService;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {

    @Autowired
    RestaurantService restaurantService;

    // Create Restaurant
    @PostMapping("/save")
    public Restaurant createRestaurant(@RequestBody Restaurant rst) {
        return restaurantService.createRestaurant(rst);
    }

    // Get All Restaurants
    @GetMapping("/findAll")
    public List<Restaurant> getAllRestaurants() {
        return restaurantService.getAllRestaurants();
    }

    // Get Restaurant By ID
    @GetMapping("findRestaurant/{id}")
    public Restaurant getRestaurantById(@PathVariable Integer id) {
        return restaurantService.getRestaurantById(id);
    }

    // Update Restaurant By ID
    @PutMapping("updateRestaurant/{id}")
    public Restaurant updateRestaurantById(@RequestBody Restaurant rst,@PathVariable Integer id) {
        return restaurantService.updateRestaurantById(rst, id);
    }

    // Delete Restaurant By ID
    @DeleteMapping("deleteRestaurant/{id}")
    public String deleteRestaurantById(@PathVariable Integer id) {
        restaurantService.deleteRestaurantById(id);
        return "Restaurant deleted successfully";
    }
}