package vlasov.tickettracker.usecase.ticket;

import jakarta.inject.Named;
import org.springframework.data.domain.Page;
import vlasov.tickettracker.domain.model.TicketStatus;
import vlasov.tickettracker.infrastructure.entity.TicketEntity;

@Named
public class GetAllTicketsUseCase {
    private final GetTicket getTicket;

    public GetAllTicketsUseCase(GetTicket getTicket) {
        this.getTicket = getTicket;
    }

    public Page<TicketEntity> getAllWithSorting(
            TicketStatus status,
            int pageNumber,
            int pageSize,
            String sortField,
            String sortOrder)
    {
        return getTicket.findAllWithSorting(status, pageNumber, pageSize, sortField, sortOrder);
    }
}
