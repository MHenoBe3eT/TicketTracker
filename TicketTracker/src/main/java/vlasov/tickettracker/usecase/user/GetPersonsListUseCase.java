package vlasov.tickettracker.usecase.user;

import vlasov.tickettracker.domain.Person;

import java.util.List;

public class GetPersonsListUseCase {
    private final GetPerson getPerson;

    public GetPersonsListUseCase(GetPerson getPerson) {
        this.getPerson = getPerson;
    }

    public List<Person> getAll() {
        return getPerson.getAll();
    }
}
