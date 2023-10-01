package spring.payroll.pay.service;

import java.util.Collection;

import spring.payroll.pay.model.Company;

public interface CompanyService {

    Company saveCompany(Company company);

    Company updateCompany(Company company);

    Company getCompany(Long companyId);

    Collection<Company> displayCompany(int page);

    Boolean removeCompany(Long companyId);

}
