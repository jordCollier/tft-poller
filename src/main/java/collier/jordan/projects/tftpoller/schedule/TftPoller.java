package collier.jordan.projects.tftpoller.schedule;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class TftPoller {

    @Scheduled(cron = "${scheduler.cronValue}")
    public void pollTft() {
    //#TODO Schedule the polling job with get request as seen below and cast to Document object
        //#TODO or poll TFT using URI.
    }

    public String sendGetrequest(String groupName) {
        RestTemplate rt = new RestTemplate();

         return rt.getForObject("https://www.ticketsfortroops.org.uk/search?q={groupName}",
                String.class,
                groupName);
    }
}
