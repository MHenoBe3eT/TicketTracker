package vlasov.tickettracker.usecase.ticket;


import org.springframework.data.domain.Page;
import vlasov.tickettracker.domain.Ticket;
import vlasov.tickettracker.domain.model.TicketStatus;
import vlasov.tickettracker.infrastructure.entity.TicketEntity;

import java.util.UUID;

public interface GetTicket {

    Ticket byId(UUID id);

    Page<TicketEntity> findAllWithSorting(
            TicketStatus status,
            int pageNumber,
            int pageSize,
            String sortField,
            String sortOrder);
}
