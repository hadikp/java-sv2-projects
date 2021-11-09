package meetingrooms;

import java.util.Scanner;

public class MeetingRoomController {

    private Office office = new Office();

    public void readOffice() {
        MeetingRoom fishRoom = new MeetingRoom("Bálna terem", 10, 5);
        MeetingRoom blueRoom = new MeetingRoom("Kék terem", 15, 5);
        MeetingRoom smallRoom = new MeetingRoom("Kicsi terem", 5, 2);
        MeetingRoom redRoom = new MeetingRoom("Piros terem", 7, 5);

        office.addMeetengRoom(fishRoom);
        office.addMeetengRoom(blueRoom);
        office.addMeetengRoom(smallRoom);
        office.addMeetengRoom(redRoom);

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
        sc.nextLine();

        switch (menuNumber) {
            case 1:
                System.out.println("1-es menü végrehajtva, tárgyalók rögzítve.");
                readOffice();
                System.out.println();
                runMenu();
                break;
            case 2:
                office.printNames();
                System.out.println();
                runMenu();
                break;
            case 3:
                office.printNamesReverse();
                System.out.println();
                runMenu();
                break;
            case 4:
                office.printEvenNames();
                System.out.println();
                runMenu();
                break;
            case 5:
                office.printAreas();
                System.out.println();
                runMenu();
                break;
            case 6:
                System.out.println("Kérem a keresett tárgyaló nevét!");
                String name = sc.nextLine();
                office.printMeetingRoomsWithNames(name);
                System.out.println();
                runMenu();
                break;
            case 7:
                System.out.println("Kérem a névtöredéket!");
                String namePart = sc.nextLine();
                office.printMeetingRoomsContains(namePart);
                runMenu();
                break;
            case 8:
                System.out.println("Kérem a területet!");
                int area = sc.nextInt();
                sc.nextLine();
                office.printAreasLargerThan(area);
                System.out.println();
                runMenu();
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
