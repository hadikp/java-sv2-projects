package schoolrecords;

import java.util.*;

public class SchoolRecordsController {

    private ClassRecords classRecords = new ClassRecords("Basic School B", new Random());;
    private List<Subject> subjects = new ArrayList<>();
    private List<Tutor> tutors = new ArrayList<>();

    public void initSchool() {
        subjects = Arrays.asList(new Subject("kémia"),
                                new Subject("fizika"),
                                new Subject("matematika"),
                                new Subject("biológia"));
        tutors = Arrays.asList(new Tutor("Dezső", subjects), new Tutor("Jenő", subjects));
        Student peterStudent = new Student("Hadik Péter");
        Student jozsiStudent = new Student("Piros József");
        Student ritaStudent = new Student("Kovács Rita");
        Student elekStudent = new Student("Mekk Elek");
        peterStudent.grading(new Mark(MarkType.A, new Subject("kémia"), tutors.get(0)));

        classRecords.addStudent(peterStudent);
        classRecords.addStudent(jozsiStudent);
        classRecords.addStudent(ritaStudent);
    }

    public void runMenu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Melyik menüt kéred?");
        String menu = sc.nextLine();
        int menuNumber;
        try {
            menuNumber = Integer.parseInt(menu);
        }
        catch (NumberFormatException nfe) {
            throw new NumberFormatException("Nem számot adtál meg!");
        }
        switch (menuNumber) {
            case 1:
                listStudentNames();
                break;
            case 2:
                System.out.println("Kérem a diák nevét!");
                String studentName = sc.nextLine();
                findStudentByName(studentName);
                break;
            default:
                System.out.println("Nincs ilyen menüpont. Kérem írjon be egy létező menüpontot!");

        }
        if (menuNumber != 9) {
            System.out.println();
            runMenu();
        }

    }

    private void findStudentByName(String studentName) {
        classRecords.findStudentByName(studentName);
    }


    private void listStudentNames() { //1.es menu
        System.out.println(classRecords.listStudentNames());

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
