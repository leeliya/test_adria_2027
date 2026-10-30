package bdcc.devops.transactionservice.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.util.UUID;

@Entity @Getter
@Setter @Builder @NoArgsConstructor
@AllArgsConstructor
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;
    private UUID accountId;
    private Double amount;
    private String currency;
    private String merchantCategory;
    private String country;
    private String createdAt;
}
