package com.osttra.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Product {

	@Id
	String id;

	@Size(min = 7)
	String name;
	
	@Positive
	@Max(value=1000, message= "Maximum price should be 1000 Rs")
	@Min(value = 10, message = "Minimum price should be 10 Rs")
	double price;
	
	@PositiveOrZero
	@NotNull
	Integer quantity;
}
