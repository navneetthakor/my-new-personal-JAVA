interface Ianimal {
    void walk();
}

class Hourse implements Ianimal {
    public void walk() {
        System.out.println("Hourse is walking.");
    }
}

public class Interface {
    public static void main(String[] args) {
        Hourse nk = new Hourse();
        nk.walk();
    }
}
