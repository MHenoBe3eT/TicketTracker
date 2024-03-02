package vlasov.tickettracker.usecase.ticket;

import vlasov.tickettracker.domain.Person;
import vlasov.tickettracker.domain.Ticket;

public interface CreateTicket {
    Ticket create(Ticket ticket);
}
