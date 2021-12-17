package schoolrecords;

import java.util.ArrayList;
import java.util.List;

public class Tutor {

    private String name;
    private List<Subject> subjects = new ArrayList<>();

    public Tutor(String name, List<Subject> subjects) {
        this.name = name;
        this.subjects = subjects;
    }

    public boolean tutorTeachingSubject(Subject subject) {
        for (Subject sbt: subjects) {
            if ((subject.getSubjectName()).equals(sbt.getSubjectName())) {
                return true;
            }
        }
        return false;
    }

    public String getName() {
        return name;
    }

    /*public List<Subject> getSubjects() {
        return new ArrayList<>(subjects);
    }*/
}
