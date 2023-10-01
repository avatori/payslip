package spring.payroll.pay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PayApplication {

	public static void main(String[] args) {
		SpringApplication.run(PayApplication.class, args);
	}

	// @Bean
	// CommandLineRunner run(CompanyRepo companyRepo) {
	// return args -> {
	// companyRepo.save(new Company(null, "Ava&Co", "avanco@gmail.com"));
	// companyRepo.save(new Company(null, "Jolo&Co", "jolonco@gmail.com"));
	// companyRepo.save(new Company(null, "IBM", "ibm@gmail.com"));
	// companyRepo.save(new Company(null, "Accenture", "acn@gmail.com"));
	// };
	// }

}
