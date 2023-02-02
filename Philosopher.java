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
}