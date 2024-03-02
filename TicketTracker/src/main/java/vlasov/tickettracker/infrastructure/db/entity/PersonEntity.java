package vlasov.tickettracker.infrastructure.db.entity;


import jakarta.persistence.*;
import lombok.Data;
import vlasov.tickettracker.domain.model.Role;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "persons")
@Data
public class PersonEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @ElementCollection(fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Set<Role> roles;
}

