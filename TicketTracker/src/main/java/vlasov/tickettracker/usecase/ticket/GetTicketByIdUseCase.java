package vlasov.tickettracker.usecase.ticket;

import jakarta.inject.Named;
import vlasov.tickettracker.domain.Ticket;

import java.util.UUID;

@Named
public class GetTicketByIdUseCase {
    private final GetTicket getTicket;

    public GetTicketByIdUseCase(GetTicket getTicket) {
        this.getTicket = getTicket;
    }

    public Ticket byId(UUID id) {
        return getTicket.byId(id);
    }
}
