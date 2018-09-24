package collier.jordan.projects.tftpoller.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Event {

    private String groupName;
    private String date;
    private String time;
    private String day;
    private String venueName;

    public String toString() {
        return groupName + " " +
                date + " " +
                time + " " +
                venueName;
    }
}
