package covid;

public class Person {

    private String name;
    private String postCode;
    private int age;
    private String email;
    private String taj;
    private Validation validation = new Validation();

    public Person(String name, String postCode, int age, String email, String taj) {
        validation.validateName(name);
        this.name = name;
        this.postCode = postCode;
        this.age = age;
        this.email = email;
        this.taj = taj;
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
