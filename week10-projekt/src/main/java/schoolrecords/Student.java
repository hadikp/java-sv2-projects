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

    private boolean isEmpty(String str) {
        return str.isBlank();
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
        if (isMarksEmpty(sum)) {
            return sum;
        }
        return sum / marks.size();
    }

    private boolean isMarksEmpty(double sum) {
        if (marks.size() == 0) {
            return true;
        }
        return false;
    }


    public double calculateSubjectAverage(Subject subject) { // tantárgyhoz tartozó átlag számítása
        double sum = 0.0;
        int count = 0;
        for (Mark m: marks) {
            if ((subject.getSubjectName()).equals(m.getSubject().getSubjectName())) {
                sum += m.getMarkType().getValueMark();
                count++;
            } else {
                count = 1;
            }
        }
        if (isMarksEmpty(sum)) {
            return sum;
        }
        return sum / count;
    }

    @Override
    public String toString() {
        return name + " marks: " + marks.get(0).getSubject().getSubjectName() + ": " + marks.get(0);
    }

    public String getName() {
        return name;
    }
}
