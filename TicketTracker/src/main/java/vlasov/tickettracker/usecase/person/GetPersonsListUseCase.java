package vlasov.tickettracker.usecase.person;

import jakarta.inject.Named;
import vlasov.tickettracker.domain.Person;

import java.util.List;
@Named
public class GetPersonsListUseCase {
    private final GetPerson getPerson;

    public GetPersonsListUseCase(GetPerson getPerson) {
        this.getPerson = getPerson;
    }

    public List<Person> getAll() {
        return getPerson.getAll();
    }
}
