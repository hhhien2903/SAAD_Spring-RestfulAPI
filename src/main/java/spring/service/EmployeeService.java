package spring.service;

import java.util.List;

import spring.model.Employee;
import spring.model.dto.CreateEmployeeDTO;
import spring.model.dto.UpdateEmployeeDTO;

public interface EmployeeService {
	public List<Employee> findAll();

	public Employee findById(Long id);

	public Employee create(CreateEmployeeDTO formData);

	public Employee update(Long id, UpdateEmployeeDTO formaData);

	public void delete(Long id);

}
