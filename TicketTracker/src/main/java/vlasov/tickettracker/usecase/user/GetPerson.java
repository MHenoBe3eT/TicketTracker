package vlasov.tickettracker.usecase.user;

import vlasov.tickettracker.domain.Person;

import java.util.List;
import java.util.UUID;

public interface GetPerson {
   List<Person> getAll();
}
