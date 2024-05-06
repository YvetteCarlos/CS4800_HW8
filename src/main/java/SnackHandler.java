public abstract class SnackHandler {
    private SnackHandler next;
    public SnackHandler(SnackHandler next) {
        this.next = next;
    }
    public void handleRequest(String requestType) {
        if(next != null) {
            next.handleRequest(requestType);
        }
    }
}


