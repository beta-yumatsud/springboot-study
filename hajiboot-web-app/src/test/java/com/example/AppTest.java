package com.example;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.domain.Customer;
import com.example.repository.CustomerRepository;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
	properties = {"spring.datasource.url:jdbc:h2:mem:customers;DB_CLOSE_ON_EXIT=FALSE"})
public class AppTest {
	@Autowired
	CustomerRepository customerRepository;
	@LocalServerPort
	int port;
	
	Customer customer1;
	Customer customer2;
	
	@Before
	public void setUp() {
		customerRepository.deleteAll();
		customer1 = new Customer();
        customer1.setFirstname("Taro");
        customer1.setLastname("Yamada");
        customer2 = new Customer();
        customer2.setFirstname("Ichiro");
        customer2.setLastname("Suzuki");
        
        customerRepository.save(Arrays.asList(customer1, customer2));
        RestAssured.port = port;
	}
	
	@Test
	public void testGetCustomers() throws Exception {
		/*
		when().get("/api/customers")
        .then()
        .statusCode(HttpStatus.OK.value())
        .body("numberOfElements", is(2))
        .body("content[0].id", is(customer2.getId()))
        .body("content[0].firstName", is(customer2.getFirstname()))
        .body("content[0].lastName", is(customer2.getLastname()))
        .body("content[1].id", is(customer1.getId()))
        .body("content[1].firstName", is(customer1.getFirstname()))
        .body("content[1].lastName", is(customer1.getLastname()));
        */
	}
	
	@Test
    public void testPostCustomers() throws Exception {
		/*
        Customer customer3 = new Customer();
        customer3.setFirstname("Nobita");
        customer3.setLastname("Nobi");

        given().body(customer3)
                .contentType(ContentType.JSON)
                .and()
                .when().post("/api/customers")
                .then()
                .statusCode(HttpStatus.CREATED.value())
                .body("id", is(notNullValue()))
                .body("firstName", is(customer3.getFirstname()))
                .body("lastName", is(customer3.getLastname()));

        when().get("/api/customers")
                .then()
                .statusCode(HttpStatus.OK.value())
                .body("numberOfElements", is(3));
                */
    }

    @Test
    public void testDeleteCustomers() throws Exception {
    	/*
        when().delete("/api/customers/{id}", customer1.getId())
                .then()
                .statusCode(HttpStatus.NO_CONTENT.value());

        when().get("/api/customers")
                .then()
                .statusCode(HttpStatus.OK.value())
                .body("numberOfElements", is(1));
                */
    }
}
