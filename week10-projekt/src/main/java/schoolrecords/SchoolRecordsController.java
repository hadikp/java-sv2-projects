package schoolrecords;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class SchoolRecordsController {

    private ClassRecords classRecords = new ClassRecords("Basic School B", new Random());;
    private List<Subject> subjects = new ArrayList<>();
    private List<Tutor> tutors = new ArrayList<>();

    public void initSchool() {
        subjects = Arrays.asList(new Subject("kémia"), new Subject("fizika"),
                            new Subject("matematika"), new Subject("biológia"));
        tutors = Arrays.asList(new Tutor("Dezső", subjects), new Tutor("Jenő", subjects));
    }

    public void runMenu() {
        System.out.println("Melyik menüt kéred?");
    }

    public void printMenu() {
        System.out.println("1. Diákok nevének listázása\n" +
                            "2. Diák név alapján keresése\n" +
                            "3. Diák létrehozása\n" +
                            "4. Diák név alapján törlése\n" +
                            "5. Diák feleltetése\n" +
                            "6. Osztályátlag kiszámolása\n" +
                            "7. Tantárgyi átlag kiszámolása\n" +
                            "8. Diákok átlagának megjelenítése\n" +
                            "9. Diák átlagának kiírása\n" +
                            "10. Diák tantárgyhoz tartozó átlagának kiírása\n" +
                            "11. Kilépés");
    }

    public static void main(String[] args) {
        SchoolRecordsController src = new SchoolRecordsController();
        src.initSchool();
        src.printMenu();
        src.runMenu();

    }

}
