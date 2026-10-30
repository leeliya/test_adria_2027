package bdcc.devops.accountservice.service;

import bdcc.devops.accountservice.entities.Account;
import bdcc.devops.accountservice.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AccountService {
    private AccountRepository accountRepository;

    AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    public Account getAccountById(UUID id) {
        return accountRepository.findById(id).orElse(null);
    }

    public Account save(Account account) {
        return accountRepository.save(account);
    }

}