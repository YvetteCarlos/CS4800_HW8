public class CokeHandler extends SnackHandler {
    public CokeHandler(SnackHandler next) {
        super(next);
    }
    public void handleRequest(String requestType) {
        if(requestType.equals("Coke")) {
            System.out.println("Handling basic authentication request");
        } else {
            System.out.println("I was passed from SnackHandler");
            super.handleRequest(requestType);
        }
    }
}
