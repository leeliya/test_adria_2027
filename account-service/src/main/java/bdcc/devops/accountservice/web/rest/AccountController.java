package bdcc.devops.accountservice.web.rest;

import bdcc.devops.accountservice.entities.Account;
import bdcc.devops.accountservice.service.AccountService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class AccountController {
    private AccountService accountService;

    AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/accounts")
    public List<Account> getAllAccounts() {
        return accountService.getAllAccounts();
    }

    @GetMapping("/accounts/{id}")
    public Account getAccountById(@PathVariable UUID id) {
        return accountService.getAccountById(id);
    }

    @PostMapping("/accounts")
    public Account createAccount(@RequestBody Account account) {
        return accountService.save(account);
    }
}
