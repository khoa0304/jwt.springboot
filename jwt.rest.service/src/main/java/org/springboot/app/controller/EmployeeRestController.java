package org.springboot.app.controller;

import java.util.ArrayList;
import java.util.List;

import org.springboot.app.model.Employee;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class EmployeeRestController {
	
	List<Employee> l = new ArrayList<>();
	
	
	@RequestMapping(path="/employees", method=RequestMethod.GET)
	public List<Employee> getAllEmployees(){
		
		
		for(int i = 1; i<=10 ; i++) {
			Employee employee = new Employee(String.valueOf(i), String.valueOf(i), String.valueOf(i), String.valueOf(i), i %2 == 0 ? false:true);	
			l.add(employee);
		}
		 
		return l;
	}
    @RequestMapping(value = "/employee/{id}", method = RequestMethod.GET)
	public Employee getEmployeeById(@PathVariable("id") int id){
		return l.get(id);
	}

}