package bdcc.devops.transactionservice.repository;

import bdcc.devops.transactionservice.entities.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TransactionRepository extends JpaRepository<Transaction, UUID> {

}
