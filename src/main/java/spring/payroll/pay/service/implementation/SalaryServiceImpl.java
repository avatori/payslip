package spring.payroll.pay.service.implementation;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import lombok.RequiredArgsConstructor;
import spring.payroll.pay.constants.Constants;
import spring.payroll.pay.model.Company;
import spring.payroll.pay.model.PayDetails;
import spring.payroll.pay.model.Salary;
import spring.payroll.pay.service.SalaryService;

@RequiredArgsConstructor
@Service
public class SalaryServiceImpl implements SalaryService {

    private final JdbcTemplate jdbc;
    RestTemplate restTemplate = new RestTemplate();

    // Strings
    String url_list_x = Constants.MAIN_URL + "/company/list/2";

    @Override
    public void createTable(Salary salary) {

        Company resp = restTemplate.getForObject(url_list_x, Company.class);

        String tableName = Constants.STR_EMPTY;
        for (PayDetails detail : salary.getPayDetails()) {
            tableName += detail.getName().replace(Constants.STR_SPACE, Constants.STR_UNDERSCORE).toString()
                    + Constants.STR_UNDERSCORE
                    + ((Integer) detail.getType()).toString()
                    + " VARCHAR(255),";
        }

        // TODO change the value of this from company data
        // NOT NULL AUTO_INCREMENT,
        String sql = "CREATE TABLE salary"
                + Constants.STR_UNDERSCORE
                + salary.getCompanyId()
                + Constants.STR_UNDERSCORE
                + resp.getName()
                + Constants.STR_OPEN_PAR
                + "salaryId BIGINT NOT NULL AUTO_INCREMENT,"
                + "companyId BIGINT(100) NOT NULL,"
                + tableName
                // + tableName.substring(Constants.INT_ZERO, tableName.length() -
                // Constants.INT_ONE)
                + "PRIMARY KEY (salaryId)"
                + Constants.STR_CLOSE_PAR;
        System.out.println(sql);
        jdbc.execute(sql);
    }

    @Override
    public Salary saveSalary(Salary salary) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'saveSalary'");
    }

}
