package covid;

import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mariadb.jdbc.MariaDbDataSource;

import java.sql.SQLException;

class PersonRepositoryTest {

    Flyway flyway;
    PersonRepository personRepository;

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
    }

    @Test
    void testLoadDataFromDatabase() {
        System.out.println(personRepository.loadPerson("Péter"));
    }

}