package vlasov.tickettracker.infrastructure.entity;

import jakarta.persistence.*;
import lombok.Data;
import vlasov.tickettracker.domain.Person;
import vlasov.tickettracker.domain.model.Role;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Entity
@Table(name = "persons")
@Data
public class PersonEntity {
    @Id
    private UUID id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @ElementCollection(fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Set<Role> roles;

    public static class PersonConverter {

        public static PersonEntity toEntity(Person person) {
            PersonEntity entity = new PersonEntity();
            entity.setId(person.getId());
            entity.setUsername(person.getUsername());
            entity.setPassword(person.getPassword());
            entity.setRoles(person.getRoles());
            return entity;
        }

        public static Person toDomain(PersonEntity entity) {
            return new Person(
                    entity.getId(),
                    entity.getUsername(),
                    entity.getPassword(),
                    new HashSet<>(entity.getRoles())
            );
        }

        public static List<PersonEntity> toEntityList(List<Person> personList) {
            return personList.stream()
                    .map(PersonConverter::toEntity)
                    .collect(Collectors.toList());
        }
    }
}
