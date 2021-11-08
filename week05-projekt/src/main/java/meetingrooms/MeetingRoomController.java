package meetingrooms;

import java.util.Scanner;

public class MeetingRoomController {

    private Office office;

    public void readOffice() {
        System.out.println();
    }

    public void printMenu() {
        System.out.println();
    }

    public void runMenu() {
        System.out.println();
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("1. Tárgyaló rögzítése");
        System.out.println("2. Tárgyalók sorrendben");
        System.out.println("3. Tárgyaló visszafelé sorrendben");
        System.out.println("4. Minden második tárgyaló");
        System.out.println("5. Területek");
        System.out.println("6. Keresés pontos név alapján");
        System.out.println("7. Keresés névtöredék alapján");
        System.out.println("8. Keresés terület alapján");
        System.out.println("9. Kilépés");
    }

}
