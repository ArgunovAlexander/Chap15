public class MyRunnable implements Runnable {
    @Override
    public void run() {
        go();
    }
    public void go() {
        doFinal();
    }
    public void doFinal() {
        System.out.println("Doing something");
    }

    public static void main (String [] args) {
        for (int i = 0; i < 25; i++) {
            MyRunnable r = new MyRunnable();
            Thread t = new Thread(r);
            t.start();
            System.out.println("Do main");
        }
    }
}
