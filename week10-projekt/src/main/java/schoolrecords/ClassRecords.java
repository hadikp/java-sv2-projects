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
        boolean isThereDual = true;
        if (isStudentsEmpty()) {
            students.add(student);
        }
        for (Student sdt: students) {
            if ((student.getName()).equals(sdt.getName())) {
                isThereDual = false;
            }
        }
            if (isThereDual) {
                students.add(student);
            }
        return isThereDual;
    }

    public boolean removeStudent(Student student) {
        List<Student> erase = new ArrayList<>();
        for (Student sdt: students) {
            if ((student.getName()).equals(sdt.getName())) {
                erase.add(student);
            }
        }
        if (erase.size() != 0) {
            students.removeAll(erase);
            return true;
        }
        return false;
    }

    public double calculateClassAverage() {
        errorControlNoStudent();
        errorControlNoMarks();
        double sum = 0.0;
        double count = 0.0;
        for (Student std: students) {
            sum += std.calculateAverage();
            count++;
        }
        return sum / count;
    }

    public double calculateClassAverageBySubject(Subject subject) {
        errorControlNoStudent();
        errorControlNoMarks();
        double sum = 0.0;
        double count = 0.0;
        for (Student std: students) {
            double studentAverageSubject = std.calculateSubjectAverage(subject);
            if (studentAverageSubject != 0) {
                sum += studentAverageSubject;
                count++;
            }
            System.out.println(sum);
        }
        return sum / count;
    }

    public Student findStudentByName(String name) {
        if (isEmpty(name)) {
            throw new IllegalArgumentException("Student name must not be empty!");
        }
        Student result = null;
        if (students.size() == 0) {
            throw new IllegalStateException("No students to search!");
        }
        for (Student sdt: students) {
            if (sdt.getName().equals(name)) {
                result = sdt;
            }
        }
        if (result == null) {
            throw new IllegalArgumentException("Student by this name cannot be found! " + name);
        }
        return result;
    }

    public Student repetition() {
        errorControlNoStudentForRepetition();
        rnd = new Random();
        int studentNumber = rnd.nextInt(students.size()-1) + 1;
        return students.get(studentNumber);
    }

    public List<StudyResultByName> listStudyResults() {
        List<StudyResultByName> result = new ArrayList<>();
        for (Student std: students) {
            result.add(new StudyResultByName(std.getName(), std.calculateAverage()));
        }
        return result;
    }

    public String listStudentNames() {
        StringBuilder result = new StringBuilder();
        boolean first = true;
        for (Student std: students) {
            if (first) {
                first = false;
            } else {
                result.append(", ");
            }
            result.append(std.getName());
        }
        return result.toString();
    }

    public String getClassName() {
        return className;
    }

    public List<Student> getStudents() {
        return students;
    }

    private boolean isStudentsEmpty() {
        return students.size() == 0;
    }

    private void errorControlNoStudentForRepetition() {
        if (isStudentsEmpty()) {
            throw new IllegalStateException("No students to select for repetition!");
        }
    }

    private void errorControlNoStudent() {
        if (isStudentsEmpty()) {
            throw new ArithmeticException("No student in the class, average calculation aborted!");
        }
    }

    private void errorControlNoMarks() {
        int count = 0;
        for (Student std: students) {
            if (std.isMarksEmpty()) {
                count++;
            }
        }
        if (count != 0) {
            throw new ArithmeticException("No marks present, average calculation aborted!");
        }
    }

    private boolean isEmpty(String str) {
        return str.isBlank();
    }
}
