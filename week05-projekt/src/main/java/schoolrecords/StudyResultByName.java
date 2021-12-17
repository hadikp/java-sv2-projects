package schoolrecords;

public class StudyResultByName {

    private String studentName;
    private double studyAverage; //Ösztantárgyi átlaga

    public StudyResultByName(String studentName, double averageAllSubject) {
        this.studentName = studentName;
        this.studyAverage = averageAllSubject;
    }

    public String getStudentName() {
        return studentName;
    }

    public double getStudyAverage() {
        return studyAverage;
    }
}
