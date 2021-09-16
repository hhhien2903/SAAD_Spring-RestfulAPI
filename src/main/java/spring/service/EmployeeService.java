package spring.service;

import java.util.List;

import spring.model.Employee;

public interface EmployeeService {
	public List<Employee> findAll();

	public Employee findById(Long id);

	public Employee create(Employee employee);

	public Employee update(Long id, Employee employee);

	public void delete(Long id);

}
