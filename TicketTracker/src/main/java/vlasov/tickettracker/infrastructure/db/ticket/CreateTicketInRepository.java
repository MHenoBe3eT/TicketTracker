package vlasov.tickettracker.infrastructure.db.ticket;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;
import vlasov.tickettracker.domain.Ticket;
import vlasov.tickettracker.infrastructure.repository.TicketRepository;
import vlasov.tickettracker.usecase.ticket.CreateTicket;
@Component
@Transactional
public class CreateTicketInRepository implements CreateTicket {
    private final TicketRepository ticketRepository;

    public CreateTicketInRepository(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    @Override
    public Ticket create(Ticket ticket) {
        return ticketRepository.save(ticket);
    }
}
