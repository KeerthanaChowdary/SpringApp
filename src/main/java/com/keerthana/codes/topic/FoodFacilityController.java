package com.keerthana.codes.topic;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FoodFacilityController {

	@Autowired
	private FoodFacilityService topicService;

	/*@RequestMapping("/topics")
	public List<FoodFacility> getAllTopics() {
		return topicService.getAllTopics();
	}*/

	//API1 - search by applicant name
	@RequestMapping("/searchapplicant/{applicant}")
	public List<FoodFacility> getTopic(@PathVariable("applicant") String applicant) {
		return topicService.searchTopic(applicant);
	}
	//API2 - search by expiration

	@RequestMapping("/expiration/{status}")
	public List<FoodFacility> getExpired(@PathVariable("status") String status) {
		return topicService.searchExpired(status);
	}
	//API3 - search by Street 

	@RequestMapping("/searchByStreet/{address}")
	public List<FoodFacility> getAddress(@PathVariable("address") String address) {
		return topicService.searchByStreet(address);
	}
	//API4 - add a row 

	@RequestMapping(value = "/addFoodFacility", method = RequestMethod.POST)
	public void addFoodFacility(@RequestBody FoodFacility ff) {
		topicService.addFoodFacility(ff);
	}

	//API4 - del a row 
	@RequestMapping(value = "/delFoodFacility/{locationId}", method = RequestMethod.DELETE)
	public void delFoodFacility(@PathVariable("locationId") String id) {
		topicService.deleteFoodFacility(id);
	}

	//API5 - auto expiry of licenses
	@RequestMapping(value = "/autoExpiry")
	public void autoExpiry() throws ParseException {
		topicService.activateAutoExpiry();
	}

	//API6 - given one location
	@RequestMapping(value = "/getBestTruck", method = RequestMethod.POST)
	public FoodFacility getBestTruck(@RequestBody List<Coordinate> c) {
		return topicService.getBestTruck(c);
	}

	@RequestMapping(value = "/addTheDataSet", method = RequestMethod.POST)
	public void addFacilities() throws IOException {

		BufferedReader TSVFile = new BufferedReader(new FileReader("mobilefooddatabase.tsv"));

		TSVFile.readLine();
		String dataRow = TSVFile.readLine();
		while (dataRow != null) {
			String[] dataArray = dataRow.split("\t");
			//FoodFacility(String id, String name, String status, String address)
			FoodFacility temp;
			if (dataArray[12].isEmpty() || dataArray[13].isEmpty()) {
				temp = new FoodFacility(dataArray[0], dataArray[1], dataArray[10], dataArray[5], dataArray[22]);
			} else {
				temp = new FoodFacility(dataArray[0], dataArray[1], dataArray[10], dataArray[5], dataArray[22], dataArray[12], dataArray[13]);
				//FoodFacility topic = null;
			}
			topicService.addTopic(temp);

			dataRow = TSVFile.readLine();
		}

		TSVFile.close();
	}

}
