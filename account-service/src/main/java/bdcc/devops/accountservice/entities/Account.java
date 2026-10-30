package bdcc.devops.accountservice.entities;

import bdcc.devops.accountservice.Status;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.util.UUID;

@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;
    private String customerReference;
    private Double balance;
    private String currency;
    private Status status;

    public Account(UUID id, String notAvailable, double v, String notAvailable1, Object o) {
        this.id = id;
        this.customerReference = notAvailable;
        this.balance = v;
        this.currency = notAvailable1;
        this.status = (Status) o;
    }
}
