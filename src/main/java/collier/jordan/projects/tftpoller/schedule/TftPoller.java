package collier.jordan.projects.tftpoller.schedule;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class TftPoller {

    @Scheduled(cron = "${scheduler.cronValue}")
    public void pollTft() {

    }

    public String sendGetrequest(String groupName) {
        RestTemplate rt = new RestTemplate();

         return rt.getForObject("https://www.ticketsfortroops.org.uk/search?q={groupName}",
                String.class,
                groupName);
    }
}
