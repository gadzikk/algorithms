package design_patterns.behavioral.template_method2;

/**
 * Created by gadzik on 29.07.20.
 */
public class StoreOrder extends OrderProcessTemplate {

    @Override
    public void doSelect() {
        System.out.println("Customer chooses the item from shelf.");
    }

    @Override
    public void doPayment() {
        System.out.println("Pays at counter through cash/POS");
    }

    @Override
    public void doDelivery() {
        System.out.println("Item delivered to in delivery counter.");
    }
}
