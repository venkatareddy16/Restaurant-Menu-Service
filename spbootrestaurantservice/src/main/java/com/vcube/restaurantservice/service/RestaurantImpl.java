package com.vcube.restaurantservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vcube.restaurantservice.entity.Restaurant;
import com.vcube.restaurantservice.repo.RestaurantRepo;

@Service
public class RestaurantImpl implements RestaurantService {

	@Autowired
	RestaurantRepo rstrepo;
	
	@Override
	public Restaurant createRestaurant(Restaurant rst) {
		return rstrepo.save(rst);
	}

	@Override
	public List<Restaurant> getAllRestaurants() {
		return rstrepo.findAll();
	}

	@Override
	public Restaurant getRestaurantById(Integer id) {
		return rstrepo.findById(id).get();
	}

	@Override
	public Restaurant updateRestaurantById(Restaurant rst, Integer id) {
		Restaurant rs=getRestaurantById(id);
		rs.setName(rst.getName());
		return rstrepo.save(rs);
	}

	@Override
	public void deleteRestaurantById(Integer id) {
		rstrepo.deleteById(id);
	}

}
