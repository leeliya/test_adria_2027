package bdcc.devops.transactionservice.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Account {
    private UUID id;
    private String customerReference;
    private Double balance;
    private String currency;
    private Status status;
}
