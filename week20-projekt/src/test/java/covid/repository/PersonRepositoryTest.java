package covid.repository;

import covid.Person;
import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mariadb.jdbc.MariaDbDataSource;

import java.sql.SQLException;

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
        //flyway.clean();
        flyway.migrate();
        personRepository = new PersonRepository(dataSource);
        person = new Person("Hadik Péter", "8200", 50, "hadikp@freemail.hu", "030777222");
    }

    @Test
    void testInsertDataToDatabase() {
        personRepository.insertPerson(person);
    }

    @Test
    void testLoadDataFromDatabase() {
        System.out.println(personRepository.loadPerson("hadik Péter"));
    }


}