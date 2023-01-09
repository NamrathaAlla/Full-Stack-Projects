package com.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.entity.Customer;
import com.entity.Mobiles;
import com.repository.CustomerRepository;
import com.repository.ProductRepository;
import com.service.OrderRequest;
import com.service.OrderResponse;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class OrderController {

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private OrderService orderService;

	@Autowired
	JdbcTemplate jdbcTemplate;

	@PostMapping("/add-customer")
	public Customer placeOrder(@RequestBody OrderRequest request) {
		return customerRepository.save(request.getCustomer());
	}

	@GetMapping("/customer-list")
	public List<Customer> findAllOrders() {
		return customerRepository.findAll();
	}

//	@GetMapping("/customer/product")
//	public List<OrderResponse> getJoinInformation() {
//		return customerRepository.getJoinInformation();
//	}

	@PostMapping("/customer-mobiles")
	public List joinTable(@RequestBody Customer customer) {
		return orderService.customerData(customer);

	}
//Get By Credentials
	@PostMapping("/customer-mobile")
	public List joinTable1(@RequestBody Customer customer) {
		return orderService.customerData1(customer);

	}
	//Another Way
	@PostMapping("/get")
	public List getData(@RequestBody Customer customer)
	{
		
		String s="select * from customer where email=? and password=?";
		return jdbcTemplate.queryForList(s,customer.getEmail(),customer.getPassword());
	}
	
	//delete by id JPA
	@DeleteMapping("remove-user/{mobileid}")
	public String remove(@PathVariable int mobileid) {
		productRepository.deleteById(mobileid);
		return "Record Deleted Successfully...";
		
	}
	
	//UPDATION
	@PutMapping("update-user")
	public String update(@RequestBody Mobiles mobiles) {
		productRepository.save(mobiles);
		return "Record Updated Successfully";
		
	}
	
	@GetMapping("/getmobiles")
	public List getMobiles()
	{
		String s="select * from mobiles";
		return jdbcTemplate.queryForList(s);
	}
	
	@PutMapping("/update-mobile")
	public Map<String,Object> updateBook(@RequestBody Mobiles mobiles)
	{
		Map<String,Object> res=new HashMap<>();
		String s="update mobiles set mobilename=?,price=?,provider=?,quantity=? where mobileid=?";
		int a=jdbcTemplate.update(s,mobiles.getMobilename(),mobiles.getPrice(),mobiles.getProvider(),mobiles.getQuantity(),mobiles.getMobileid());
		if(a>0)
		{
			res.put("HI", "Updated");
		}
		else
		{
			res.put("HI", "Not Updated");
		}
		return res;
	}
	
}
