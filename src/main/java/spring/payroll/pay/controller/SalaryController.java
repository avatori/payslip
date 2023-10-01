package spring.payroll.pay.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import spring.payroll.pay.model.Salary;
import spring.payroll.pay.service.implementation.SalaryServiceImpl;

@RestController
@RequestMapping("/salary")
@RequiredArgsConstructor
public class SalaryController {
    protected final SalaryServiceImpl salaryImpl;

    @GetMapping("/new")
    @ResponseBody
    public void createTable(@RequestBody Salary salary) {
        salaryImpl.createTable(salary);

        // calling another API
        // RestTemplate restTemplate = new RestTemplate();
        // String url = "http://localhost:8080/company/list";
        // String response = restTemplate.getForObject(url + "/2", String.class);
    }
}
