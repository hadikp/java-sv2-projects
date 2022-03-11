package covid.repository;

import covid.Zip;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class ZipRepository {

    private JdbcTemplate jdbcTemplate;

    public ZipRepository(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public String loadZip(String townName) {
        return jdbcTemplate.queryForObject("Select * from zip where town_name = ?", (rs, rowNum)
                -> rs.getString("zip"), townName);
    }

    public void insertZip(List<Zip> zipList) {
        for (Zip z: zipList) {
            String townName = z.getTownName();
            String zip = z.getZip();
            jdbcTemplate.update("Insert into zip(town_name, zip) values(?,?)", townName, zip);
        }
    }

    public List<Zip> makeZipList(Path path) {
        List<String> zipFromFile = loadFile(path);
        List<Zip> result = new ArrayList<>();
        for (int i = 1; i < zipFromFile.size(); i++) {
            String[] zipFileSplit = zipFromFile.get(i).split(";");
            String townName = zipFileSplit[1].trim();
            String zip = zipFileSplit[0].trim();

            String partTownName = "";
            if(zipFileSplit.length == 3) {
                partTownName = zipFileSplit[2].trim();
            }
            if(!partTownName.isBlank()) {
                result.add(new Zip(partTownName, zip));
            } else {
                result.add(new Zip(townName, zip));
            }
        }
        return result;
    }

    private List<String> loadFile(Path path) {
        try {
            return Files.readAllLines(path);
        }
        catch (IOException ioe) {
            throw new IllegalArgumentException("Can't read file!", ioe);
        }
    }

}
