package schoolrecords;

import java.util.*;

public class SchoolRecordsController {

    private ClassRecords classRecords = new ClassRecords("Basic School B", new Random());;
    private List<Subject> subjects = new ArrayList<>();
    private List<Tutor> tutors = new ArrayList<>();

    Student elekStudent;

    public void initSchool() {
        subjects = Arrays.asList(new Subject("kémia"),
                                new Subject("fizika"),
                                new Subject("matematika"),
                                new Subject("biológia"));
        tutors = Arrays.asList(new Tutor("Dezső", subjects), new Tutor("Jenő", subjects));
        Student peterStudent = new Student("Hadik Péter");
        Student jozsiStudent = new Student("Piros József");
        Student ritaStudent = new Student("Kovács Rita");
        elekStudent = new Student("Mekk Elek");
        peterStudent.grading(new Mark(MarkType.A, new Subject("kémia"), tutors.get(0)));
        peterStudent.grading(new Mark(MarkType.A, new Subject("földrajz"), tutors.get(0)));
        jozsiStudent.grading(new Mark(MarkType.B, new Subject("fizika"), tutors.get(1)));
        ritaStudent.grading(new Mark(MarkType.A, new Subject("biológia"), tutors.get(0)));
        elekStudent.grading(new Mark(MarkType.D, new Subject("biológia"), tutors.get(0)));

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
            case 3:
                makeStudent(elekStudent);
                break;
            case 4:
                System.out.println("Kérem a törölni kívánt diák nevét!");
                String studentNameDelete = sc.nextLine();
                removeStudent(studentNameDelete);
                break;
            case 5:
                replyStudent();
                break;
            case 6:
                countClassAverage();
                break;
            case 7:
                Subject geography = new Subject("földrajz");
                //System.out.println("Milyen tantárgy átlaga érdekel?");
                //String subjectName = sc.nextLine();
                makeSubjectAverage(geography);
                break;
            case 8:
                //countClassAverage();
                break;
            case 9:
                //countClassAverage();
                break;
            case 10:
                //countClassAverage();
                break;
            case 11:
                System.out.println("Kiléptél a menüből!");
                break;
            default:
                System.out.println("Nincs ilyen menüpont. Kérem írjon be egy létező menüpontot!");

        }
        if (menuNumber != 11) {
            System.out.println();
            runMenu();
        }

    }

    //Még nincs kész
    private void makeSubjectAverage(Subject subject) { //7.es menu: Tantárgyi átlag kiszámolása
        System.out.println(classRecords.calculateClassAverageBySubject(subject));
    }

    private void countClassAverage() { //6.os menu: Osztályátlag kiszámolása
        System.out.println(classRecords.calculateClassAverage());

    }

    //Még nincs kész
    private void replyStudent() {//5.ös menu: Diák feleltetése
        System.out.println(classRecords.repetition());

    }

    private void removeStudent(String studentNameDelete) { //4.es menu: Diák név alapján törlése
        Student deleteStudent = classRecords.findStudentByName(studentNameDelete);
        classRecords.removeStudent(deleteStudent);
    }

    //Még nincs kész
    private void makeStudent(Student elekStudent) { //3.es menu: Diák létrehozása
        classRecords.addStudent(elekStudent);
    }


    private void findStudentByName(String studentName) { //2.es menu: Diák név alapján keresése
        classRecords.findStudentByName(studentName);
    }


    private void listStudentNames() { //1.es menu: Diákok nevének listázása
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
