package spring.payroll.pay.service;

import spring.payroll.pay.model.Salary;

public interface SalaryService {
    void createTable(Salary salary);

    Salary saveSalary(Salary salary);
}
