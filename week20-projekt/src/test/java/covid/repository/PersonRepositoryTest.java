package covid.repository;

import covid.Person;
import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mariadb.jdbc.MariaDbDataSource;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PersonRepositoryTest {

    Flyway flyway;
    PersonRepository personRepository;
    Person person;

    @BeforeEach
    void init() {
        MariaDbDataSource dataSource = new MariaDbDataSource();
        try {
            dataSource.setUrl("jdbc:mariadb://localhost:3306/covid?useUnicode=true");
            dataSource.setUser("covid");
            dataSource.setPassword("covid");
        } catch (SQLException sqle) {
            throw new IllegalStateException("Cannot reach DataBase!", sqle);
        }

        flyway = Flyway.configure().locations("db/migration/covid").dataSource(dataSource).load();
        flyway.clean();
        flyway.migrate();
        personRepository = new PersonRepository(dataSource);
        person = new Person("Péter", "8200", 50, "hadikp@freemail.hu", "030777222", 2, LocalDate.of(2021, 12, 23));
    }

    @Test
    void testInsertDataToDatabase() {
        Person[] personList = {
                new Person("Kovács János", "3126", 33, "kovacs@freemail.hu", "033233444", 2, LocalDate.of(2021, 12, 13)),
        new Person("Lópiczi Gáspár", "8200", 44, "lopiczi@freemail.hu", "035332233", 1, LocalDate.of(2021, 12, 23))};
        personRepository.insertPersonList(personList);
    }

    @Test
    void testLoadDataFromDatabase() {
        System.out.println(personRepository.loadPerson("hadik Péter"));
    }


}