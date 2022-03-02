package covid;

public class Validation {

    public void validateName(String name) {
        if(name.isBlank() || name.length() == 0) {
            throw new IllegalArgumentException("Name can't be empty or null!");
        }
        /*if(name == null) {
            throw new NullPointerException("Name can't be null!");
        }*/
    }
}
