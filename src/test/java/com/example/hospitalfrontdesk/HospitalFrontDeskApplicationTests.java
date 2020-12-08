package com.example.hospitalfrontdesk;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HospitalFrontDeskApplicationTests {
	
	public static Logger logger = LoggerFactory.getLogger(HospitalFrontDeskApplicationTests.class);

	@Test
	public void contextLoads() {
		logger.info("Test case executed");
		assertEquals(true, true);
	}

}
