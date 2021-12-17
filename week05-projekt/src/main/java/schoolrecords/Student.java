package schoolrecords;

public class Student {

    private String name;
    private Mark mark;

    public Student(String name) {
        this.name = name;
    }

    public void grading(Mark mark) { // érdemjegy rögzítése
        System.out.println();
    }

    public double calculateAverage() { // teljes átlag számolása
        return 12.3;
    }

    public double calculateSubjectAverage(Subject subject) { // tantárgyhoz tartozó átlag számítása
        return 11.5;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", mark=" + mark +
                '}';
    }

    public String getName() {
        return name;
    }
}
