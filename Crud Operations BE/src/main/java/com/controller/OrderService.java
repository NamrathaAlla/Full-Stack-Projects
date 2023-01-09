package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.entity.Customer;

@Service
public class OrderService {

	@Autowired
	JdbcTemplate jdbcTemplate;

	// JOIN
	public List customerData(Customer customer) {
		String email = customer.getEmail();
		String password = customer.getPassword();

		List result = null;

		if (!customer.getPassword().isEmpty() && customer.getPassword() != null && !"".equals(customer.getEmail())) {

			String query = "SELECT customer.name, customer.email,mobiles.mobileid,mobiles.mobilename,mobiles.provider,mobiles.quantity,mobiles.price "
					+ "FROM customer,mobiles where customer.email=? and customer.password=? ";

			result = jdbcTemplate.queryForList(query, email, password);
		}

		return result;
	}

	public List customerData1(Customer customer) {
		String email = customer.getEmail();
		String password = customer.getPassword();

		List result = null;

		if (!customer.getPassword().isEmpty() && customer.getPassword() != null && !"".equals(customer.getEmail())) {
			String query = "SELECT customer.name, customer.email,mobiles.mobileid,mobiles.mobilename,mobiles.provider,mobiles.quantity,mobiles.price,mobiles.refemail "
					+ "FROM customer,mobiles where customer.email = ? and mobiles.refemail=?";

			result = jdbcTemplate.queryForList(query, email, email);
		}

		return result;
	}

	// DELETION
	public String removeUser(int mobileid) {
		String sql = "Delete from relation.mobiles where mobileid =?";
		int result = jdbcTemplate.update(sql, mobileid);
		if (result == 1) {
			return "Record Deleted Successfully";
		} else {
			return "Something Went Wrong";

		}

	}

}
