package vlasov.tickettracker.infrastructure.entity;

import jakarta.persistence.*;
import lombok.Data;
import vlasov.tickettracker.domain.Ticket;
import vlasov.tickettracker.domain.model.TicketStatus;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

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

    public static class TicketConverter {


        public static TicketEntity toEntity(Ticket ticket) {
            TicketEntity entity = new TicketEntity();
            entity.setId(ticket.getId());
            entity.setPersonId(ticket.getPersonId());
            entity.setText(ticket.getText());
            entity.setPhoneNumber(ticket.getPhoneNumber());
            entity.setStatus(ticket.getStatus());
            return entity;
        }

        public static Ticket toDomain(TicketEntity ticketEntity) {
            Ticket ticket = new Ticket();
            ticket.setId(ticket.getId());
            ticket.setPersonId(ticket.getPersonId());
            ticket.setText(ticket.getText());
            ticket.setPhoneNumber(ticket.getPhoneNumber());
            ticket.setStatus(ticket.getStatus());
            return ticket;
        }

    }
}
