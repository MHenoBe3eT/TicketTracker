package vlasov.tickettracker.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import vlasov.tickettracker.domain.model.Role;

import java.util.Set;
import java.util.UUID;

@Getter
@AllArgsConstructor
public class Person {
    private final UUID id;
    private final String username;
    private final String password;
    private final Set<Role> roles;

}
