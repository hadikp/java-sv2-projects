package meetingrooms;

import java.util.Scanner;

public class MeetingRoomController {

    private Office office = new Office();

    public void readOffice() {
        MeetingRoom fishRoom = new MeetingRoom("Bálna terem", 10, 5);
        MeetingRoom blueRoom = new MeetingRoom("Kék terem", 15, 5);
        MeetingRoom smallRoom = new MeetingRoom("Kicsi terem", 5, 2);
        MeetingRoom redRoom = new MeetingRoom("Piros terem", 7, 5);

        office.addMeetingRoom(fishRoom);
        office.addMeetingRoom(blueRoom);
        office.addMeetingRoom(smallRoom);
        office.addMeetingRoom(redRoom);
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
                break;
            case 2:
                office.printNames();
                break;
            case 3:
                office.printNamesReverse();
                break;
            case 4:
                office.printEvenNames();
                break;
            case 5:
                office.printAreas();
                break;
            case 6:
                System.out.println("Kérem a keresett tárgyaló nevét!");
                String name = sc.nextLine();
                office.printMeetingRoomsWithNames(name);
                break;
            case 7:
                System.out.println("Kérem a névtöredéket!");
                String namePart = sc.nextLine();
                office.printMeetingRoomsContains(namePart);
                break;
            case 8:
                System.out.println("Kérem a területet!");
                int area = sc.nextInt();
                sc.nextLine();
                office.printAreasLargerThan(area);
                break;
            case 9:
                System.out.println("Kilépés");
                break;
            default:
                System.out.println("Nincs ilyen menüpont. Kérem írjon be egy létező menüpontot!");

        }
        if (menuNumber != 9) {
            System.out.println();
            runMenu();
        }
    }

    public static void main(String[] args) {
        MeetingRoomController controller = new MeetingRoomController();
        controller.runMenu();
    }
}
