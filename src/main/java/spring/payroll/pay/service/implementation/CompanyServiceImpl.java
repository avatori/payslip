package spring.payroll.pay.service.implementation;

import java.util.Collection;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import spring.payroll.pay.model.Company;
import spring.payroll.pay.repository.CompanyRepo;
import spring.payroll.pay.service.CompanyService;

@RequiredArgsConstructor
@Service
@Transactional
@Slf4j
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepo compRepo;

    @Override
    public Company saveCompany(Company company) {
        log.info("creating new company", company.getName());
        return compRepo.save(company);
    }

    @Override
    public Company getCompany(Long companyId) {
        log.info("getting company details by id: {}", companyId);
        return compRepo.findById(companyId).get();
    }

    @Override
    public Collection<Company> displayCompany(int page) {
        log.info("listing {} companies", page);
        return compRepo.findAll(PageRequest.of(0, page)).toList();
    }

    @Override
    public Boolean removeCompany(Long companyId) {
        log.info("deleting company {}", companyId);
        compRepo.deleteById(companyId);
        return true;
    }

    @Override
    public Company updateCompany(Company company) {
        log.info("company name = {} is being updated", company.getName());
        return compRepo.save(company);
    }

}
