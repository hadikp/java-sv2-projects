package covid.repository;

import covid.Person;
import covid.Zip;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PersonRepository {

    private JdbcTemplate jdbcTemplate;

    public PersonRepository(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public Person loadPerson(String personName) {
        return jdbcTemplate.queryForObject("Select * from persons where person_name = ?", (rs, rowNum)
                -> new Person(rs.getString("person_name"), rs.getString("zip"), rs.getInt("age"),
                rs.getString("email"), rs.getString("taj"), rs.getInt("vaccina_number"),
                rs.getDate("last_vaccination_date").toLocalDate()), personName);
    }

    public void insertPersonList(Person... persons) {
        for (Person p: persons) {
            String name = p.getName();
            String zip = p.getPostCode();
            int age = p.getAge();
            String email = p.getEmail();
            String taj = p.getTaj();
            int numberOfVaccination = p.getNumberOfVaccination();
            LocalDate lastVaccinationDate = p.getLastVaccinationDate();
            jdbcTemplate.update("Insert into persons(person_name, zip, age, email, taj, vaccina_number, last_vaccination_date)" +
                            " values(?,?,?,?,?,?,?)", name, zip, age, email, taj, numberOfVaccination, lastVaccinationDate);
        }
    }

    public List<Person> makePersonList(Path path) {
        List<String> personFromFile = loadFile(path);
        List<Person> result = new ArrayList<>();
        for (int i = 1; i < personFromFile.size(); i++) {
            String[] personFileSplit = personFromFile.get(i).split(",");
            String name = personFileSplit[0];
            String zip = personFileSplit[1];
            int age = Integer.parseInt(personFileSplit[2]);
            String email = personFileSplit[3];
            String taj = personFileSplit[4];
            int numberOfVaccination = Integer.parseInt(personFileSplit[5]);
            String[] dateSplit = personFileSplit[6].split("/");
            int year = Integer.parseInt(dateSplit[0]);
            int month = Integer.parseInt(dateSplit[1]);
            int day = Integer.parseInt(dateSplit[2]);
            LocalDate lastVaccinationDate = LocalDate.of(year, month, day);
            result.add(new Person(name, zip, age, email, taj, numberOfVaccination, lastVaccinationDate));
        }
        return result;
    }

    public List<String> loadFile(Path path) {
        try {
            return Files.readAllLines(path);
        }
        catch (IOException ioe) {
            throw new IllegalArgumentException("Can't read file!", ioe);
        }
    }
}
