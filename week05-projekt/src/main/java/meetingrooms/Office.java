package meetingrooms;

import java.util.ArrayList;
import java.util.List;

public class Office {
    private List<MeetingRoom> meetingRooms = new ArrayList<>();

    public void addMeetingRoom(MeetingRoom meetingRoom) {
        meetingRooms.add(meetingRoom);
    }

    public void printNames() {
        System.out.println("Tárgyalók nevei:");
        for (MeetingRoom mr: meetingRooms) {
            System.out.println(mr.getName());
        }
    }

    public void printNamesReverse() {
        System.out.println("Tárgyalók nevei visszafelé sorrendben:");
        for (int i = meetingRooms.size()-1; i >= 0; i--) {
            System.out.println(meetingRooms.get(i).getName());
        }
    }

    public void printEvenNames() {
        System.out.println("Minden második tárgyaló neve:");
        for (int i = 1; i < meetingRooms.size(); i += 2) {
            System.out.println(meetingRooms.get(i).getName());
        }
    }

    public void printAreas() {
        for (MeetingRoom mr: meetingRooms) {
            String area = String.format("A tárgyaló neve: %s, szélessége: %d m, hosszúsága: %d m, területe: %d m2", mr.getName(), mr.getWidth(), mr.getLength(), mr.getArea());
            System.out.println(area);
        }
    }

    public void printMeetingRoomsWithNames(String name) {
        for (MeetingRoom mr: meetingRooms) {
            if (mr.getName().equals(name)) {
                String nameRoom = String.format("A keresett tárgyaló szélessége: %d m, hosszúsága: %d m, területe: %d m2", mr.getWidth(), mr.getLength(), mr.getArea());
                System.out.println(nameRoom);
            }
        }
    }

    public void printMeetingRoomsContains(String part) {
        for (MeetingRoom mr: meetingRooms) {
            if (mr.getName().toLowerCase().contains(part.toLowerCase())) {
                String nameRoom = String.format("A keresett tárgyaló neve: %s, szélessége: %d m, hosszúsága: %d m, területe: %d m2",mr.getName(), mr.getWidth(), mr.getLength(), mr.getArea());
                System.out.println(nameRoom);
                System.out.println();
            }
        }
    }

    public void printAreasLargerThan(int area) {
        for (MeetingRoom mr: meetingRooms) {
            if (mr.getArea() > area) {
                String nameRoom = String.format("A keresett tárgyaló neve: %s, szélessége: %d m, hosszúsága: %d m, területe: %d m2",mr.getName(), mr.getWidth(), mr.getLength(), mr.getArea());
                System.out.println(nameRoom);
            }
        }
    }
}
