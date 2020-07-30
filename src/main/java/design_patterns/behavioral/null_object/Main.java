package design_patterns.behavioral.null_object;

/**
 * Created by gadzik on 29.07.20.
 */
public class Main {
    public static void main(String[] args) {
        Emp emp1 = EmpData.getClient("Lokesh");
        Emp emp2 = EmpData.getClient("Kushagra");
        Emp emp3 = EmpData.getClient("Vikram");
        Emp emp4 = EmpData.getClient("Rishabh");


        System.out.println(emp1.getName());
        System.out.println(emp2.getName());
        System.out.println(emp3.getName());
        System.out.println(emp4.getName());
    }
}
