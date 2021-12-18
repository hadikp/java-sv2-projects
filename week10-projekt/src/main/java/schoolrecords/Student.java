package schoolrecords;

import java.util.ArrayList;
import java.util.List;

public class Student {

    private String name;
    private List<Mark> marks = new ArrayList<>();

    public Student(String name) {
        if (isEmpty(name)) {
            throw new IllegalArgumentException("Student name must not be empty!");
        }
        this.name = name;
    }

    public void grading(Mark mark) { // érdemjegy rögzítése
        if (mark == null) {
            throw new NullPointerException("Mark must not be null!");
        }
        marks.add(mark);
    }

    public double calculateAverage() { // teljes átlag számolása
        double sum = 0.0;
        for (Mark m: marks) {
            sum += m.getMarkType().getValueMark();
        }
        if (isMarksEmpty()) {
            return sum;
        }
        return sum / marks.size();
    }

    public double calculateSubjectAverage(Subject subject) { // tantárgyhoz tartozó átlag számítása
        double sum = 0.0;
        int count = 0;
        for (Mark m: marks) {
            if ((subject).equals(m.getSubject())) {
                sum += m.getMarkType().getValueMark();
                count++;
            } else {
                count = 1;
            }
        }
        if (isMarksEmpty()) {
            return sum;
        }
        return sum / count;
    }

    @Override
    public String toString() {
        String print = "";
        for (Mark m: marks) {
            print = name + " marks: " + m.getSubject().getSubjectName() + ": " + m.getMarkType().getTextMark() +
                    "(" + m.getMarkType().getValueMark() + ")";
        }
        return print;
    }

    public String getName() {
        return name;
    }

    public boolean isMarksEmpty() { //használom a ClassRecords-ban is
        if (marks.size() == 0) {
            return true;
        }
        return false;
    }

    private boolean isEmpty(String str) {
        return str.isBlank();
    }
}
