package api.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UserEndPoints;
import api.payloads.User;
import io.restassured.response.Response;

public class UserTests {
	Faker faker;
	User userPayload;
	public Logger logger;
	
	@BeforeClass
	public void setup() {
		faker = new Faker();
		userPayload = new User();
		
		userPayload.setId(faker.idNumber().hashCode());
		userPayload.setUsername(faker.name().username());
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());
		userPayload.setEmail(faker.internet().safeEmailAddress());
		userPayload.setPassword(faker.internet().password(5, 10));
		userPayload.setPhone(faker.phoneNumber().cellPhone());
		
		//logs
		logger = LogManager.getLogger(this.getClass());
		
		logger.debug("**********  Debugging........  ************");
	}


	@Test(priority=1)
	public void testPostUser() {
		
		logger.info("****************** Creating User**********************");
		
		Response response = UserEndPoints.createUser(this.userPayload);
		
		response.then().log().all();
			
		Assert.assertEquals(response.getStatusCode(),200);
		
		logger.info("****************** User is created!r**********************");
	}
	
	@Test(priority=2)
	public void testGetUserByName() {
		
		logger.info("****************** Reading User Info **********************");
		
		Response response = UserEndPoints.getUser(this.userPayload.getUsername());
		
		response.then().log().all();
			
		Assert.assertEquals(response.getStatusCode(),200);
		
		logger.info("****************** User info displayed! **********************");
	}
	
	@Test(priority=3)
	public void testUpdatetUserByUserName() {
		
		logger.info("****************** Updating User **********************");
		
		//update data using payload
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());
		userPayload.setEmail(faker.internet().safeEmailAddress());
		
		Response response = UserEndPoints.updateUser(this.userPayload.getUsername(), userPayload);
		
		response.then().log().body();
			
		Assert.assertEquals(response.getStatusCode(),200);
		
		//checking data after update
		Response responseAfterUpdate = UserEndPoints.getUser(this.userPayload.getUsername());
		responseAfterUpdate.then().log().body();
		Assert.assertEquals(responseAfterUpdate.getStatusCode(), 200);
		
		logger.info("****************** User is updated **********************");
	}
	
	@Test(priority=4)
	public void deletetUserByName() {
		
		logger.info("******************Deleting User**********************");
		
		Response response = UserEndPoints.deleteUser(this.userPayload.getUsername());
		Assert.assertEquals(response.getStatusCode(),200);
		
		logger.info("****************** User is deleted! **********************");
	}
}
