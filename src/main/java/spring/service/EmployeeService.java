package spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import spring.model.Employee;
import spring.repository.EmployeeRepository;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;

	public List<Employee> findAll() {
		return employeeRepository.findAll();
	}

	public Employee findById(Long id) {
		try {
			return employeeRepository.findById(id).get();
		} catch (Exception e) {
			// TODO: handle exception
			throw new ResponseStatusException(HttpStatus.NO_CONTENT);
		}

	}

	public Employee create(Employee employee) {
		try {
			return employeeRepository.save(employee);
		} catch (Exception e) {
			// TODO: handle exception
			throw new ResponseStatusException(HttpStatus.CONFLICT);
		}

	}

	public Employee update(Long id, Employee employee) {
		if (checkExistEmployee(id) == false) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,
					"Employee does not exist");
		}
		employee.setId(id);
		return employeeRepository.save(employee);

	}

	public void delete(Long id) {
		try {
			employeeRepository.deleteById(id);
		} catch (Exception e) {
			// TODO: handle exception
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,
					"Employee does not exist");
		}

	}

	private Boolean checkExistEmployee(Long id) {
		return employeeRepository.existsById(id);
	}

}
