package covid.controller;

import java.util.Scanner;

public class MainController {

    public void printMenu() {
        System.out.println("1. Regisztráció\n" +
                "2. Tömeges regisztráció\n" +
                "3. Generálás\n" +
                "4. Oltás\n" +
                "5. Oltás meghiűsulás\n" +
                "6. Riport\n" +
                "7. Kilépés");
    }

    public void runMenu() {
        System.out.println("Melyik menüpontot választod?");
        Scanner sc = new Scanner(System.in);
        String menu = sc.nextLine();
        int menuNumber;

        try {
            menuNumber = Integer.parseInt(menu);
        }
        catch (NumberFormatException nfe) {
            throw new NumberFormatException("Nem számot adtál meg!");
        }

        switch (menuNumber) {
            case 1:
                System.out.println("1-es menű megy");
                break;
            case 2:
                System.out.println("2-es menű megy");
                break;
            case 3:
                System.out.println("3-es menű megy");
                break;
            case 4:
                System.out.println("4-es menű megy");
                break;
            case 5:
                System.out.println("5-es menű megy");
                break;
            case 6:
                System.out.println("6-es menű megy");
                break;
            case 7:
                System.out.println("Kilépés");
                break;
            default:
                System.out.println("Nincs ilyen menüpont. Kérem írjon be egy létező menüpontot!");
        }
        if (menuNumber != 7) {
            System.out.println();
            runMenu();
        }

    }

    public static void main(String[] args) {
        MainController mainController = new MainController();
        mainController.printMenu();
        mainController.runMenu();

    }
}
