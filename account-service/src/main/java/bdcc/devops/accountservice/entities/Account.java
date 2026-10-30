package bdcc.devops.accountservice.entities;

import bdcc.devops.accountservice.Status;

import java.util.UUID;

@Entity @Builder
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class Account {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;
    private String customerReference;
    private Double balance;
    private String currency;
    private Status status;
}
