package spring.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import spring.model.Employee;
import spring.model.dto.CreateEmployeeDTO;
import spring.model.dto.UpdateEmployeeDTO;
import spring.service.EmployeeService;

@Controller
@RequestMapping("/api/employees")
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;

	@GetMapping
	public ResponseEntity<List<Employee>> getAllEmployees() {
		return new ResponseEntity<List<Employee>>(employeeService.findAll(),
				HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Long id) {
		return new ResponseEntity<Employee>(employeeService.findById(id), HttpStatus.OK);
	}

	@PostMapping()
	public ResponseEntity<Employee> createEmployee(
			@RequestBody @Valid CreateEmployeeDTO formData) {
		return new ResponseEntity<Employee>(employeeService.create(formData),
				HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable("id") Long id,
			@RequestBody @Valid UpdateEmployeeDTO formData) {
		return new ResponseEntity<Employee>(employeeService.update(id, formData),
				HttpStatus.OK);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> deleteEmployee(@PathVariable("id") Long id) {
		employeeService.delete(id);
		return new ResponseEntity<>("Delete Successfully", HttpStatus.OK);
	}

}
