public class DoritosHandler extends SnackHandler {
    public DoritosHandler(SnackHandler next) {
        super(next);
    }
    public void handleRequest(String requestType) {
        if(requestType.equals("Doritos")) {
            System.out.println("Handling digest authentication request");
        } else {
            System.out.println("I was passed from Cheetos");
            super.handleRequest(requestType);
        }
    }
}

