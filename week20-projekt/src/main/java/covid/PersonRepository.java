package covid;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

public class PersonRepository {

    private JdbcTemplate jdbcTemplate;

    public PersonRepository(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public Person loadPerson(String personName) {
        return jdbcTemplate.queryForObject("Select * from person where person_name = ?", (rs, rowNum)
                -> new Person(rs.getString("person_name"), rs.getString("zip"), rs.getInt("age"),
                rs.getString("email"), rs.getString("taj")), personName);
    }
}
