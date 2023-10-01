package spring.payroll.pay.controller;

import java.time.LocalDateTime;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import spring.payroll.pay.model.Employee;
import spring.payroll.pay.model.Response;
import spring.payroll.pay.service.implementation.EmployeeServiceImpl;

@RestController
@RequiredArgsConstructor
@RequestMapping("/employee")
public class EmployeeController {

        private final EmployeeServiceImpl employeeServiceImpl;

        @GetMapping("/all")
        public ResponseEntity<Response> getEmployees() {
                return ResponseEntity.ok(
                                Response.builder()
                                                .data(Map.of("employees", employeeServiceImpl.getAllEmployees()))
                                                .status(HttpStatus.OK)
                                                .statusCode(HttpStatus.OK.value())
                                                .build());
        }

        @GetMapping("/find/{id}")
        public ResponseEntity<Response> findEmployee(Long id) {
                return ResponseEntity.ok(
                                Response.builder()
                                                .data(Map.of("employee", employeeServiceImpl.findEmployee(id)))
                                                .build());
        }

        @PostMapping("/save")
        public ResponseEntity<Response> saveEmployee(@RequestBody Employee[] emp) {
                employeeServiceImpl.saveEmployee(emp);

                return ResponseEntity.ok(
                                Response.builder()
                                                .timeStamp(LocalDateTime.now())
                                                .developerMsg("new employees saved!")
                                                .build());
        }

        @DeleteMapping("/delete")
        public ResponseEntity<Response> deleteEmployee(@RequestParam(name = "id") Long id) {
                return ResponseEntity.ok(
                                Response.builder()
                                                .timeStamp(LocalDateTime.now())
                                                .data(Map.of("employee", employeeServiceImpl.deleteEmployee(id)))
                                                .developerMsg("employee has been deleted: " + id)
                                                .build());
        }

}
