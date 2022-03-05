package covid.repository;

import covid.Person;
import covid.Zip;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

public class PersonRepository {

    private JdbcTemplate jdbcTemplate;

    public PersonRepository(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public Person loadPerson(String personName) {
        return jdbcTemplate.queryForObject("Select * from persons where person_name = ?", (rs, rowNum)
                -> new Person(rs.getString("person_name"), rs.getString("zip"), rs.getInt("age"),
                rs.getString("email"), rs.getString("taj"), rs.getInt("number_of_vaccination"),
                rs.getDate("last_vaccination_date").toLocalDate()), personName);
    }

    public void insertPersonList(Person... persons) {
        for (Person p: persons) {
            String name = p.getName();
            String zip = p.getPostCode();
            int age = p.getAge();
            String email = p.getEmail();
            String taj = p.getTaj();
            jdbcTemplate.update("Insert into persons(person_name, zip, age, email, taj) values(?,?,?,?,?)", name, zip, age, email, taj);
        }
    }
}
