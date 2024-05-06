public class SnickersHandler extends SnackHandler {
    public SnickersHandler(SnackHandler next) {
        super(next);
    }
    public void handleRequest(String requestType) {
        if(requestType.equals("Snickers")) {
            System.out.println("Handling digest authentication request");
        } else {
            System.out.println("I was passed from Kitkats");
            super.handleRequest(requestType);
        }
    }
}
