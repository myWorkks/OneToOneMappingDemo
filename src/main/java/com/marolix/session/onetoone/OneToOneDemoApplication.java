package com.marolix.session.onetoone;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.marolix.session.onetoone.controller.EmployeeController;

@SpringBootApplication
public class OneToOneDemoApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(OneToOneDemoApplication.class, args);

		EmployeeController c = context.getBean(EmployeeController.class);
		// c.addEmployee();
		// c.updatePassportDetails();
		// c.deletePassportDetails();
		// c.deleteEmployeeDetails();
		 c.addAddress();
	}

}
