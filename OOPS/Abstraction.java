
// import java.util.*;

abstract class Animal{
    public void walk(){
        System.out.println("Animal is walking currently.");

    }
}

class Donkey extends Animal{
    public void walk(){
        System.out.println("Hello donkey is walking");
    }
    void hello(){
        System.out.println("hello");
    }
}

public class Abstraction{
    public static void main(String[] args) {
        Animal mk;
        mk = new Donkey();

        mk.walk();
        // Donkey nk = new Donkey();
        // nk.walk();

    }
}
