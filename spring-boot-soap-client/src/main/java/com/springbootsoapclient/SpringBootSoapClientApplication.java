package com.springbootsoapclient;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.schemas.school.StudentDetailsRequest;
import com.schemas.school.StudentDetailsResponse;

@SpringBootApplication
public class SpringBootSoapClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootSoapClientApplication.class, args);
	}
	
	@Bean
	CommandLineRunner lookup(SOAPConnector soapConnector) {
		return args -> {
			String name = "Sajal";//Default Name
			/*
			 * if(args.length>0){ name = args[0]; }
			 */
			StudentDetailsRequest request = new StudentDetailsRequest();
			request.setName(name);
			StudentDetailsResponse response =(StudentDetailsResponse) soapConnector.callWebService("http://localhost:8080/service/student-details", request);
			System.out.println("Got Response As below ========= : "+response);
			System.out.println("Got Response As below ========= : "+response.getStudent());
			System.out.println("Name : "+response.getStudent().getName());
			System.out.println("Standard : "+response.getStudent().getStandard());
			System.out.println("Address : "+response.getStudent().getAddress());
		};
	}
}
