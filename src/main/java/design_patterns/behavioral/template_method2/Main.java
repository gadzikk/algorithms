package design_patterns.behavioral.template_method2;

/**
 * Created by gadzik on 29.07.20.
 */
public class Main {
    public static void main(String[] args) {
        OrderProcessTemplate netOrder = new NetOrder();
        netOrder.processOrder(true);
        System.out.println();
        OrderProcessTemplate storeOrder = new StoreOrder();
        storeOrder.processOrder(true);
    }
}
