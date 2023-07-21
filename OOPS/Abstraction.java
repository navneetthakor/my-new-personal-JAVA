
import java.util.*;

abstract class Animal{
    public void walk(){
        System.out.println("Animal is walking currently.");

    }
}

class Donkey extends Animal{
    public void walk(){
        System.out.println("Hello donkey is walking");
    }
}

public class Abstraction{
    public static void main(String[] args) {
        // Animal nk = new Animal();
        Donkey nk = new Donkey();
        nk.walk();

    }
}
