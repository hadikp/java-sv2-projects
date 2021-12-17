package schoolrecords;

public class Student {

    private String name;
    private Mark mark;

    public Student(String name) {
        if (isEmpty(name)) {
            throw new IllegalArgumentException("Student name must not be empty!");
        }
        this.name = name;
    }

    private boolean isEmpty(String str) {
        return str.isBlank();
    }

    public void grading(Mark mark) { // érdemjegy rögzítése
        if (mark == null) {
            throw new NullPointerException("Mark must not be null!");
        }
        this.mark = mark;
    }

    public double calculateAverage() { // teljes átlag számolása
        return 12.3;
    }

    public double calculateSubjectAverage(Subject subject) { // tantárgyhoz tartozó átlag számítása
        return 11.5;
    }

    @Override
    public String toString() {
        return name + " marks: " + mark.getSubject().getSubjectName() + ": " + mark;
    }

    public String getName() {
        return name;
    }
}
