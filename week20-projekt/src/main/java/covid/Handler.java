package covid;

import covid.repository.ZipRepository;
import org.mariadb.jdbc.MariaDbDataSource;

import java.sql.SQLException;
import java.util.Scanner;

public class Handler {

    MariaDbDataSource dataSource = new MariaDbDataSource();
    private ZipRepository zipRepository = new ZipRepository(dataSource);

    public void PersonRegistration() {
        try {
            dataSource.setUrl("jdbc:mariadb://localhost:3306/covid?useUnicode=true");
            dataSource.setUser("covid");
            dataSource.setPassword("covid");
        } catch (
                SQLException sqle) {
            throw new IllegalStateException("Cannot reach DataBase!", sqle);
        }
        Scanner sc = new Scanner(System.in);
        System.out.println("Kérem a neved!");
        String name = sc.nextLine();
        System.out.println("Kérem a lakóhelyed!");
        String town = sc.nextLine();
        String zip = zipRepository.loadZip(town);
        System.out.println("A városod irányítószáma: " + zip);
        System.out.println("Hány éves vagy?");
        int age = sc.nextInt();
        sc.nextLine();
        System.out.println("Kérem az email címed!");
        String email = sc.nextLine();
        System.out.println("Kérem a TAj számodat!");
        String taj = sc.nextLine();
    }
}
