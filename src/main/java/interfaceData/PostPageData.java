package interfaceData;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.joda.time.LocalDateTime;

public class PostPageData {

    LocalDateTime dateTime;
    String user;
    String title;
    String publication;

    public PostPageData() {
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublication() {
        return publication;
    }

    public void setPublication(String publication) {
        this.publication = publication;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("dateTime", dateTime)
                .append("user", user)
                .append("title", title)
                .append("publication", publication)
                .toString();
    }
}
