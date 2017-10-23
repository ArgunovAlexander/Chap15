public class RyanAndMonicaJob implements Runnable {
    private BankAccount account=new BankAccount();

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            makeWithdrawal(10);
            if (account.getBalance() < 0) {
                System.out.println("Overdrawn!");
            }
        }
    }
    public void makeWithdrawal(int amount) {
        if (account.getBalance()>=amount){
            System.out.println(Thread.currentThread().getName()+" is about to withdraw");
            try {
                System.out.println(Thread.currentThread().getName()+" is going to sleep");
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+" is woke up");
            account.withdraw(amount);
            System.out.println(Thread.currentThread().getName()+" completes the withdrawl");
        } else {
            System.out.println("Sorry, not enough for " +Thread.currentThread().getName());
        }

    }
    public static void main (String[] args) {
        Runnable theJob=new RyanAndMonicaJob();
        Thread ryan=new Thread(theJob);
        Thread monica=new Thread(theJob);
        ryan.setName("Ryan");
        monica.setName("Monica");
        ryan.start();
        monica.start();
    }
}
