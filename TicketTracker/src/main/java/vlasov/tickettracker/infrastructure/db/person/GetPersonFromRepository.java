package vlasov.tickettracker.infrastructure.db.person;

import org.springframework.stereotype.Component;
import vlasov.tickettracker.domain.Person;
import vlasov.tickettracker.infrastructure.repository.PersonRepository;
import vlasov.tickettracker.usecase.person.GetPerson;

import java.util.List;

@Component
public class GetPersonFromRepository implements GetPerson {
    private final PersonRepository personRepository;

    public GetPersonFromRepository(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }
    @Override
    public List<Person> getAll() {
        return personRepository.findAll();
    }
}
