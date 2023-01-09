package com.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Customer {
	
	private String name;
	@Id
	private String email;
	private String password;
	private String address;

	@OneToMany(targetEntity = Mobiles.class,cascade = CascadeType.ALL)
	@JoinColumn(name = "refemail",referencedColumnName = "email")
	
	private List<Mobiles> mobiles;
	
}
