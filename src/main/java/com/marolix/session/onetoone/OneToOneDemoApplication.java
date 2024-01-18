package com.marolix.session.onetoone;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

import com.marolix.session.onetoone.controller.EmployeeController;

@SpringBootApplication
@PropertySource(value = {  "messages.properties" })
public class OneToOneDemoApplication {
	

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(OneToOneDemoApplication.class, args);
	
		
	}

}
//EmployeeController c = context.getBean(EmployeeController.class);
// c.addEmployee();
// c.updatePassportDetails();
// c.deletePassportDetails();
// c.deleteEmployeeDetails();
// c.addAddress();
// c.sortBYColumn();
//c.doPaging();

//c.viewEmployees();