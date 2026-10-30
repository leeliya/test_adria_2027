package bdcc.devops.accountservice.controllers;

import bdcc.devops.accountservice.entities.Account;
import bdcc.devops.accountservice.service.AccountService;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
public class AccountConroller {
    private AccountService accountService;

    AccountConroller(AccountService accountService) {
        this.accountService = accountService;
    }

    public List<Account> getAllAccounts() {
        return accountService.getAllAccounts();
    }
    public Account getAccountById(UUID id) {
        return accountService.getAccountById(id);
    }

    public Account createAccount(Account account) {
        return accountService.save(account);
    }
}
