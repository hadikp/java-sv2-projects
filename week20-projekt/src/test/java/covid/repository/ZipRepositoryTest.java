package covid.repository;

import covid.Zip;
import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mariadb.jdbc.MariaDbDataSource;

import java.nio.file.Path;
import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ZipRepositoryTest {

    Flyway flyway;
    ZipRepository zipRepository;
    Path path;

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
        path = Path.of("src/test/resources/zip.csv");

    }

    @Test
    void testLoadDataFromDatabase() {
        System.out.println();
    }

    @Test
    void testMakeZipList() {
        List<Zip> zipList = zipRepository.makeZipList(path);
        assertEquals("Szentendre", zipList.get(0).getTownName());
        assertEquals("2000", zipList.get(0).getZip());
        assertEquals("Tótfalu", zipList.get(8).getTownName());
        assertEquals("2021", zipList.get(8).getZip());
    }

    @Test
    void testWrongFileName() {
        IllegalArgumentException iea = assertThrows(IllegalArgumentException.class, ()
                -> zipRepository.makeZipList(Path.of("src")));
        assertEquals("Can't read file!", iea.getMessage());
    }

}