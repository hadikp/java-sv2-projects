package meetingrooms;

import java.util.Scanner;
import java.util.SortedMap;

public class MeetingRoomController {

    private Office office = new Office();

    public void readOffice() {
        MeetingRoom fishRoom = new MeetingRoom("Bálna terem", 10, 5);
        MeetingRoom blueRoom = new MeetingRoom("Kék terem", 15, 5);
        MeetingRoom smallRoom = new MeetingRoom("Kicsi terem", 5, 2);

        office.addMeetengRoom(fishRoom);
        office.addMeetengRoom(blueRoom);
        office.addMeetengRoom(smallRoom);

        runMenu();
    }

    public void printMenu() {
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

    public void runMenu() {
        printMenu(); //kiírja a menüt
        Scanner sc = new Scanner(System.in);
        System.out.println("Melyik menüt hajtsam végre?");
        int menuNumber = sc.nextInt();
        switch (menuNumber) {
            case 1:
                System.out.println("1-es menü");
                readOffice();
                break;
            case 2:
                System.out.println("2-es menü");
                office.printNames();
                break;
            case 3:
                System.out.println("3-es menü");
                break;
            case 4:
                System.out.println("4-es menü");
                break;
            case 5:
                System.out.println("5-es menü");
                break;
            case 6:
                System.out.println("6-es menü");
                break;
            case 7:
                System.out.println("7-es menü");
                break;
            case 8:
                System.out.println("8-es menü");
                break;
            case 9:
                System.out.println("Kilépés");
                break;
            default:
                System.out.println("Nincs ilyen menüpont. Kérem írjon be egy létező menüpontot!");
                runMenu();
        }
    }


    public static void main(String[] args) {
        MeetingRoomController controller = new MeetingRoomController();
        controller.runMenu();


    }

}
