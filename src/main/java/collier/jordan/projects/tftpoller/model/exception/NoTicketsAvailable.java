package collier.jordan.projects.tftpoller.model.exception;

public class NoTicketsAvailable extends  Throwable {
    private String message;

    public NoTicketsAvailable(String message) {
        super();

        this.message = message;
    }

    @Override
    public String getMessage() {
        return this.message;
    }


}
