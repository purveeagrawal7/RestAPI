package com.example.RestAPI;

import java.net.URI;
import java.net.URISyntaxException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import junit.framework.Assert;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RestApiApplicationTests {

	@Test
	public void testUserListSuccess() throws URISyntaxException
	{
	    RestTemplate restTemplate = new RestTemplate();
	     
	    final String baseUrl = "http://localhost:8080/users";
	    URI uri = new URI(baseUrl);
	 
	    ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);
	     
	    //Verify request succeed
	    Assert.assertEquals(200, result.getStatusCodeValue());
	    Assert.assertEquals(true, result.getBody().contains("[{\"id\":1,\"name\":\"Purvee\",\"dob\":\"2019-03-24T03:30:07.741+0000\"},{\"id\":2,\"name\":\"Garima\",\"dob\":\"2019-03-24T03:30:07.741+0000\"},{\"id\":3,\"name\":\"Ishani\",\"dob\":\"2019-03-24T03:30:07.741+0000\"}]"));
	}

}
