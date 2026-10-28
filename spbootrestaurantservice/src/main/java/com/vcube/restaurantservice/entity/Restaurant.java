package com.vcube.restaurantservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity  //->to create the table in db
//if we not provide @Table then it creates the table with class name by default
@Table(name="restaurant")  // -> to assign or modify the name to table 
@Setter
@Getter
public class Restaurant {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Integer id;

	String name;
	
}
