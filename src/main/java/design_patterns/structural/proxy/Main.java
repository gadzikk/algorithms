package design_patterns.structural.proxy;

/**
 * Created by gadzik on 30.07.20.
 */
public class Main {
    public static void main(String[] args) {
        Internet internet = new ProxyInternet();
        try {
            internet.connectTo("geeksforgeeks.org");
            internet.connectTo("abc.com");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
