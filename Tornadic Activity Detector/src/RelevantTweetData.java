import twitter4j.GeoLocation;
import twitter4j.Place;

import java.util.Date;

public class RelevantTweetData {
    private String text;
    private String fromUser;
    private Date createdAt;
    private Place place;
    private String annotate;
    private String tornadoLevel;
    private String seenTornado;
    private String aboutTornado;
    private String location;
    private GeoLocation geoLocation;
    private long Id;

    public long getId(){
        return Id;
    }
    public void setId(long Id){
        this.Id = Id;
    }
    public String getTornadoLevel() {
        return tornadoLevel;
    }

    public void setTornadoLevel(String tornadoLevel) {
        this.tornadoLevel = tornadoLevel;
    }
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getAboutTornado() {
        return aboutTornado;
    }

    public void setAboutTornado(String aboutTornado) {
        this.aboutTornado = aboutTornado;
    }

    public String getSeenTornado() {
        return seenTornado;
    }

    public void setSeenTornado(String seenTornado) {
        this.seenTornado = seenTornado;
    }

    public String getAnnotate() {
        return annotate;
    }

    public void setAnnotate(String annotate) {
        this.annotate = annotate;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getFromUser() {
        return fromUser;
    }

    public void setFromUser(String fromUser) {
        this.fromUser = fromUser;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }


    public void setGeoLocation(GeoLocation geoLocation) {
        this.geoLocation = geoLocation;
    }

    public GeoLocation getGeoLocation() {
        return geoLocation;
    }
}
