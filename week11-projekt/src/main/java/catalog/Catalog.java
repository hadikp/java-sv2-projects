package catalog;

import java.util.ArrayList;
import java.util.List;

public class Catalog {

    private List<CatalogItem> catalogItems = new ArrayList<>();

    public void addItem(CatalogItem catalogItem) {
        catalogItems.add(catalogItem);
    }

    public double averagePageNumberOver(int input) {
        System.out.println();
        return 11.4;
    }

    public void deleteItemByRegistrationNumber(String regNumber) {
        System.out.println();
    }

    public List<CatalogItem> findByCriteria(SearchCriteria searchCriteria) {
        List<CatalogItem> result = new ArrayList<>();
        System.out.println();
        return result;
    }

    public List<CatalogItem> getAudioLibraryItems() {
        List<CatalogItem> result = new ArrayList<>();
        System.out.println();
        return result;
    }

    public List<CatalogItem> getPrintedLibraryItems() {
        List<CatalogItem> result = new ArrayList<>();
        System.out.println();
        return result;
    }

    public int getAllPageNumber() {
        for (CatalogItem ci: catalogItems) {
            System.out.println(ci.numberOfPagesAtOneItem());
        }
        return 11;
    }

    public int getFullLength() {
        System.out.println();
        return 11;
    }


    public List<CatalogItem> getCatalogItems() {
        return catalogItems;
    }
}
