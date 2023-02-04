import java.util.Scanner;

class Philosopher extends Thread {
    private int philosopher;
    private Chopsticks chopsticks;

    Philosopher(int philosopher, Chopsticks chopsticks) {
        this.philosopher = philosopher;
        this.chopsticks  = chopsticks;
    }

    public void run() {
        try {
            while (true) {
                chopsticks.eat(philosopher);
            }
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {

        System.out.print("Enter the number of philosophers: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Chopsticks    chopsticks   = new Chopsticks(n);
        Philosopher[] philosophers = new Philosopher[n];

        for (int i = 0; i < n; i++) {
            philosophers[i] = new Philosopher(i, chopsticks);
        }
        for (int i = 0; i < n; i++) {
            philosophers[i].start();
        }
    }
}