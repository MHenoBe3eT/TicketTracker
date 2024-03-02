package vlasov.tickettracker.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import vlasov.tickettracker.domain.model.TicketStatus;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ticket {
    private UUID id;
    private UUID personId;
    private String text;
    private String phoneNumber;
    private String name;
    private TicketStatus status;

    public static Ticket create(UUID personId, String text, String phoneNumber, String name, TicketStatus status) {
        UUID id = UUID.randomUUID();
        return new Ticket(id,personId, text, phoneNumber, name, status);
    }

    public void update(String text, String phoneNumber, String name, TicketStatus status) {
        this.text = text;
        this.phoneNumber = phoneNumber;
        this.name = name;
        this.status = status;
    }
}
