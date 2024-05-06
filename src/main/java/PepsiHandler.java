public class PepsiHandler extends SnackHandler {
    public PepsiHandler(SnackHandler next) {
        super(next);
    }
    public void handleRequest(String requestType) {
        if(requestType.equals("Pepsi")) {
            System.out.println("Handling digest authentication request");
        } else {
            System.out.println("I was passed from Coke");
            super.handleRequest(requestType);
        }
    }
}

