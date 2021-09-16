package spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import spring.service.EmployeeService;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
}
