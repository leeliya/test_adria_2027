package bdcc.devops.accountservice;

import bdcc.devops.accountservice.domain.Status;
import bdcc.devops.accountservice.entities.Account;
import bdcc.devops.accountservice.service.AccountService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AccountServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(AccountService accountService) {
		return  args -> {
			accountService.save(Account.builder()
					.balance(1000.0)
					.status(Status.ACTIVE)
					.build());
			accountService.save(Account.builder()
					.balance(2000.0)
					.status(Status.BLOCKED)
					.build());
			accountService.save(Account.builder()
					.balance(3000.0)
					.status(Status.ACTIVE)
					.build());
			accountService.save(Account.builder()
					.balance(4000.0)
					.status(Status.BLOCKED)
					.build());
			accountService.save(Account.builder()
					.balance(5000.0)
					.status(Status.ACTIVE)
					.build());
			accountService.save(Account.builder()
					.balance(6000.0)
					.status(Status.BLOCKED)
					.build());
			accountService.save(Account.builder()
					.balance(7000.0)
					.status(Status.ACTIVE)
					.build());
			accountService.save(Account.builder()
					.balance(8000.0)
					.status(Status.BLOCKED)
					.build());
			accountService.save(Account.builder()
					.balance(9000.0)
					.status(Status.ACTIVE)
					.build());
			accountService.save(Account.builder()
					.balance(10000.0)
					.status(Status.BLOCKED)
					.build());
		};}

}
