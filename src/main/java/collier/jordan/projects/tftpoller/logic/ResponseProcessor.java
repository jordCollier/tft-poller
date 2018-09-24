package collier.jordan.projects.tftpoller.logic;

import collier.jordan.projects.tftpoller.model.Event;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.net.URI;
import java.util.ArrayList;

@Slf4j
@Setter
public class ResponseProcessor {

    private Document html;

    public ResponseProcessor(URI resource) {
        this.html = new Document(resource.toString());
    }

    public ResponseProcessor(Document document) {
        this.html = document;
    }

    public ArrayList<Event> getEvents() {
        ArrayList<Event> events = new ArrayList<>();

        Element searchResult = html.getElementById("search-results");

        for(Element listElement : searchResult.getAllElements()) {
            for (Element eventElement : listElement.getElementsByTag("li")) {
                Elements detailElement = eventElement.getElementsByClass("details");
                Event event = new Event();

                event.setGroupName(detailElement.select("h2").text());
                event.setTime(detailElement.select("span").text());
                event.setDate(eventElement.getElementsByClass("date").text());
                event.setVenueName(detailElement.select("h3").text());

                events.add(event);
            }
        }
        return events;
    }
}

