package vlasov.tickettracker.infrastructure.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vlasov.tickettracker.domain.Person;
import vlasov.tickettracker.usecase.person.GetPersonsListUseCase;

import java.util.List;

@RestController
@RequestMapping("/api/persons")
public class PersonController {
    private final GetPersonsListUseCase getPersonsListUseCase;

    @Autowired
    public PersonController(GetPersonsListUseCase getPersonsListUseCase) {
        this.getPersonsListUseCase = getPersonsListUseCase;
    }

    @GetMapping
    public ResponseEntity<List<Person>> getAllPersons() {
        List<Person> persons = getPersonsListUseCase.getAll();
        return new ResponseEntity<>(persons, HttpStatus.OK);
    }

}
