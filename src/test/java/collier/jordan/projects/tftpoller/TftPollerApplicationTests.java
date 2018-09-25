package collier.jordan.projects.tftpoller;

import collier.jordan.projects.tftpoller.logic.ResponseProcessor;
import collier.jordan.projects.tftpoller.model.Event;
import collier.jordan.projects.tftpoller.model.exception.NoTicketsAvailable;
import org.jsoup.Jsoup;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;

@RunWith(SpringRunner.class)
public class TftPollerApplicationTests {

    Event event_1;

    @Before
    public void setUp() {
	    event_1 = new Event();
	    event_1.setGroupName("Rock For Heroes");
	    event_1.setVenueName("Civic Hall - Bedworth, Bedworth");
	    event_1.setTime("at 7:30 PM");
	    event_1.setDate("Sat 06 Oct 2018");
    }

    @Test
	public void responseProcessortest() throws IOException, NoTicketsAvailable {
        ResponseProcessor document = new ResponseProcessor(
                Jsoup.parse(new File("src/test/resources/Search_TicketsforTroops.html"), "UTF-8")
        );

        Event testEvent = document.getEvents().get(0);

        assertEquals(event_1.toString(), testEvent.toString());
	}

	@Test
    public void noTicketsAvailableTest() throws IOException {
        ResponseProcessor document = new ResponseProcessor(
                Jsoup.parse(new File("src/test/resources/Search_TicketsForTroopsNoTicketsAvailable.html"), "UTF-8")
        );
        try {
            document.getEvents();
        } catch(NoTicketsAvailable e) {
           assertEquals("No tickets avalable for group.", e.getMessage());
        }
    }
}
