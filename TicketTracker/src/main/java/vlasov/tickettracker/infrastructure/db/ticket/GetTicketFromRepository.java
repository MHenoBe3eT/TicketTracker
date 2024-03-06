package vlasov.tickettracker.infrastructure.db.ticket;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import vlasov.tickettracker.domain.Ticket;
import vlasov.tickettracker.domain.model.TicketStatus;
import vlasov.tickettracker.infrastructure.entity.TicketEntity;
import vlasov.tickettracker.infrastructure.repository.TicketRepository;
import vlasov.tickettracker.usecase.ticket.GetTicket;

import java.util.UUID;

@Component
public class GetTicketFromRepository implements GetTicket {
    private final TicketRepository ticketRepository;

    public GetTicketFromRepository(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    @Override
    public Ticket byId(UUID id) {
        return ticketRepository.findById(id).orElse(null);
    }

    @Override
    public Page<Ticket> findAllWithSorting(
            TicketStatus status,
            int pageNumber,
            int pageSize,
            String sortField,
            String sortOrder) {
        Sort.Direction direction = sortOrder.equalsIgnoreCase("asc") ? Sort.Direction.ASC : Sort.Direction.DESC;
        Sort sort = Sort.by(direction, sortField);
        Pageable pageable = PageRequest.of(pageNumber, pageSize, sort);
        return ticketRepository.findByStatus(status, pageable);
    }
}
