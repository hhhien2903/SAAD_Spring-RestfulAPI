package spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import spring.model.Employee;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
