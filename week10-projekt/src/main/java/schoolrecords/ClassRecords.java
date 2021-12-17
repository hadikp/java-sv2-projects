package schoolrecords;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ClassRecords {

    private String className;
    private Random rnd;
    private List<Student> students = new ArrayList<>();

    public ClassRecords(String className, Random rnd) {
        this.className = className;
        this.rnd = rnd;
    }

    public boolean addStudent(Student student) {
        return true;
    }

    public boolean removeStudent(Student student) {
        return true;
    }

    public double calculateClassAverage() {
        return 11.5;
    }

    public double calculateClassAverageBySubject(Subject subject) {
        return 11.5;
    }

    public Student findStudentByName(String name) {
        Student result = null;
        for (Student sdt: students) {
            if (sdt.getName().equals(name)) {
                return sdt;
            }
        }
        return result;
    }

    public Student repetition() {
        rnd = new Random();
        int studentNumber = rnd.nextInt(students.size()) + 1;
        return students.get(studentNumber);
    }

    public List<StudyResultByName> listStudyResults() {
        List<StudyResultByName> result = new ArrayList<>();
        return result;
    }

    public String listStudentNames() {
        return "Név";
    }

    public String getClassName() {
        return className;
    }
}
