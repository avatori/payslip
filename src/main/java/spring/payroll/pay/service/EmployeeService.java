package spring.payroll.pay.service;

import java.util.Collection;

import spring.payroll.pay.model.Employee;

public interface EmployeeService {

    void saveEmployee(Employee[] emp);

    void updateEmployee(Employee emp);

    Collection<Employee> getAllEmployees();

    Employee findEmployee(Long id);

    Boolean deleteEmployee(Long id);

}
