package covid;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

public class ZipRepository {

    private JdbcTemplate jdbcTemplate;

    public ZipRepository(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void insertZip(List<Zip> zipList) {
        for (int i = 0; i < zipList.size(); i++) {
            String townName = zipList.get(i).getTownName();
            String zip = zipList.get(i).getZip();
            jdbcTemplate.update("Insert into zip(town_name, zip) values(?,?)", townName, zip);
        }

    }

    public String loadZip(String townName) {
        return jdbcTemplate.queryForObject("Select * from zip where town_name = ?", (rs, rowNum)
                -> rs.getString("zip"), townName);
    }

}
