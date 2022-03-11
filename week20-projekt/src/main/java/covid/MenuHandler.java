package covid;

import covid.repository.PersonRepository;
import covid.repository.ZipRepository;
import org.mariadb.jdbc.MariaDbDataSource;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Scanner;

public class MenuHandler {

    MariaDbDataSource dataSource = new MariaDbDataSource();
    private ZipRepository zipRepository = new ZipRepository(dataSource);
    private PersonRepository personRepository = new PersonRepository(dataSource);

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
        System.out.println("Kérem a TAJ számodat!");
        String taj = sc.nextLine();
        System.out.println("Hányszor oltottak be?");
        int vaccinaNumber = sc.nextInt();
        sc.nextLine();
        personRepository.insertPersonList(new Person(name, zip, age, email, taj, vaccinaNumber, LocalDate.now()));
    }
}
