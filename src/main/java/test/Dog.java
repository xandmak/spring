package test;

public class Dog implements Animal {
    public void voice() {
        System.out.println("gav");
    }

    public void init() {
        System.out.println("Dog was init");
    }

    public void destroy() {
        System.out.println("Dog was destroy");
    }
}
