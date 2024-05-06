public class KitKatsHandler extends SnackHandler {
    public KitKatsHandler(SnackHandler next) {
        super(next);
    }
    public void handleRequest(String requestType) {
        if(requestType.equals("KitKats")) {
            System.out.println("Handling digest authentication request");
        } else {
            System.out.println("I was passed from Doritos");
            super.handleRequest(requestType);
        }
    }
}

