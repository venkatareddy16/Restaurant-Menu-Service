package com.vcube.restaurantservice.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vcube.restaurantservice.entity.FoodItem;

@Repository
public interface FoodItemRepo extends JpaRepository<FoodItem,Integer> {
       List<FoodItem> findByRst_Id(Integer rst_id);
}
