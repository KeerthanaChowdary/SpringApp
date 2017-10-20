package com.keerthana.codes.topic;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FoodFacilityService {

	@Autowired
	private FoodFacilityRepository topicRepository;
	
	public List<FoodFacility> getAllTopics()
	{
		List<FoodFacility> topics=new ArrayList<>();
		topicRepository.findAll()
		.forEach(topics::add);
		return topics;
	}
   //API1
	public List<FoodFacility> searchTopic(String name) {
		return topicRepository.findByapplicantIgnoreCaseContaining(name);
	}
	//API2
	public List<FoodFacility> searchExpired(String status) {
		// TODO Auto-generated method stub
		return topicRepository.findBystatus(status);
	}
	//API3
	public List<FoodFacility> searchByStreet(String address) {
		// TODO Auto-generated method stub
		return topicRepository.findByaddressIgnoreCaseContaining(address);
	}
	//API4 - add
	public void addFoodFacility(FoodFacility f) {
		// TODO Auto-generated method stub
		topicRepository.save(f);
		System.out.println("added "+ f);
		
	}
	//API4 - del
	public void deleteFoodFacility(String id) {
		FoodFacility f1 = topicRepository.findOneBylocationId(id);
		topicRepository.delete(f1);
	}
	
	public FoodFacility getTopic(String id) {
		return topicRepository.findOne(id);
	}
	
	public void addTopic(FoodFacility topic) {
		topicRepository.save(topic);
	}

	public void updateTopic(FoodFacility topic,String id) {
		topicRepository.save(topic);
	}

	
	

	
	
}
