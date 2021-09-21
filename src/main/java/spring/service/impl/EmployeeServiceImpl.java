package spring.service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import error.EmployeeNotFoundException;
import spring.model.Employee;
import spring.model.dto.CreateEmployeeDTO;
import spring.model.dto.UpdateEmployeeDTO;
import spring.repository.EmployeeRepository;
import spring.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;
	@Autowired
	private ModelMapper mapper;

	public List<Employee> findAll() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee findById(Long id) {
		Employee employee = employeeRepository.findById(id).orElseThrow(
				() -> new EmployeeNotFoundException("Not found Employee with id: " + id));
		return employee;
	}

	@Override
	public Employee create(CreateEmployeeDTO formData) {
		try {
			Employee newEmployee = new Employee();
			mapper.map(formData, newEmployee);
			return employeeRepository.save(newEmployee);
		} catch (Exception e) {
			// TODO: handle exception
			throw new ResponseStatusException(HttpStatus.CONFLICT);
		}

	}

	@Override
	public Employee update(Long id, UpdateEmployeeDTO formData) {
		if (checkExistEmployee(id) == false) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,
					"Employee does not exist");
		}
		Employee updateEmployee = employeeRepository.getById(id);
		mapper.map(formData, updateEmployee);

		return employeeRepository.save(updateEmployee);

	}

	@Override
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
