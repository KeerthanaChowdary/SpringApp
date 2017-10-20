package com.keerthana.codes.topic;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FoodFacilityService {

	@Autowired
	private FoodFacilityRepository foodFacilityRepository;

	public List<FoodFacility> getAllTopics() {
		List<FoodFacility> topics = new ArrayList<>();
		foodFacilityRepository.findAll().forEach(topics::add);
		return topics;
	}

	//API1
	public List<FoodFacility> searchTopic(String name) {
		return foodFacilityRepository.findByapplicantIgnoreCaseContaining(name);
	}

	//API2
	public List<FoodFacility> searchExpired(String status) {
		// TODO Auto-generated method stub
		return foodFacilityRepository.findBystatus(status);
	}

	//API3
	public List<FoodFacility> searchByStreet(String address) {
		// TODO Auto-generated method stub
		return foodFacilityRepository.findByaddressIgnoreCaseContaining(address);
	}

	//API4 - add
	public void addFoodFacility(FoodFacility f) {
		// TODO Auto-generated method stub
		foodFacilityRepository.save(f);
		System.out.println("added " + f);

	}

	//API4 - del
	public void deleteFoodFacility(String id) {
		FoodFacility f1 = foodFacilityRepository.findOneBylocationId(id);
		foodFacilityRepository.delete(f1);
	}

	//API5 - autoExpiry
	public void activateAutoExpiry() throws ParseException {
		//return topicRepository.getexpirationDate();
		String exprDate;
		List<FoodFacility> allFoodFacility = (List<FoodFacility>) foodFacilityRepository.findAll();
		Date today = new Date();
		System.out.println(today);

		// 3/15/2015 12:00:00
		DateFormat b = new SimpleDateFormat("dd/mm/yyyy HH:MM:SS");
		Date checkDate;
		for (FoodFacility ff : allFoodFacility) {
			exprDate = ff.getExpirationDate();

			if (exprDate != null && !exprDate.isEmpty()) {
				//logic to compare date time 
				checkDate = b.parse(exprDate);
				if (today.getTime() > checkDate.getTime()) {
					ff.setStatus("EXPIRED");
					foodFacilityRepository.save(ff);
				}
			}
		}
	}

	//API6 - Predict which truck will be the best one to assign the job given one location
	public FoodFacility getBestTruck(List<Coordinate> a) {
		double max = Double.MAX_VALUE;
		double x, y, xTruck, yTruck, distance;
		FoodFacility bestTruck = null;
		List<FoodFacility> allFoodFacilities = (List<FoodFacility>) foodFacilityRepository.findAll();
		for (FoodFacility f : allFoodFacilities) {
			xTruck = f.getxCoordinate();
			yTruck = f.getyCoordinate();
			distance = 0.0;
			System.out.println(a);
			System.out.println(a.size());
			for (Coordinate c : a) {
				x = c.x;
				y = c.y;
				//distance of this hotel with all the foodtrucks
				distance += Math.sqrt(Math.pow((xTruck - x), 2) + Math.pow((yTruck - y), 2));
			}
			if (distance < max) {
				max = distance;
				bestTruck = f;
			}
		}
		return bestTruck;

	}

	public void addTopic(FoodFacility topic) {
		foodFacilityRepository.save(topic);
	}

	/*public FoodFacility getTopic(String id) {
		return foodFacilityRepository.findOne(id);
	}
	
	
	
	public void updateTopic(FoodFacility topic, String id) {
		foodFacilityRepository.save(topic);
	}*/

}
