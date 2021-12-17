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
        return true;
    }

    public String getName() {
        return name;
    }

    public List<Subject> getSubjects() {
        return new ArrayList<>(subjects);
    }
}
