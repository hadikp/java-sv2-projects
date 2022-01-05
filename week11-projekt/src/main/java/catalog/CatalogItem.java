package catalog;

import java.util.ArrayList;
import java.util.List;

public class CatalogItem {

    private List<Feature> features = new ArrayList<>();
    private final int price;
    private final String registrationNumber;

    public CatalogItem(String registrationNumber, int price, List<Feature> features) {
        this.features = features;
        this.price = price;
        this.registrationNumber = registrationNumber;
    }

    public int fullLengthAtOneItem() {
        return 11;
    }

    public List<String> getContributors() {
        return null;
    }

    public List<String> getTitles() {
        return null;
    }

    public boolean hasAudioFeature() {
        return true;
    }

    public boolean hasPrintedFeature() {
        return true;
    }

    public int numberOfPagesAtOneItem() {
        return 11;
    }

    public List<Feature> getFeatures() {
        return features;
    }

    public int getPrice() {
        return price;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }
}
