package vlasov.tickettracker.usecase.ticket;

import jakarta.inject.Named;
import jakarta.transaction.Transactional;
import vlasov.tickettracker.domain.Ticket;
import vlasov.tickettracker.domain.model.TicketStatus;

import java.util.UUID;

@Named
@Transactional
public class CreateTicketUseCase {
    private final CreateTicket createTicket;

    public CreateTicketUseCase(CreateTicket createTicket) {
        this.createTicket = createTicket;
    }

    public Ticket create(UUID personId, String text, String phoneNumber, String name, TicketStatus status) {
        Ticket ticket = Ticket.create(personId, text, phoneNumber, name, status);
        return createTicket.create(ticket);
    }

}
