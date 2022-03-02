package covid;

import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mariadb.jdbc.MariaDbDataSource;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ZipRepositoryTest {

    Flyway flyway;
    ZipRepository zipRepository;

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
        zipRepository = new ZipRepository(dataSource);
    }

    @Test
    void testLoadData() {
        System.out.println();
    }

    @Test
    void insertData() {
        List<Zip> zipList = Arrays.asList(new Zip("Székesfehérvár", "8000"), new Zip("Bárna", "3126"));
        zipRepository.insertZip(zipList);
    }

}