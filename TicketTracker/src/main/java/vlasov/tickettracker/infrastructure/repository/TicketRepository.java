package vlasov.tickettracker.infrastructure.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vlasov.tickettracker.domain.Ticket;
import vlasov.tickettracker.domain.model.TicketStatus;

import java.util.UUID;
@Repository
public interface TicketRepository extends JpaRepository<Ticket, UUID> {
    Page<Ticket> findByStatus(TicketStatus status, Pageable pageable);
    default Page<Ticket> findAllWithSorting(TicketStatus status, int pageNumber, int pageSize, String sortField, String sortOrder) {
        Sort.Direction direction = sortOrder.equalsIgnoreCase("asc") ? Sort.Direction.ASC : Sort.Direction.DESC;
        Sort sort = Sort.by(direction, sortField);
        Pageable pageable = PageRequest.of(pageNumber, pageSize, sort);
        return findByStatus(status, pageable);
    }
}
