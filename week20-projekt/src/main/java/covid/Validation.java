package covid;

public class Validation {

    public void validateName(String name) {
        if(name.isBlank() || name.length() == 0 || name == null) {
            throw new IllegalArgumentException("Name can't be empty or null!");
        }
    }
}
