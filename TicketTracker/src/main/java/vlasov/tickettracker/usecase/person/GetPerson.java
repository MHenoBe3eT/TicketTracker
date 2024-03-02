package vlasov.tickettracker.usecase.person;

import vlasov.tickettracker.domain.Person;

import java.util.List;

public interface GetPerson {
    List<Person> getAll();
}
