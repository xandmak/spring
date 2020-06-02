package test;

public class Dog implements Animal {
    public void voice() {
        System.out.println("gav");
    }

    private static final Dog instance = new Dog();

    public static Dog getInstance() {
        return instance;
    }

    public void init() {
        System.out.println("Dog was init");
    }

    public void destroy() {
        System.out.println("Dog was destroy");
    }
}
