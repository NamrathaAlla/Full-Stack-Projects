package com.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class OrderResponse {

	private String username;
	private String mobilename;
	private String provider;
	private int mobileid;
	private int price;
	private int quantity;
	
	

}
