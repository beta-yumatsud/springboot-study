package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
//import org.springframework.data.domain.Sort;
//import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
//import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import com.example.domain.Customer;
import com.example.repository.CustomerRepository;
import com.example.service.CustomerService;

@EnableAutoConfiguration
@ComponentScan
public class App implements CommandLineRunner
{
	@Autowired
	CustomerService customerService;
	@Autowired
	NamedParameterJdbcTemplate jdbcTemplate;
	@Autowired
	CustomerRepository customerRepository;
	
    public static void main( String[] args )
    {
    	SpringApplication.run(App.class, args);
    }

	public void run(String... arg0) throws Exception {
		this.showCustomDataUsingService();
		this.showCustomDataUsingDB();
	}
	
	private void showCustomDataUsingDB() {
		Customer created = customerRepository.save(new Customer(null, "Hidetoshi", "Dekisugi"));
		System.out.println(created + " is created!!");
		//customerRepository.findAll().forEach(System.out::println);
		Pageable pageable = new PageRequest(0, 3);
		Page<Customer> page = customerRepository.findAll(pageable);
		System.out.println("1ページあたりのデータ数=" + page.getSize());
		System.out.println("現在のページ=" + page.getNumber());
		System.out.println("全ページ数=" + page.getTotalPages());
		System.out.println("全データ数=" + page.getTotalElements());
		page.getContent().forEach(System.out::println);
		//customerRepository.findAllOrderByName().forEach(System.out::println);
		Page<Customer> page2 = customerRepository.findAllOrderByName(pageable);
		page2.getContent().forEach(System.out::println);
		/*
		String sql = "SELECT id, first_name, last_name FROM customers WHERE id = :id";
		SqlParameterSource param = new MapSqlParameterSource().addValue("id", 1);
		Customer result = jdbcTemplate.queryForObject(sql, param,
				(rs, rownum) -> new Customer(rs.getInt("id"), rs.getString("first_name"), rs.getString("last_name"))
		);
		System.out.println("result = " + result);
		*/
	}
	
	private void showCustomDataUsingService() {
		// データ追加
		/*
		customerService.save(new Customer(1, "Nobita", "Nobi"));
		customerService.save(new Customer(2, "Takeshi", "Goda"));
		customerService.save(new Customer(3, "Suneo", "Honekawa"));
		*/
		// データ表示
		//customerService.findAll().forEach(System.out::println);
	}
}
