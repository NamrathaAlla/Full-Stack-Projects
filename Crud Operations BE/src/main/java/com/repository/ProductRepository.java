package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entity.Mobiles;


@Repository
public interface ProductRepository extends JpaRepository<Mobiles, Integer> {

	void deleteById(int mobileid);

}
