import java.util.List;

public class Validators {

    public static boolean isBlank(String text) {
        if (text == null) {
            return true;
        }
        if (text.isBlank()) {
            return true;
        }
        return false;
    }

    public static boolean isEmpty(List<String> list) {
        if (list == null) {
            return true;
        }
        if (list.isEmpty()) {
            return true;
        }
        return false;
    }
}
