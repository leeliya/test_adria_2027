package bdcc.devops.transactionservice.domain;

import bdcc.devops.accountservice.entities.Account;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.UUID;

@FeignClient(name="account-service")
public interface AccountRestClient {
    @GetMapping("/accounts/{id}")
    @CircuitBreaker(name = "accountService", fallbackMethod = "getDefaultAccount")
    Account getAccountById(@PathVariable UUID id);

    public default Account getDefaultAccount(UUID id, Exception e) {
        return new Account( id, "Not available", 0.0, "Not available", null);
    }
}
