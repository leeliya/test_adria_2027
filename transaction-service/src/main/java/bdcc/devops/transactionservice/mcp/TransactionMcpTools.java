package bdcc.devops.transactionservice.mcp;

import bdcc.devops.transactionservice.entities.Transaction;
import bdcc.devops.transactionservice.service.TransactionService;
import org.springframework.ai.mcp.annotation.McpTool;
import org.springframework.ai.mcp.annotation.McpToolParam;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class TransactionMcpTools {
    private final TransactionService service;

    public TransactionMcpTools(TransactionService service) {
        this.service = service;
    }

    @McpTool(description = "Liste toutes les transactions")
    public List<Transaction> listTransactions() {
        return service.getAllTransactions();
    }

    @McpTool(description = "Liste les transactions d'un compte")
    public List<Transaction> transactionsByAccount(
            @McpToolParam(description = "UUID du compte") UUID accountId) {
        return service.findTransactionsByAccountId(accountId);
    }

    @McpTool(description = "Enregistre une transaction (débit) sur un compte")
    public Transaction createTransaction(
            @McpToolParam(description = "UUID du compte") UUID accountId,
            @McpToolParam(description = "montant strictement positif")
            Double amount,
            @McpToolParam(description = "devise du compte, ex. MAD") String
                    currency,
            @McpToolParam(description = "catégorie du commerçant") String
                    merchantCategory,
            @McpToolParam(description = "pays") String country) {
        return service.save(Transaction.builder()
                .accountId(accountId)
                .amount(-Math.abs(amount))
                .currency(currency)
                .merchantCategory(merchantCategory)
                .country(country)
                .build());
    }

}
