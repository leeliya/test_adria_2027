package bdcc.devops.transactionservice;

import bdcc.devops.transactionservice.entities.Transaction;
import bdcc.devops.transactionservice.service.TransactionService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.UUID;

@SpringBootApplication
@EnableFeignClients
public class TransactionServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(TransactionServiceApplication.class, args);
    }

     @Bean
     CommandLineRunner init(TransactionService transactionService) {
            return args -> {
                for (long i = 1; i <= 10; i++) {
                    transactionService.save(Transaction.builder()
                            .accountId(UUID.randomUUID())
                            .amount(Math.random() * 1000)
                            .merchantCategory(Math.random() > 0.5 ? "Supermarket" : "Travel")
                            .build() );
                }
            };
     }
}
