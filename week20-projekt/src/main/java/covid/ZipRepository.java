package covid;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

public class ZipRepository {

    private JdbcTemplate jdbcTemplate;

    public ZipRepository(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public String loadZip(String townName) {
        return jdbcTemplate.queryForObject("Select * from zip where town_name = ?", (rs, rowNum)
                -> rs.getString("zip"), townName);
    }
}
