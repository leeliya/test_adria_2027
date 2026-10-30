package bdcc.devops.transactionservice.web.rest;

import bdcc.devops.transactionservice.entities.Transaction;
import bdcc.devops.transactionservice.service.TransactionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping("/transactions")
    public List<Transaction> getTransactions() {
        return transactionService.getAllTransactions();
    }

    @GetMapping("/transactions/{id}")
    public Transaction getTransactionById(@PathVariable UUID id) {
        return transactionService.findTransactionById(id);
    }

    @PostMapping("/transactions")
    public Transaction saveTransaction(@RequestBody Transaction transaction) {
        return transactionService.save(transaction);
    }
}
