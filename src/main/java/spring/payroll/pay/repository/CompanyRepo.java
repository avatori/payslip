package spring.payroll.pay.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import spring.payroll.pay.model.Company;

public interface CompanyRepo extends JpaRepository<Company, Long> {

    Company findByEmail(String companyEmail);
}
