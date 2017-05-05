package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

//import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
//import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Import;

import com.example.app.Argument;
import com.example.app.ArgumentResolver;
import com.example.app.Calculator;

/*
import com.example.app.Argument;
import com.example.app.ArgumentResolver;
import com.example.app.Calculator;
*/

/**
 * Hello world!
 *
 */
@EnableAutoConfiguration
//@Import(AppConfig.class)
@ComponentScan
public class App implements CommandLineRunner
{
	@Autowired
	ArgumentResolver argumentResolver;
	@Autowired
	Calculator calculator;
	
    public static void main( String[] args )
    {
    	
    	//try (ConfigurableApplicationContext context = SpringApplication.run(App.class, args)) {
    		//System.out.print("Enter 2 numbers like 'a b' : ");
    		/*
    		Scanner scanner = new Scanner(System.in);
    		int a = scanner.nextInt();
    		int b = scanner.nextInt();
    		*/
    		/*
    		ArgumentResolver argumentResolver = context.getBean(ArgumentResolver.class);
    		Argument argument = argumentResolver.resolve(System.in);
    		Calculator calculator = context.getBean(Calculator.class);
    		int reslut = calculator.calc(argument.getA(), argument.getB());
    		System.out.println("result = " + reslut);
    		*/
    		/*
    		Frontend frontend = context.getBean(Frontend.class);
    		frontend.run();
    		*/
    	//}
    	SpringApplication.run(App.class, args);
    }

	@Override
	public void run(String... arg0) throws Exception {
		System.out.print("Enter 2 numbers like 'a b' : ");
		Argument argument = argumentResolver.resolve(System.in);
		int reslut = calculator.calc(argument.getA(), argument.getB());
		System.out.println("result = " + reslut);
	}
}
