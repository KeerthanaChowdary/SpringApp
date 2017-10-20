package com.keerthana.codes.topic;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
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

	@RequestMapping("/topics")
	public List<FoodFacility> getAllTopics() {
		return topicService.getAllTopics();
	}
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
		
		@RequestMapping(value = "/addFoodFacility/", method = RequestMethod.POST)
		public void addFoodFacility(@RequestBody FoodFacility ff) {
			 topicService.addFoodFacility(ff);
					}
		//API4 - del a row 
		@RequestMapping(value = "/delFoodFacility/{locationId}", method = RequestMethod.DELETE)
		public void deleteTopic(@PathVariable("locationId") String id) {
			topicService.deleteFoodFacility(id);
		}
	@RequestMapping(value = "/topics", method = RequestMethod.POST)
	public void addTopic(@RequestBody FoodFacility topic) {
		topicService.addTopic(topic);
	}
	
	@RequestMapping(value = "/facilities", method = RequestMethod.POST)
	public void addFacilities() throws IOException {
		
		BufferedReader TSVFile = new BufferedReader(new FileReader("/home/abzooba/Desktop/myGate/mobilefooddatabase.tsv"));
		String dataRow = TSVFile.readLine();
		while(dataRow != null){
			String[] dataArray = dataRow.split("\t");
		//FoodFacility(String id, String name, String status, String address)
			FoodFacility temp = new FoodFacility(dataArray[0], dataArray[1], dataArray[10], dataArray[5]);
		//FoodFacility topic = null;
		
			topicService.addTopic(temp);
		
		dataRow = TSVFile.readLine(); 
		}

      TSVFile.close();
	}

	@RequestMapping(value = "/topics/{id}", method = RequestMethod.PUT)
	public void updateTopic(@RequestBody FoodFacility topic, @PathVariable("id") String id) {
		topicService.updateTopic(topic, id);
	}

	
}
