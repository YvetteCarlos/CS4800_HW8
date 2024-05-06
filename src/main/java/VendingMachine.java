import java.util.ArrayList;
import java.util.List;

interface StateOfVendingMachine{
Void SelectSnack(String snack);
Void InsertMoney(Double money);

Void DispenseSnack();
}

class IdleState implements StateOfVendingMachine{
    private StateOfVendingMachine currentState;

    public IdleState(StateOfVendingMachine currentState) {
        this.currentState = currentState;
    }
    @Override
    public Void SelectSnack(String snack) {
        currentState = new WaitState(snack);
        return null;
    }

    @Override
    public Void InsertMoney(Double money) {
        return null;
    }//vending machine starts in idle state

    @Override
    public Void DispenseSnack() {
        return null;
    }

}
class WaitState implements StateOfVendingMachine{
    private String selectedSnack;
    @Override
    public Void SelectSnack(String snack) {
        this.selectedSnack = snack;
        return null;
    }

    @Override
    public Void InsertMoney(Double money) {
        currentState = new DispensingState(selectedSnack, money);
        return null;
    }

    @Override
    public Void DispenseSnack() {
        return null;
    }
    /// -waiting for money// if money inserted then dispense item if enough quantity or return money
}

  class DispensingState implements StateOfVendingMachine{

      private String selectedSnack;
      private Double insertedMoney;

      public DispensingState(String snack, Double money) {
          this.selectedSnack = snack;
          this.insertedMoney = money;
      }
      @Override
      public Void SelectSnack(String snack) {
          return null;
      }

      @Override
      public Void InsertMoney(Double money) {
          return null;
      }

      @Override
      public Void DispenseSnack() {
          currentState = new IdleState(); // Transition back to IdleState
          return null;
      }

}


     class Snack {
        private String name;
        private Double price;
        private int quantity;

        public Snack(String name, Double price, int quantity) {
            this.name = name;
            this.price = price;
            this.quantity = quantity;

        }

        public void setName(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setPrice(Double price) {
            this.price = price;
        }

        public Double getPrice() {
            return price;
        }

        public void setQuantity(Integer quantity) {
            this.quantity = quantity;
        }

        public Integer getQuantity() {
            return quantity;
        }


    }

    class VendingMachine{
    private List<Snack> snacks;
    private StateOfVendingMachine currentState;
    private SnackHandler handler;


        public VendingMachine(List<Snack> snacks) {
            this.snacks = snacks;
            this.currentState = new IdleState(this);
        }

         void selectSnack(String snackName) {
            currentState.selectSnack(snackName);
        }

         void insertMoney(Double money) {
            currentState.insertMoney(money);
        }

         void dispenseSnack() {
            currentState.dispenseSnack();
        }

    }


class Driver{
    public static void main(String[] args) {
        // Creating snacks
        List<Snack> snacks = new ArrayList<>();
        snacks.add(new Snack("Coke", 1.5, 10));
        snacks.add(new Snack("Pepsi", 1.5, 10));
        snacks.add(new Snack("Cheetos", 1.0, 5));
        snacks.add(new Snack("Doritos", 1.25, 8));
        snacks.add(new Snack("KitKat", 1.75, 6));
        snacks.add(new Snack("Snickers", 2.0, 0));

        VendingMachine vendingMachine = new VendingMachine(snacks);

        vendingMachine.selectSnack("Coke");
        vendingMachine.insertMoney(2.0);
        vendingMachine.dispenseSnack();


        SnackHandler chain = new CokeHandler(new PepsiHandler(new CheetosHandler(new DoritosHandler(new KitKatsHandler(new SnickersHandler(null))))));
        chain.handleRequest("Coke");
        chain.handleRequest("Pepsi");
        chain.handleRequest("Cheetos");
        chain.handleRequest("Doritos");
        chain.handleRequest("KitKat");
        chain.handleRequest("Snickers");





    }
}