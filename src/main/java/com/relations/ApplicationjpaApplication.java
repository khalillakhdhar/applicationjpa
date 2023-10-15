package com.relations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.relations.model.Employee;
import com.relations.repo.EmployeeRepository;

@SpringBootApplication
public class ApplicationjpaApplication implements CommandLineRunner {

	@Autowired
	EmployeeRepository employeeRepository;
	
	
	public static void main(String[] args) {
		SpringApplication.run(ApplicationjpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Employee employee=new Employee(0, "teste1", "teste1", 4000);
		Employee employee2=new Employee(0, "teste2", "teste2", 800);

		employeeRepository.save(employee);
		employeeRepository.save(employee2);
		employeeRepository.findAll().forEach(em->
		{
			System.out.println(em.toString());
		});
		
		
	}

}
