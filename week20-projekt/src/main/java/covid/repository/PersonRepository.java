package covid.repository;

import covid.Person;
import covid.Zip;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.security.Timestamp;
import java.time.LocalDate;
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
}
