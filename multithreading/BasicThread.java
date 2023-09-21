class BasicThread{
    public static void main(String[] args) {
        Thread t = Thread.currentThread();
        System.out.println("Main Thread is : " + t.getName());
        t.setName("Main Thread");
        System.out.println("Main Thread is : " + t.getName());

    }
}