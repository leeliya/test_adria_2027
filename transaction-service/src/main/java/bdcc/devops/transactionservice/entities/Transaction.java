package bdcc.devops.transactionservice.entities;

import bdcc.devops.accountservice.entities.Account;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity @Getter
@Setter @Builder @NoArgsConstructor
@AllArgsConstructor
public class Transaction {
    @Id
    private UUID id;
    private UUID accountId;
    private Double amount;
    private String currency;
    private String merchantCategory;
    private String country;
    private String createdAt;
    @Transient
    private Account account;
}
