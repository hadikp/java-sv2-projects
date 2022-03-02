package covid;

public class Zip {

    private String townName;
    private String zip;

    public Zip(String townName, String zip) {
        this.townName = townName;
        this.zip = zip;
    }

    public String getTownName() {
        return townName;
    }

    public String getZip() {
        return zip;
    }

    @Override
    public String toString() {
        return "'" + townName + '\'' +
                ", zip='" + zip + '\'' +
                ';';
    }
}
