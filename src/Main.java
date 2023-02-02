import java.util.Scanner;

public class Main {
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
