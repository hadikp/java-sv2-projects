package covid.service;

import covid.repository.ZipRepository;
import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mariadb.jdbc.MariaDbDataSource;

import javax.sql.DataSource;

import java.nio.file.Path;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class ZipServiceTest {

    ZipRepository zipRepository;
    ZipService zipService;
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
        zipRepository = new ZipRepository(dataSource);
        zipService = new ZipService(zipRepository);
        path = Path.of("src/test/resources/zip.csv");

    }

    @Test
    void insertZipListToDatabase() {
       zipService.insertZipFromFile(path);
    }

}