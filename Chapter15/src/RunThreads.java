public class RunThreads implements Runnable {

    public static void main(String [] args) {
        RunThreads myR=new RunThreads();
        Thread alpha=new Thread(myR);
        Thread beta=new Thread(myR);
        alpha.setName("Alpha thread");
        beta.setName("Beta thread");
        alpha.start();
        beta.start();

    }

    @Override
    public void run() {
        for (int i = 0; i < 25; i++) {
            String treadName = Thread.currentThread().getName();
            System.out.println(treadName + " is running");
        }
    }
}
