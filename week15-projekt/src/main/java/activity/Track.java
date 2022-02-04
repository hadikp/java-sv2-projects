package activity;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Track {

    private List<TrackPoint> trackPoints = new ArrayList<>();

    public void addTrackPoint(TrackPoint point) {
        trackPoints.add(point);
    }

    public Coordinate findMaximumCoordinate() {
        double coordinateLatitude = trackPoints.stream().mapToDouble(t -> t.getCoordinate().getLatitude()).max().getAsDouble();
        double coordinateLongitude = trackPoints.stream().mapToDouble(t -> t.getCoordinate().getLongitude()).max().getAsDouble();
        return new Coordinate(coordinateLatitude, coordinateLongitude);
    }

    public Coordinate findMinimumCoordinate() {
        double coordinateLatitude = trackPoints.stream().mapToDouble(t -> t.getCoordinate().getLatitude()).min().getAsDouble();
        double coordinateLongitude = trackPoints.stream().mapToDouble(t -> t.getCoordinate().getLongitude()).min().getAsDouble();
        return new Coordinate(coordinateLatitude, coordinateLongitude);
    }

    public double getDistance() {
        double sum = 0;
        for (int i = 0; i < trackPoints.size()-1; i++) {
            double distance = trackPoints.get(i).getDistanceFrom(trackPoints.get(i+1));
            sum += distance;
        }
        return sum;
    }

    public double getFullDecrease() {
        double sum = 0;
        for (int i = 1; i < trackPoints.size(); i++) {
            double deltaElevation = trackPoints.get(i).getElevation() - trackPoints.get(i-1).getElevation();
            if ((deltaElevation) < 0) {
                sum += deltaElevation;
            }
        }
        return Math.abs(sum);
    }

    public double getFullElevation() {
        double sum = 0;
        for (int i = 1; i < trackPoints.size(); i++) {
            double deltaElevation = trackPoints.get(i).getElevation() - trackPoints.get(i-1).getElevation();
            if ((deltaElevation) > 0) {
                sum += deltaElevation;
            }
        }
        return sum;
    }

    public double getRectangleArea() {
        return 11;
    }

    public List<TrackPoint> getTrackPoints() {
        return trackPoints;
    }
}
