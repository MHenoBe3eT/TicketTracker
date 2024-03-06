package vlasov.tickettracker.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vlasov.tickettracker.domain.Person;
import vlasov.tickettracker.domain.Ticket;
import vlasov.tickettracker.infrastructure.entity.PersonEntity;

import java.util.UUID;

@Repository
public interface PersonRepository extends JpaRepository<PersonEntity, UUID> {
}
