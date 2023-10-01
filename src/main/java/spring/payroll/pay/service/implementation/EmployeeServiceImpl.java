package spring.payroll.pay.service.implementation;

import java.util.Collection;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import spring.payroll.pay.model.Employee;
import spring.payroll.pay.service.EmployeeService;

@RequiredArgsConstructor
@Service
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {

    private final JdbcTemplate jdbc;

    @Override
    public void saveEmployee(Employee[] emp) {
        log.info("saving new employee");
        String sql = "INSERT INTO employee(companyId, name, email, basicSalary) VALUES(?, ?, ?, ?)";
        for (Employee employee : emp) {
            jdbc.update(sql,
                    employee.getCompanyId(),
                    employee.getName(),
                    employee.getEmail(),
                    employee.getBasicSalary());
        }
    }

    @Override
    public void updateEmployee(Employee emp) {
        log.info("updating employee info ID: {}  --- Name: {}", emp.getEmpId(), emp.getName());
        String sql = "UPDATE employee SET companyId = ?, name = ?, email = ?, basicSalary = ? WHERE empId = ? )";
        jdbc.update(sql,
                emp.getCompanyId(),
                emp.getName(),
                emp.getEmail(),
                emp.getBasicSalary(),
                emp.getEmpId());
        log.info("updating employee info ID: {} sucess", emp.getEmpId());
    }

    @Override
    public Collection<Employee> getAllEmployees() {
        log.info("listing all employee");
        String sql = "SELECT * FROM employee";
        return jdbc.query(sql, new BeanPropertyRowMapper<>(Employee.class));
    }

    @Override
    public Employee findEmployee(Long id) {
        log.info("retrieving info of employee {}", id);
        String sql = "SELECT * FROM employee where empId = ?";
        return jdbc.queryForObject(sql, new BeanPropertyRowMapper<>(Employee.class), new Object[] { id });
    }

    @Override
    public Boolean deleteEmployee(Long id) {
        log.info("removing employee {}", id);
        String sql = "DELETE FROM employee WHERE empId = ?";
        jdbc.update(sql, id);
        return true;
    }

}
