package bdcc.devops.transactionservice.service;

import bdcc.devops.transactionservice.domain.AccountRestClient;
import bdcc.devops.transactionservice.entities.Transaction;
import bdcc.devops.transactionservice.repository.TransactionRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class TransactionService {
    private final TransactionRepository transactionRepository;
    private final AccountRestClient accountRestClient;

    TransactionService(TransactionRepository transactionRepository, AccountRestClient accountRestClient) {
        this.accountRestClient = accountRestClient;
        this.transactionRepository = transactionRepository;
    }

    public void save(Transaction transaction) {
        try {
            accountRestClient.getAccountById(transaction.getAccountId());
            transaction.setId(UUID.randomUUID());
            transaction.setCreatedAt(String.valueOf(new Date()));
            transactionRepository.save(transaction);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public Transaction findTransactionById(UUID id) {
        Transaction transaction = transactionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Transaction not found"));
        transaction.setAccount(accountRestClient.getAccountById(transaction.getAccountId()));
        return transaction;
    }

    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }
}
