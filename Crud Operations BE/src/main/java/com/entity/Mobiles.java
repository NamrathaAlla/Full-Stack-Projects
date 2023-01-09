package com.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;

import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Mobiles {
    @Id
	@GeneratedValue
	private int mobileid;
   	private String mobilename;
	private String provider;
	private int quantity;
	private int price;
}
