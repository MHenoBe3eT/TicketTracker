package vlasov.tickettracker.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import vlasov.tickettracker.infrastructure.rest.PersonController;
import vlasov.tickettracker.infrastructure.rest.TicketController;
import vlasov.tickettracker.usecase.person.GetPersonsListUseCase;

@Configuration
public class OpenAPIConfig {

    private final GetPersonsListUseCase getPersonsListUseCase;

    public OpenAPIConfig(GetPersonsListUseCase getPersonsListUseCase) {
        this.getPersonsListUseCase = getPersonsListUseCase;
    }

    @Bean
    public PersonController personController() {
        return new PersonController(getPersonsListUseCase);
    }

    @Bean
    public TicketController ticketController() {
        return new TicketController();
    }
}
