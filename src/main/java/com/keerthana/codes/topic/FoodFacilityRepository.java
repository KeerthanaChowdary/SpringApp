package com.keerthana.codes.topic;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface FoodFacilityRepository extends CrudRepository<FoodFacility,String> {

	List<FoodFacility> findByapplicantIgnoreCaseContaining(String name);

	List<FoodFacility> findBystatus(String status);

	List<FoodFacility> findByaddressIgnoreCaseContaining(String address);

	void deleteBylocationId(String id);

	FoodFacility findOneBylocationId(String id);

	
}
