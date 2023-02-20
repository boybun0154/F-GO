package entity;

public class Location {
    private String acc;
    private Double lat;
    private Double lng;

    public Location(String acc, Double lat, Double lng) {
        this.acc = acc;
        this.lat = lat;
        this.lng = lng;
    }

    public String getAcc() {
        return acc;
    }

    public void setAcc(String acc) {
        this.acc = acc;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }

}
