package spring.payroll.pay.controller;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import spring.payroll.pay.model.Company;
import spring.payroll.pay.model.Response;
import spring.payroll.pay.service.implementation.CompanyServiceImpl;

@RestController
@RequestMapping("/company")
@RequiredArgsConstructor
public class CompanyController {
        private final CompanyServiceImpl compServiceImpl;

        @GetMapping("/list")
        public ResponseEntity<Response> getCompanies() {

                return ResponseEntity.ok(
                                Response.builder()
                                                .timeStamp(java.time.LocalDateTime.now())
                                                .data(Map.of("companies", compServiceImpl.displayCompany(30)))
                                                .developerMsg("Retrieving all companies ---- test")
                                                .status(HttpStatus.OK)
                                                .statusCode(HttpStatus.OK.value())
                                                .build());

        }

        @GetMapping("/sample")
        public ResponseEntity<Map<?, ?>> getSample() {

                return ResponseEntity.ok(Map.of("companies",
                                compServiceImpl.displayCompany(30)));
        }

        @GetMapping("/list/{companyId}")
        public Company getCompany(@PathVariable("companyId") Long companyId) {
                // ResponseEntity.ok(
                // Response.builder()
                // .timeStamp(java.time.LocalDateTime.now())
                // // .data(Map.of("company", compServiceImpl.getCompany(companyId)))
                // .developerMsg("Retrieving via companyId")
                // .status(HttpStatus.OK)
                // .statusCode(HttpStatus.OK.value())
                // .build());
                return compServiceImpl.getCompany(companyId);

        }

        @PostMapping("/save")
        public ResponseEntity<Response> saveCompany(@RequestBody @Valid Company company) {
                return ResponseEntity.ok(
                                Response.builder()
                                                .timeStamp(java.time.LocalDateTime.now())
                                                .data(Map.of("company", compServiceImpl.saveCompany(company)))
                                                .developerMsg("Company created")
                                                .status(HttpStatus.CREATED)
                                                .statusCode(HttpStatus.CREATED.value())
                                                .build());

        }

        @DeleteMapping("/delete/{companyId}")
        public ResponseEntity<Response> removeCompany(@PathVariable("companyId") Long companyId) {
                return ResponseEntity.ok(
                                Response.builder()
                                                .timeStamp(java.time.LocalDateTime.now())
                                                .data(Map.of("deleted", compServiceImpl.removeCompany(companyId)))
                                                .developerMsg("Deleted company")
                                                .status(HttpStatus.OK)
                                                .statusCode(HttpStatus.OK.value())
                                                .build());

        }
}