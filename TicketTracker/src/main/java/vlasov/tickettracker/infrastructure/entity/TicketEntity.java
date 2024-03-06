package vlasov.tickettracker.infrastructure.entity;

import jakarta.persistence.*;
import lombok.Data;
import vlasov.tickettracker.domain.model.TicketStatus;
import java.util.UUID;


@Entity
@Table(name = "tickets")
@Data
public class TicketEntity {
    @Id
    private UUID id;

    @Column(name = "person_id", nullable = false)
    private UUID personId;

    @Column(nullable = false)
    private String text;

    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TicketStatus status;

}

