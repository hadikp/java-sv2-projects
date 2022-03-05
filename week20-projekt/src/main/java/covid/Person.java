package covid;

import java.time.LocalDate;

public class Person {

    private String name;
    private String postCode;
    private int age;
    private String email;
    private String taj;
    private int numberOfVaccination;
    private LocalDate lastVaccinationDate;
    private Validation validation = new Validation();

    public Person(String name, String postCode, int age, String email, String taj, int numberOfVaccination, LocalDate lastVaccinationDate) {
        validation.validateName(name);
        this.name = name;
        this.postCode = postCode;
        this.age = age;
        this.email = email;
        this.taj = taj;
        this.numberOfVaccination = numberOfVaccination;
        this.lastVaccinationDate = lastVaccinationDate;
    }

    public String getName() {
        return name;
    }

    public String getPostCode() {
        return postCode;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public String getTaj() {
        return taj;
    }

    public int getNumberOfVaccination() {
        return numberOfVaccination;
    }

    public LocalDate getLastVaccinationDate() {
        return lastVaccinationDate;
    }

    @Override
    public String toString() {
        return name +
                ", postCode='" + postCode + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", taj='" + taj + '\'' +
                "\n";
    }
}
