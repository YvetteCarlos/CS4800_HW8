public class CheetosHandler extends SnackHandler {
    public CheetosHandler(SnackHandler next) {
        super(next);
    }
    public void handleRequest(String requestType) {
        if(requestType.equals("Cheetos")) {
            System.out.println("Handling digest authentication request");
        } else {
            System.out.println("I was passed from Pepsi");
            super.handleRequest(requestType);
        }
    }
}

